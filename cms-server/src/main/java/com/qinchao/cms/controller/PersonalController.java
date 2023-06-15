package com.qinchao.cms.controller;

import com.qinchao.cms.aspect.LogAnnotation;
import com.qinchao.cms.aspect.LogType;
import com.qinchao.cms.entity.custom.DataLibrarysManageSearchBean;
import com.qinchao.cms.entity.custom.QueryList;
import com.qinchao.cms.service.PersonalService;
import com.qinchao.cms.utils.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
@Controller
@RequestMapping("/personal")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @RequestMapping("/uploadFile")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_7, logdetail = "文件上传")
    public ActionResult uploadFile(MultipartFile file) {
        return personalService.uploadFile(file);
    }

    @RequestMapping("/uploadkindeditor")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_7, logdetail = "富文本图片上传")
    public Map<String, Object> uploadkindeditor(MultipartFile file) {
        return personalService.uploadkindeditor(file);
    }

    @RequestMapping("/importFile")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_7, logdetail = "excel数据导入")
    public ActionResult importFile(MultipartFile file, DataLibrarysManageSearchBean searchBean, HttpServletRequest request) {
        return personalService.importFile(file, searchBean, request);
    }

    @RequestMapping("/updateResByFiledBatch")
    @ResponseBody
    public ActionResult updateResByFiledBatch(DataLibrarysManageSearchBean searchBean, String fieldval, String fieldname, HttpServletRequest request) {
        return personalService.updateResByFiledBatch(searchBean, fieldval, fieldname, request);
    }


    @RequestMapping("/checkunique")
    @ResponseBody
    public Map<String, Object> checkunique(String columnname, Integer seqid, Integer index, QueryList queryList, String databasename) {
        String value = queryList.getQueryList().get(index).getNameValue();
        boolean result = personalService.checkunique(columnname, value, seqid, databasename);
        Map<String, Object> map = new HashMap<>();
        map.put("valid", !result);
        return map;
    }

    @RequestMapping("/getfileServerUrl")
    @ResponseBody
    public String getfileServerUrl() {
        return personalService.getfileServerUrl();
    }
}
