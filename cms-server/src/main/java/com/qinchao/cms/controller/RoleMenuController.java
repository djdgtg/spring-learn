package com.qinchao.cms.controller;

import com.qinchao.cms.aspect.LogAnnotation;
import com.qinchao.cms.aspect.LogType;
import com.qinchao.cms.service.RoleMenuService;
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
@RequestMapping("/rolemenu")
public class RoleMenuController {

    @Autowired
    private RoleMenuService roleMenuService;

    @RequestMapping("/list")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_5, logdetail = "查询角色菜单")
    public ActionResult list(Integer roleId) {
        return roleMenuService.listtree(roleId);
    }

    @RequestMapping("/setRoleMenus")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_3, logdetail = "配置角色菜单")
    public ActionResult setRoleMenus(Integer roleId, String menuIds) {
        return roleMenuService.setRoleMenus(roleId, menuIds);
    }

}
