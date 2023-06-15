package com.qinchao.cms.service.impl;

import com.qinchao.cms.entity.DbMetadatas;
import com.qinchao.cms.entity.DbMetadatasExample;
import com.qinchao.cms.entity.custom.*;
import com.qinchao.cms.mapper.DbMetadatasMapper;
import com.qinchao.cms.mapper.custom.DatalibrarysManageCustomMapper;
import com.qinchao.cms.mapper.custom.MetadatasManageCustomMapper;
import com.qinchao.cms.service.MetadatasService;
import com.qinchao.cms.utils.ActionResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
@Service
public class MetadatasServiceImpl implements MetadatasService {

    @Autowired
    private MetadatasManageCustomMapper metadatasCustomMapper;

    @Autowired
    private DbMetadatasMapper metadatasMapper;

    @Autowired
    private DatalibrarysManageCustomMapper datalibrarysCustomMapper;

    public ActionResult listCustom(String mouldId) {
        return ActionResult.ok(metadatasCustomMapper.selectByExample(mouldId));
    }

    public ActionResult add(DbMetadatas metadatas) {
        String dataType = dataTypeByFieldType(metadatas.getColumntype());
        metadatas.setDatatype(dataType);
        if (metadatas.getColumntype() == 3 || metadatas.getColumntype() == 4) {
            if (metadatas.getColumnsource() == null) {
                metadatas.setColumnsource(1);
            }
        }
        int count = metadatasMapper.insertSelective(metadatas);
        if (count > 0) {
            return ActionResult.ok();
        }
        return ActionResult.build(400, "操作失败！");
    }

    public ActionResult update(DbMetadatas metadatas) {
        String dataType = this.dataTypeByFieldType(metadatas.getColumntype());
        metadatas.setDatatype(dataType);
        if (metadatas.getColumntype() == 3 || metadatas.getColumntype() == 4) {
            if (metadatas.getColumnsource() == null) {
                metadatas.setColumnsource(1);
            }
        }
        int count = metadatasMapper.updateByPrimaryKeySelective(metadatas);
        if (count > 0) {
            return ActionResult.ok();
        }
        return ActionResult.build(400, "操作失败！");
    }

    public ActionResult delBatch(String metadataIds) {
        String[] ids = metadataIds.split(",");
        for (String id : ids) {
            metadatasMapper.deleteByPrimaryKey(Integer.valueOf(id));
        }
        return ActionResult.ok();
    }

    public String dataTypeByFieldType(int type) {

        switch (type) {
            case Constants.COLUMNTYPE_RICHTEXT:
                return "mediumtext";
            case Constants.COLUMNTYPE_DATE:
                return "date";
            case Constants.COLUMNTYPE_DATATIME:
                return "datetime";
            case Constants.COLUMNTYPE_INT:
                return "int";
            case Constants.COLUMNTYPE_RADIO:
                return "int";
            case Constants.COLUMNTYPE_DECIMAL:
                return "float";
            default:
                return "varchar";
        }
    }

    public boolean checkUniqueness(DbMetadatas metadatas) {
        return metadatasCustomMapper.checkUniqueness(metadatas) > 0;
    }

    public ActionResult list(Integer mouldId) {
        DbMetadatasExample example = new DbMetadatasExample();
        example.createCriteria().andMouldidEqualTo(mouldId);
        return ActionResult.ok(metadatasMapper.selectByExample(example));
    }

    public ActionResult listByDbName(String databaseName) {
        return ActionResult.ok(metadatasCustomMapper.selectByDbname(databaseName));
    }

    public List<DbMetadatas> getMetadataByField(MetadatasManageSearchBean searchBean) {
        DbMetadatasExample example = new DbMetadatasExample();
        DbMetadatasExample.Criteria criteria = example.createCriteria();

        example.setOrderByClause("Sorts");

        criteria.andMetadataidIsNotNull();

        List<DbMetadatas> metadataList = null;

        if (searchBean != null) {
            if (!StringUtils.isEmpty(searchBean.getMouldId())) {
                criteria.andMouldidEqualTo(Integer.valueOf(searchBean.getMouldId()));
            }
            String fieldName = searchBean.getFieldName();
            int fieldValue = searchBean.getFieldValue();
            if (!StringUtils.isEmpty(fieldName)) {
                if (fieldName.equals("FormShow")) {
                    criteria.andFormshowEqualTo(fieldValue);
                }
                if (fieldName.equals("SearchShow")) {
                    criteria.andSearchshowEqualTo(fieldValue);
                }
                if (fieldName.equals("GridShow")) {
                    criteria.andGridshowEqualTo(fieldValue);
                }
                if (fieldName.equals("ImportAndExportShow")) {
                    criteria.andImportandexportshowEqualTo(fieldValue);
                }
            }
            if (!StringUtils.isEmpty(searchBean.getMouldId())) {
                criteria.andMouldidEqualTo(Integer.valueOf(searchBean.getMouldId()));
            }

            metadataList = metadatasMapper.selectByExample(example);

            DataLibrarysManageSearchBean dataLibrarysManageSearchBean = new DataLibrarysManageSearchBean();
            dataLibrarysManageSearchBean.setDatabaseName(searchBean.getDatabaseName());

            List<DatalibrarysCustomBean> dbList = datalibrarysCustomMapper.selectByExample(dataLibrarysManageSearchBean);
            if (dbList != null) {
                List<MetadatasCustomBean> sysMetaList = Constants.initSysMetaList();
                for (MetadatasCustomBean meta : sysMetaList) {
                    boolean isNull = StringUtils.isEmpty(fieldName);
                    if (isNull || fieldName.equals("FormShow") && meta.getFormshow() == fieldValue || fieldName.equals("GridShow") && meta.getGridshow() == fieldValue || fieldName.equals("SearchShow") && meta.getSearchshow() == fieldValue) {
                        metadataList.add(meta);
                    }
                }
            }
        }
        return metadataList;
    }

}
