package com.qinchao.cms.service;


import com.qinchao.cms.entity.DbMetadatas;
import com.qinchao.cms.entity.custom.MetadatasManageSearchBean;
import com.qinchao.cms.utils.ActionResult;

import java.util.List;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface MetadatasService {

    ActionResult listCustom(String mouldId);

    ActionResult add(DbMetadatas metadatas);

    ActionResult update(DbMetadatas metadatas);

    ActionResult delBatch(String metadataIds);

    boolean checkUniqueness(DbMetadatas metadatas);

    ActionResult list(Integer mouldId);

    ActionResult listByDbName(String databaseName);

    List<DbMetadatas> getMetadataByField(MetadatasManageSearchBean searchBean);

}
