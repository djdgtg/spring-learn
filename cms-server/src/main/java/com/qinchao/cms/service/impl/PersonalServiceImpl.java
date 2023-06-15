package com.qinchao.cms.service.impl;

import com.qinchao.cms.aspect.LogType;
import com.qinchao.cms.entity.*;
import com.qinchao.cms.entity.custom.*;
import com.qinchao.cms.mapper.BaseDicsMapper;
import com.qinchao.cms.mapper.BaseLogsMapper;
import com.qinchao.cms.mapper.BaseMenusMapper;
import com.qinchao.cms.mapper.DbLibrarynexusMapper;
import com.qinchao.cms.mapper.custom.ClassesManageCustomMapper;
import com.qinchao.cms.mapper.custom.DatalibrarysManageCustomMapper;
import com.qinchao.cms.mapper.custom.MetadatasManageCustomMapper;
import com.qinchao.cms.service.PersonalService;
import com.qinchao.cms.utils.ActionResult;
import com.qinchao.cms.utils.ExcelUtil;
import com.qinchao.common.minio.MinioUtils;
import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
@Service
public class PersonalServiceImpl implements PersonalService {

    @Value("${minio.endpoint}")
    private String fileserverurl;

    @Autowired
    private MinioUtils minioUtils;

    @Autowired
    private MetadatasManageCustomMapper metadatasCustomMapper;

    @Autowired
    private DatalibrarysManageCustomMapper datalibrarysCustomMapper;

    @Autowired
    private BaseDicsMapper dicsMapper;

    @Autowired
    private DbLibrarynexusMapper librarynexusMapper;

    @Autowired
    private ClassesManageCustomMapper classesCustomMapper;

    @Autowired
    private BaseLogsMapper logsMapper;

    @Autowired
    private BaseMenusMapper menusMapper;

    @Override
    public ActionResult uploadFile(MultipartFile file) {
        try {
            minioUtils.uploadInputStream("learn", file.getOriginalFilename(), file.getInputStream(), file.getContentType());
            return ActionResult.ok("/learn/" + file.getOriginalFilename());
        } catch (Exception e) {
            return ActionResult.build(-1, "文件上传失败！");
        }
    }

    @Override
    public HashMap<String, Object> uploadkindeditor(MultipartFile file) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            minioUtils.uploadInputStream("learn", file.getOriginalFilename(), file.getInputStream(), file.getContentType());
            String url = fileserverurl + "/learn/" + file.getOriginalFilename();
            result.put("error", 0);
            result.put("url", url);
        } catch (Exception e) {
            result.put("error", 1);
            result.put("message", "上传失败！");
        }
        return result;
    }

    @SneakyThrows
    @Override
    public ActionResult importFile(MultipartFile file, DataLibrarysManageSearchBean searchBean, HttpServletRequest request) {
        String filePath = request.getSession().getServletContext().getRealPath("/upload");
        String fileName = file.getOriginalFilename();
        String databaseName = searchBean.getDatabaseName();
        String mouldId = searchBean.getMouldId();
        BaseManagers loginUser = (BaseManagers) request.getSession().getAttribute("USER_VALUE_OBJECT");
        // 生成上传的文件对象
        File target = new File(filePath, Objects.requireNonNull(fileName));
        if (target.exists()) {
            target.delete();
        }
        int savetotal = 0;
        int rows;
        int nums = 0;
        FileUtils.copyInputStreamToFile(file.getInputStream(), target);
        CustomQueryBean creatoruser = new CustomQueryBean();
        creatoruser.setName("creatorid");
        creatoruser.setNameValue(loginUser.getUserid().toString());

        CustomQueryBean status = new CustomQueryBean();
        status.setName("status");
        status.setNameValue("1");

        FileInputStream fis = new FileInputStream(filePath + "\\" + fileName);
        XSSFWorkbook wookbook = new XSSFWorkbook(fis); // 创建对Excel工作簿文件的引用
        XSSFSheet sheet = wookbook.getSheetAt(0); // 在Excel文档中，第一张工作表的缺省索引是0
        rows = sheet.getPhysicalNumberOfRows(); // 获取到Excel文件中的所有行数
        Map<Integer, String> keys = new HashMap<>();
        int cells = 0;
        // 遍历行（第1行 表头） 准备Map里的key
        XSSFRow firstRow = sheet.getRow(0);
        if (firstRow != null) {
            // 获取到Excel文件中的所有的列
            cells = firstRow.getPhysicalNumberOfCells();
            // 遍历列
            for (int j = 0; j < cells; j++) {
                // 获取到列的值
                XSSFCell cell = firstRow.getCell(j);
                String cellValue = getCellValue(cell);
                if (cellValue != null && cellValue.split("###").length == 2) {
                    cellValue = cellValue.split("###")[1];
                }
                keys.put(j, cellValue);
            }
        }
        // 遍历行（从第二行开始）
        for (int i = 1; i < rows; i++) {
            List<CustomQueryBean> returnlist = new ArrayList<>();
            // 保存用户信息
            returnlist.add(creatoruser);
            returnlist.add(status);
            // 读取左上端单元格(从第二行开始)
            XSSFRow row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                // 遍历列
                for (int j = 0; j < cells; j++) {
                    CustomQueryBean bean = new CustomQueryBean();
                    // 获取到列的值
                    XSSFCell cell = row.getCell(j);
                    String cellValue = getCellValue(cell);
                    if (cellValue != null && cellValue.trim().length() > 0) {
                        bean.setName(keys.get(j));
                        bean.setNameValue(cellValue);
                        returnlist.add(bean);
                    }
                }
                // 一行所有的列数据读取完毕
                // 入库
                boolean b = addExcelData(databaseName, mouldId, returnlist);
                if (b) {
                    savetotal++;
                }
            }
            if (returnlist.size() > 2) {
                nums++;
            }
        }
        // 所有的行读完
        return ActionResult.ok("成功保存" + savetotal + "/" + nums + "条数据");
    }

    private static String getCellValue(XSSFCell cell) {
        DecimalFormat df = new DecimalFormat("#");
        String cellValue = null;
        if (cell == null)
            return null;
        switch (cell.getCellType()) {
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    cellValue = sdf.format(DateUtil.getJavaDate(cell.getNumericCellValue()));
                    break;
                }
                cellValue = df.format(cell.getNumericCellValue());
                break;
            case STRING:
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case FORMULA:
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case ERROR:
                cellValue = String.valueOf(cell.getErrorCellValue());
                break;
        }
        if (cellValue != null && cellValue.trim().length() == 0) {
            cellValue = null;
        }
        return cellValue;
    }


    private boolean addExcelData(String databaseName, String mouldId, List<CustomQueryBean> queryList) {
        StringBuilder nameSql = new StringBuilder();
        StringBuilder valueSql = new StringBuilder();
        List<MetadatasCustomBean> list = metadatasCustomMapper.selectByExample(mouldId);
        if (queryList.size() > 2) {
            for (CustomQueryBean customQueryBean : queryList) {
                String namevalue = customQueryBean.getNameValue();
                if (customQueryBean.getName() != null && !customQueryBean.getName().equals("undefined") && customQueryBean.getNameValue() != null && !customQueryBean.getNameValue().equals("undefined")) {
                    if (list != null) {
                        for (MetadatasCustomBean metadatasCustomBean : list) {
                            if (metadatasCustomBean.getColumnname().equals(customQueryBean.getName())) {
                                if (metadatasCustomBean.getColumntype().equals(3) || metadatasCustomBean.getColumntype().equals(4)) {
                                    if (metadatasCustomBean.getColumnsource().equals(1)) {
                                        String[] split = customQueryBean.getNameValue().split("-");
                                        namevalue = split[0];
                                    }
                                }
                            }
                        }
                    }
                    nameSql.append(customQueryBean.getName()).append(",");
                    valueSql.append("'").append(namevalue).append("',");
                }
            }
        }
        String nameSqlStr = nameSql.substring(0, nameSql.length() - 1);
        String valueSqlStr = valueSql.substring(0, valueSql.length() - 1);
        String sql = "insert into " + databaseName + " (" + nameSqlStr + ") values(" + valueSqlStr + ")";
        int inRes = datalibrarysCustomMapper.alterTable(sql);
        return inRes > 0;
    }

    @SneakyThrows
    @Override
    public void exportModelExcel(List<DbMetadatas> metadataList, HttpServletResponse response,
                                 HttpServletRequest request, String databasecname, String type, String databaseName, String mouldId) {
        OutputStream ouputStream = response.getOutputStream();

        // 动态列获取
        StringBuilder colNames = new StringBuilder();
        //下拉框数据
        List<String[]> downData = new ArrayList<>();
        List<Integer> downRows = new ArrayList<>();
        List<Integer> datetimelist = new ArrayList<>();
        boolean b = false;
        for (int i = 0; i < metadataList.size(); i++) {
            if (b) {
                colNames.append(",");
            }
            colNames.append(metadataList.get(i).getColumncname()).append("###").append(metadataList.get(i).getColumnname());
            b = true;
            if (metadataList.get(i).getColumntype() == 3) {//下拉单选
                if (metadataList.get(i).getColumnsource() == 1) {//字典表
                    BaseDicsExample example = new BaseDicsExample();
                    example.createCriteria().andDictypeEqualTo(metadataList.get(i).getColumntyperule()).andIsdictypeEqualTo(0);
                    List<BaseDics> dics = dicsMapper.selectByExample(example);
                    List<String> diclist = new ArrayList<>();
                    for (BaseDics baseDics : dics) {
                        diclist.add(baseDics.getDicvalue() + "-" + baseDics.getDicname());
                    }
                    String[] arr = new String[diclist.size()];
                    downData.add(diclist.toArray(arr));
                    downRows.add(i);
                } else if (metadataList.get(i).getColumnsource() == 3) {//资源表
                    DbLibrarynexusExample example = new DbLibrarynexusExample();
                    example.createCriteria().andMdbfieldEqualTo(metadataList.get(i).getColumnname()).andMdbnameEqualTo(databaseName);
                    List<DbLibrarynexus> list = librarynexusMapper.selectByExample(example);
                    String sdbsql = list.get(0).getSdbsql();
                    List<LinkedHashMap<String, Object>> maplist = datalibrarysCustomMapper.getResList(sdbsql);
                    List<String> reslist = new ArrayList<>();
                    List<Object> str = new ArrayList<>();
                    for (LinkedHashMap<String, Object> linkedHashMap : maplist) {
                        Set<Entry<String, Object>> set = linkedHashMap.entrySet();
                        for (Entry<String, Object> entry : set) {
                            str.add(entry.getValue());
                        }
                    }
                    for (int j = 0; j < str.size() - 1; j += 2) {
                        reslist.add(str.get(j) + "-" + str.get(j + 1));
                    }
                    String[] arr = new String[list.size()];
                    downData.add(reslist.toArray(arr));
                    downRows.add(i);
                }
            } else if (metadataList.get(i).getColumntype() == 10 || metadataList.get(i).getColumntype() == 11) {//日期时间
                datetimelist.add(i);
            }
        }
        // 处理列名字符串
        List<String> headColumnName = Arrays.asList(colNames.toString().split(","));
        // 写数据到Excel文件
        XSSFWorkbook workbook = exportExcel(headColumnName, type, databaseName, mouldId, datetimelist, downData, downRows);
        String filename = databasecname + "导入模板.xlsx";
        if (("1").equals(type)) {
            filename = databasecname + "数据导出" + DateFormatUtils.format(new Date(), "yyyy-MM-dd") + ".xlsx";
        }
        String downloadFileName;
        String agent = request.getHeader("USER-AGENT");
        if (agent != null && agent.toLowerCase().indexOf("firefox") > 0) {
            downloadFileName = "=?UTF-8?B?" + (new String(Base64.encodeBase64(filename.getBytes(StandardCharsets.UTF_8)))) + "?=";
        } else {
            downloadFileName = URLEncoder.encode(filename, "UTF-8");
        }
        response.setHeader("Content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + downloadFileName);
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("UTF-8");

        workbook.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }

    private XSSFWorkbook exportExcel(List<String> headColumnName, String type, String databaseName, String mouldId, List<Integer> datetimelist, List<String[]> downData, List<Integer> downRows) {

        // 写数据到Excel文件
        XSSFWorkbook workBook = new XSSFWorkbook();
        // 设置表头字体
        Font headfont = workBook.createFont();
        headfont.setFontName("黑体");
        headfont.setFontHeightInPoints((short) 9);// 字体大小
        headfont.setBold(true);// 加粗

        CellStyle headStyle = workBook.createCellStyle(); // 表头第一列的样式
        headStyle.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.index); // 前景色设置
        headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND); // 填充模式 设置
        headStyle.setFont(headfont);
        headStyle.setAlignment(HorizontalAlignment.CENTER);// 左右居中
        headStyle.setVerticalAlignment(VerticalAlignment.CENTER);// 上下居中
        headStyle.setWrapText(true);
        headStyle.setBorderRight(BorderStyle.THIN);
        headStyle.setRightBorderColor(IndexedColors.BLACK.index);
        headStyle.setBorderTop(BorderStyle.THIN);
        headStyle.setTopBorderColor(IndexedColors.BLACK.index);
        // 表格正文样式，背景色,边框
        CellStyle style = workBook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.index); // 前景色设置
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // 填充模式 设置
        style.setBorderBottom(BorderStyle.THIN); // 设置单元格的边框为粗体
        style.setBottomBorderColor(IndexedColors.BLACK.index); // 设置单元格的边框颜色
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.index);
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.index);

        Row row;
        Cell cell;
        XSSFSheet sheet;
        sheet = workBook.createSheet("资源数据");
        row = sheet.createRow(0);// 第一行，标题
        // 如果没有设置要下载的字段
        if (headColumnName.size() == 1 && StringUtils.isEmpty(headColumnName.get(0))) {
            cell = row.createCell(0);
            cell.setCellValue("没有要下载的数据！");
            return workBook;
        }
        // 设置第一行标题
        for (int i = 0; i < headColumnName.size(); i++) {
            cell = row.createCell(i);
            cell.setCellValue(headColumnName.get(i));
            cell.setCellStyle(headStyle);
            // 设置列宽
            sheet.setColumnWidth(i, 18 * 256);
        }
        if (!StringUtils.isEmpty(type) && type.equals("0")) {//导出模板
            ExcelUtil.getExcelTemplate(workBook, sheet, headColumnName, downData, downRows);
            XSSFCellStyle datestyle = workBook.createCellStyle();
            CreationHelper creationHelper = workBook.getCreationHelper();
            datestyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd hh:mm:ss"));
            // 创建行
            for (int i = 1; i < 100; i++) {
                row = sheet.createRow(i);
                for (Integer integer : datetimelist) {//日期时间
                    cell = row.createCell(integer);
                    cell.setCellStyle(datestyle);
                }
            }
        } else if (!StringUtils.isEmpty(type) && type.equals("1")) {// 如果是导出全部数据 设置正文内容
            DbMetadatasExample example = new DbMetadatasExample();
            example.createCriteria().andMouldidEqualTo(Integer.valueOf(mouldId));
            // 查出数据
            DataLibrarysManageSearchBean dataLibrarysManageSearchBean = new DataLibrarysManageSearchBean();
            dataLibrarysManageSearchBean.setDatabaseName(databaseName);
            dataLibrarysManageSearchBean.setMouldId(mouldId);
            ListInfo result = getSelfDataList(dataLibrarysManageSearchBean);

            List<Map<String, String>> listNew = result.getList();

            for (int i = 0, len = listNew.size(); i < len; i++) {// 循环创建数据行
                row = sheet.createRow(i + 1);
                for (int j = 0; j < headColumnName.size(); j++) {
                    cell = row.createCell(j);
                    String fieldName = "";
                    if (null != headColumnName.get(j) && headColumnName.get(j).split("###").length > 1) {
                        fieldName = headColumnName.get(j).split("###")[1];
                    }
                    String cellValue = String.valueOf(listNew.get(i).get(fieldName));
                    if ("&nbsp;".equals(cellValue) || StringUtils.isEmpty(cellValue) || "null".equals(cellValue)) {
                        cellValue = "";
                    }
                    if (cellValue.length() >= 32767) {
                        cellValue = cellValue.substring(0, 32000) + "...";
                    }
                    cell.setCellValue(cellValue);
                    cell.setCellStyle(style);
                }
            }
        }

        return workBook;
    }

    private ListInfo getSelfDataList(DataLibrarysManageSearchBean dataLibrarysManageSearchBean) {

        ListInfo listInfo = new ListInfo();
        // 获取db基本信息
        List<DatalibrarysCustomBean> dbList = datalibrarysCustomMapper.selectByExample(dataLibrarysManageSearchBean);
        if (dbList != null && dbList.size() == 1) {
            DatalibrarysCustomBean db = dbList.get(0);
            // 获取资源库元数据
            List<MetadatasCustomBean> metaList = metadatasCustomMapper.selectByExample(db.getMouldid().toString());

            if (metaList == null) {
                metaList = new ArrayList<>();
            }

            StringBuilder whereSql = new StringBuilder(" where status != -1 ");
            if (dataLibrarysManageSearchBean.getUserId() > 0) {
                whereSql.append(" and creatorid=").append(dataLibrarysManageSearchBean.getUserId());
            }

            List<MetadatasCustomBean> rMetaList = new ArrayList<>();
            StringBuilder showCol = new StringBuilder();
            for (MetadatasCustomBean metadatasCustomBean : metaList) {
                if (null != metadatasCustomBean.getImportandexportshow()
                        && metadatasCustomBean.getImportandexportshow() == 1) {
                    if (metadatasCustomBean.getColumntype() == 10) {
                        showCol.append("DATE_FORMAT(").append(metadatasCustomBean.getColumnname()).append(",'%y-%m-%d %H:%i:%s')").append(metadatasCustomBean.getColumnname()).append(",");
                    } else {
                        showCol.append(metadatasCustomBean.getColumnname()).append(",");
                    }
                    if (metadatasCustomBean.getColumntype() == Constants.COLUMNTYPE_RADIO
                            || metadatasCustomBean.getColumntype() == Constants.COLUMNTYPE_CHECKBOX) {
                        rMetaList.add(metadatasCustomBean);
                    }
                }
            }

            showCol = new StringBuilder(showCol.substring(0, showCol.length() - 1));

            String sqlCount = "select count(1) from " + db.getDatabasename() + " " + whereSql;
            int count = datalibrarysCustomMapper.getResCount(sqlCount);
            String sqlList;
            if (count > 0) {
                if (showCol.toString().contains("creatorid")) {
                    showCol = new StringBuilder(showCol.toString().replaceAll("creatorid,", ""));
                    showCol.append(",u.RealName as creatorid ");
                    sqlList = "select " + showCol + " from " + db.getDatabasename()
                            + " db LEFT JOIN (select UserID,RealName from base_managers) u on db.creatorid = u.UserID "
                            + whereSql + " order by seqid desc ";
                } else {
                    sqlList = "select " + showCol + " from " + db.getDatabasename() + whereSql
                            + " order by seqid desc ";
                }
                List<LinkedHashMap<String, Object>> resList = datalibrarysCustomMapper.getResList(sqlList);

                List<LinkedHashMap<String, Object>> resultList = new ArrayList<>();

                if (rMetaList.size() > 0) {
                    Map<String, List<?>> list = new HashMap<>();
                    for (MetadatasCustomBean metaCustom : rMetaList) {
                        switch (metaCustom.getColumnsource()) {
                            case Constants.COlUMNSOURCE_DIC:
                                BaseDicsExample dicExample = new BaseDicsExample();
                                dicExample.createCriteria().andDictypeEqualTo(metaCustom.getColumntyperule()).andIsdictypeEqualTo(0);
                                List<BaseDics> dic = dicsMapper.selectByExample(dicExample);
                                list.put(metaCustom.getColumnname(), dic);
                                break;
                            case Constants.COlUMNSOURCE_CLASS:
                                BaseClassesExample classExample = new BaseClassesExample();
                                String typeRule = metaCustom.getColumntyperule();
                                if (!StringUtils.isEmpty(typeRule)) {
                                    classExample.createCriteria().andClassidEqualTo(Integer.valueOf(typeRule));
                                }
                                List<ClassesCustomBean> classes = classesCustomMapper.selectByExample(classExample);
                                list.put(metaCustom.getColumnname(), classes);
                                break;
                            case Constants.COlUMNSOURCE_DB:
                                DbLibrarynexusExample nexusExample = new DbLibrarynexusExample();

                                nexusExample.createCriteria().andMdbfieldEqualTo(metaCustom.getColumnname()).
                                        andMdbnameEqualTo(dataLibrarysManageSearchBean.getDatabaseName());

                                List<DbLibrarynexus> nexusList = librarynexusMapper.selectByExample(nexusExample);
                                List<List<LinkedHashMap<String, Object>>> nexusResList = new ArrayList<>();
                                if (nexusList != null) {
                                    for (DbLibrarynexus dbLibraryNexus : nexusList) {
                                        if (dbLibraryNexus != null) {
                                            List<LinkedHashMap<String, Object>> nexusSqlList = datalibrarysCustomMapper
                                                    .getResList(dbLibraryNexus.getSdbsql());
                                            if (nexusSqlList != null && nexusSqlList.size() > 0) {
                                                nexusResList.add(nexusSqlList);
                                            }
                                        }
                                    }
                                }
                                list.put(metaCustom.getColumnname(), nexusResList);
                                break;
                        }
                        for (LinkedHashMap<String, Object> resMap : resList) {
                            resMap.put(metaCustom.getColumnname() + "Name", null);
                        }
                    }
                    for (LinkedHashMap<String, Object> object : resList) {
                        for (MetadatasCustomBean metaCustomBean : rMetaList) {
                            if (list.size() == 0) {
                                continue;
                            }
                            if (!list.containsKey(metaCustomBean.getColumnname())) {
                                continue;
                            }
                            Object value = object.get(metaCustomBean.getColumnname());
                            if (value == null || value.toString().isEmpty()) {
                                continue;
                            }
                            List<?> valueList = list.get(metaCustomBean.getColumnname());
                            StringBuilder str = new StringBuilder();
                            String valueStr = value.toString();
                            for (Object v : valueList) {
                                if (v.getClass().equals(BaseDics.class)) {
                                    BaseDics dic = (BaseDics) v;
                                    if (valueStr.contains(dic.getDicvalue())) {
                                        str.append(dic.getDicname()).append(",");
                                    }
                                } else if (v.getClass().equals(ClassesCustomBean.class)) {
                                    ClassesCustomBean cls = (ClassesCustomBean) v;
                                    if (valueStr.contains(cls.getClassid().toString())) {
                                        str.append(cls.getClassname()).append(",");
                                    }
                                } else {
                                    List<LinkedHashMap<String, Object>> nexusL = (List<LinkedHashMap<String, Object>>) v;
                                    if (nexusL.size() > 0) {
                                        for (LinkedHashMap<String, Object> map : nexusL) {
                                            if (map != null && map.size() > 1) {
                                                Collection<Object> mapValue = map.values();
                                                Object[] mapValueArr = mapValue.toArray();
                                                if (valueStr.contains(mapValueArr[0].toString())) {
                                                    str.append(mapValueArr[1]).append(",");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (str.length() > 1) {
                                str = new StringBuilder(str.substring(0, str.length() - 1));
                            }
                            object.put(metaCustomBean.getColumnname(), str.toString());
                        }
                        resultList.add(object);
                    }
                } else {
                    resultList = resList;
                }
                listInfo.setLength(count);
                listInfo.setList(resultList);
                return listInfo;
            }
        }

        return listInfo;
    }


    @Override
    public ActionResult updateResByFiledBatch(DataLibrarysManageSearchBean searchBean, String fieldval,
                                              String fieldname, HttpServletRequest request) {
        StringBuilder delSql = new StringBuilder("update ");
        String resIds = searchBean.getResIds();
        if (StringUtils.isNoneEmpty(resIds)) {
            delSql.append(searchBean.getDatabaseName()).append(" set ").append(fieldname).append(" = '").append(fieldval).append("' where seqid in(");
            delSql.append(resIds).append(")");
            int count = datalibrarysCustomMapper.alterTable(delSql.toString());
            if (count > 0) {
                BaseManagers loginUser = (BaseManagers) request.getSession().getAttribute("USER_VALUE_OBJECT");
                String mouldId = searchBean.getMouldId();
                BaseMenusExample example = new BaseMenusExample();
                example.createCriteria().andPathLike("%mouldId=" + mouldId);
                List<BaseMenus> menus = menusMapper.selectByExample(example);
                BaseLogs logs = new BaseLogs();
                logs.setCreatetime(new Date());
                String logdetail = "修改了" + menus.get(0).getMenuname() + count + "条数据状态";
                logs.setLogdetail(logdetail);
                logs.setCreator(loginUser.getUserid());
                logs.setLogtype(Integer.valueOf(LogType.OPERATION_3));
                logsMapper.insert(logs);
            }
        }
        return ActionResult.ok();
    }

    @Override
    public boolean checkunique(String columnname, String value, Integer seqid, String databasename) {
        StringBuilder sb = new StringBuilder();
        sb.append("select count(1) from ").append(databasename).append(" Where ").append(columnname)
                .append("='").append(value).append("'");
        if (seqid != null) {
            sb.append(" and ").append("seqid!= ").append(seqid);
        }
        return datalibrarysCustomMapper.checkunique(sb.toString()) > 0;
    }

    @Override
    public String getfileServerUrl() {
        return fileserverurl;
    }


}
