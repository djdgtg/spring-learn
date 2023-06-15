package com.qinchao.cms.service;


import com.qinchao.cms.entity.BaseLogs;
import com.qinchao.cms.entity.custom.CustomSearchBean;
import com.qinchao.cms.entity.custom.SysLogsManageSearchBean;
import com.qinchao.cms.utils.ActionResult;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface SysLogsService {

    void insert(BaseLogs log);

    ActionResult list(SysLogsManageSearchBean sysLogsManageSearchBean, CustomSearchBean customSearchBean);

}
