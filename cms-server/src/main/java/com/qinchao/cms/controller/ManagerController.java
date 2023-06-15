package com.qinchao.cms.controller;

import com.qinchao.cms.aspect.LogAnnotation;
import com.qinchao.cms.aspect.LogType;
import com.qinchao.cms.entity.BaseLogs;
import com.qinchao.cms.entity.BaseManagers;
import com.qinchao.cms.entity.custom.ManagersCustomBean;
import com.qinchao.cms.entity.custom.ManagersManageSearchBean;
import com.qinchao.cms.service.ManagerService;
import com.qinchao.cms.service.SysLogsService;
import com.qinchao.cms.utils.ActionResult;
import com.qinchao.cms.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private SysLogsService sysLogsService;

    @RequestMapping(value = "/checklogin")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_1, logdetail = "用户登录")
    public ActionResult login(BaseManagers baseManagers, HttpServletRequest request) {
        BaseManagers result = managerService.login(baseManagers);
        if (result == null) {
            return ActionResult.build(-1, "用户名或密码错误，请重新登录！");
        }
        // 正常初始化数据
        BaseManagers loginUser = new BaseManagers();
        loginUser.setUserid(result.getUserid());
        loginUser.setLastlogintime(result.getLastlogintime());
        request.getSession().setAttribute("USER_VALUE_OBJECT", loginUser);
        // 更新用户登录信息
        result.setLastlogintime(new Date());
        managerService.updatelogintime(result);
        //重定向到主页面的跳转方法
        return ActionResult.ok();
    }

    @RequestMapping("/loadLoginUser")
    @ResponseBody
    public BaseManagers loadLoginUser(HttpServletRequest request) {
        BaseManagers loginUser = (BaseManagers) request.getSession().getAttribute("USER_VALUE_OBJECT");
        BaseManagers baseManagers = managerService.find(loginUser.getUserid());
        if (baseManagers != null) {
            baseManagers.setLastlogintime(loginUser.getLastlogintime());
        }
        return baseManagers;
    }

    @RequestMapping("/list")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_5, logdetail = "查询管理员")
    public List<ManagersCustomBean> list(ManagersManageSearchBean managers) {
        return managerService.list(managers);
    }

    @RequestMapping("/add")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_2, logdetail = "新增管理员")
    public ActionResult add(ManagersCustomBean managers, HttpServletRequest request) {
        if (managerService.checkUniqueness(managers)) {
            return ActionResult.build(400, "该管理员已存在,请输入其他管理员用户名!");
        }
        if (StringUtils.isEmpty(managers.getPasswd())) {
            managers.setPasswd("689EE787E0EA220E6D5A72163EB8C437");//默认123456
        } else {
            managers.setPasswd(MD5Util.MD5ToDepth(managers.getPasswd()));
        }
        Date now = new Date();
        managers.setCreatetime(now);
        managers.setModifytime(now);
        BaseManagers loginUser = (BaseManagers) request.getSession().getAttribute("USER_VALUE_OBJECT");

        managers.setCreator(loginUser.getUserid());
        managers.setModifier(loginUser.getUserid());
        managers.setStatus(1);
        int userid = managerService.add(managers);
        if (userid > 0) {
            String roleIds = managers.getRoleIdsStr();
            List<String> roleList = Arrays.asList(roleIds.split(","));
            // 插入管理员角色信息
            int res = managerService.insert(userid, roleList);
            if (res > 0) {
                return ActionResult.ok();
            } else {
                return ActionResult.build(400, "操作失败，请重试！");
            }
        } else {
            return ActionResult.build(400, "操作失败，请重试！");
        }

    }

    @RequestMapping("/update")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_3, logdetail = "更新管理员")
    public ActionResult update(ManagersCustomBean managers, HttpServletRequest request) {
        if (managerService.checkUniqueness(managers)) {
            return ActionResult.build(400, "该管理员已存在,请输入其他管理员用户名!");
        }
        if (StringUtils.isEmpty(managers.getPasswd())) {
            managers.setPasswd("689EE787E0EA220E6D5A72163EB8C437");//默认123456
        } else {
            managers.setPasswd(MD5Util.MD5ToDepth(managers.getPasswd()));
        }
        Date now = new Date();
        managers.setCreatetime(now);
        managers.setModifytime(now);
        BaseManagers loginUser = (BaseManagers) request.getSession().getAttribute("USER_VALUE_OBJECT");
        managers.setCreator(loginUser.getUserid());
        managers.setModifier(loginUser.getUserid());
        managers.setStatus(1);
        int count = managerService.update(managers);
        if (count > 0) {
            String roleIds = managers.getRoleIdsStr();
            List<String> roleList = Arrays.asList(roleIds.split(","));
            // 插入管理员角色信息
            int res = managerService.insert(managers.getUserid(), roleList);
            if (res > 0) {
                return ActionResult.ok();
            } else {
                return ActionResult.build(400, "操作失败，请重试！");
            }
        } else {
            return ActionResult.build(400, "操作失败，请重试！");
        }
    }

    @RequestMapping("/delBatch")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_4, logdetail = "删除管理员")
    public ActionResult delBatch(String managerIds) {
        return managerService.delBatch(managerIds);
    }

    @RequestMapping("/updateBatch")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_3, logdetail = "更新管理员状态")
    public ActionResult updateBatch(String managerIds, Integer status) {
        return managerService.updateBatch(managerIds, status);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public ActionResult logout(HttpServletRequest request) {
        BaseManagers loginUser = (BaseManagers) request.getSession().getAttribute("USER_VALUE_OBJECT");
        if (loginUser != null) {
            BaseLogs logs = new BaseLogs();
            logs.setCreatetime(new Date());
            logs.setLogdetail("用户退出");
            logs.setCreator(loginUser.getUserid());
            logs.setLogtype(Integer.valueOf(LogType.OPERATION_1));
            sysLogsService.insert(logs);
        }
        request.getSession().invalidate();
        return ActionResult.ok();
    }

    @RequestMapping("/updatePswd")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_3, logdetail = "修改密码")
    public ActionResult updatePswd(ManagersManageSearchBean managersManageSearchBean, HttpServletRequest request) {
        BaseManagers baseManagers = managerService.find(managersManageSearchBean.getUserId());
        if (baseManagers == null) {
            return ActionResult.build(-1, "当前用户不存在!");
        } else {
            String oldPswd = managersManageSearchBean.getOldPswd();
            String mdOldPswd = MD5Util.MD5ToDepth(oldPswd).toUpperCase();
            if (mdOldPswd.equals(baseManagers.getPasswd())) {
                BaseManagers newManager = new BaseManagers();
                Date now = new Date();
                newManager.setModifytime(now);
                BaseManagers loginUser = (BaseManagers) request.getSession().getAttribute("USER_VALUE_OBJECT");
                newManager.setModifier(loginUser.getUserid());
                String md5Pswd = MD5Util.MD5ToDepth(managersManageSearchBean.getPassword()).toUpperCase();
                newManager.setPasswd(md5Pswd);
                newManager.setUserid(baseManagers.getUserid());
                managerService.update(newManager);
            } else {
                return ActionResult.build(-1, "当前密码错误，请重新输入!");
            }
        }
        return ActionResult.ok();
    }

    @RequestMapping("/updateProfile")
    @ResponseBody
    @LogAnnotation(logtype = LogType.OPERATION_3, logdetail = "修改管理员个人信息")
    public ActionResult updateProfile(BaseManagers baseManagers, HttpServletRequest request) {
        Date now = new Date();
        baseManagers.setModifytime(now);
        BaseManagers loginUser = (BaseManagers) request.getSession().getAttribute("USER_VALUE_OBJECT");
        baseManagers.setModifier(loginUser.getUserid());
        managerService.update(baseManagers);
        return ActionResult.ok();
    }

}
