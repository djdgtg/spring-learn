package com.qinchao.cms.entity.custom;


import com.qinchao.cms.entity.BaseMenus;

import java.util.List;


/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public class MenusCustomBean extends BaseMenus {

    private List<MenusCustomBean> children;

    private String parentmenuname;


    public List<MenusCustomBean> getChildren() {
        return children;
    }

    public void setChildren(List<MenusCustomBean> children) {
        this.children = children;
    }

    public String getParentmenuname() {
        return parentmenuname;
    }

    public void setParentmenuname(String parentmenuname) {
        this.parentmenuname = parentmenuname;
    }
}
