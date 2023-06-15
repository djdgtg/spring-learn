package com.qinchao.cms.controller;

import com.qinchao.cms.aspect.LogAnnotation;
import com.qinchao.cms.aspect.LogType;
import com.qinchao.cms.entity.custom.CustomSearchBean;
import com.qinchao.cms.entity.custom.SysLogsManageSearchBean;
import com.qinchao.cms.service.SysLogsService;
import com.qinchao.cms.utils.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
@Controller
@RequestMapping("/syslogs")
public class SysLogsController {

    @Autowired
    private SysLogsService SysLogsService;

    @RequestMapping("/list")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_5, logdetail = "查询系统日志")
    public ActionResult list(SysLogsManageSearchBean sysLogsManageSearchBean, CustomSearchBean customSearchBean) {
        return SysLogsService.list(sysLogsManageSearchBean, customSearchBean);
    }
}
