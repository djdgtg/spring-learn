package com.qinchao.cms.entity.custom;


import com.qinchao.cms.entity.BaseManagers;

import java.util.List;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public class ManagersCustomBean extends BaseManagers {

    private List<Integer> roleIds;

    private String roleIdsStr;

    private List<Integer> ids;

    private Integer roleid;

    private String rolename;

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public String getRoleIdsStr() {
        return roleIdsStr;
    }

    public void setRoleIdsStr(String roleIdsStr) {
        this.roleIdsStr = roleIdsStr;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

}
