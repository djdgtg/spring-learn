package com.qinchao.cms.service;


import com.qinchao.cms.entity.custom.CustomQueryBean;
import com.qinchao.cms.entity.custom.DataLibrarysManageSearchBean;
import com.qinchao.cms.entity.custom.DatalibrarysCustomBean;
import com.qinchao.cms.entity.custom.QueryList;
import com.qinchao.cms.utils.ActionResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface DatalibrarysService {

    ActionResult listCustom(DataLibrarysManageSearchBean searchBean);

    ActionResult list(String mouldId);

    boolean checkUniqueness(DatalibrarysCustomBean customBean);

    ActionResult update(DatalibrarysCustomBean customBean);

    ActionResult add(DatalibrarysCustomBean customBean);

    ActionResult updateStatus(String databaseid, String status);

    ActionResult getSelfDataList(DataLibrarysManageSearchBean searchBean, List<CustomQueryBean> queryList);

    ActionResult updateEditableField(Integer seqid, String field, String value, String databasename, String mouldId, HttpServletRequest request);

    ActionResult getSelfDbInfo(Integer seqId, String databaseName);

    ActionResult addRes(DataLibrarysManageSearchBean searchBean, QueryList queryList, HttpServletRequest request) throws Exception;

    ActionResult updateRes(DataLibrarysManageSearchBean searchBean, QueryList queryList, HttpServletRequest request) throws Exception;

    ActionResult delResBatch(DataLibrarysManageSearchBean searchBean, HttpServletRequest request);

    ActionResult delBatch(String databaseIds);

}
