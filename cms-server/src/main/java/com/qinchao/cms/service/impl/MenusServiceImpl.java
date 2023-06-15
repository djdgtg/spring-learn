package com.qinchao.cms.service.impl;

import com.qinchao.cms.entity.BaseMenus;
import com.qinchao.cms.entity.BaseMenusExample;
import com.qinchao.cms.entity.custom.MenusCustomBean;
import com.qinchao.cms.mapper.BaseMenusMapper;
import com.qinchao.cms.mapper.custom.MenusManageCustomMapper;
import com.qinchao.cms.service.MenusService;
import com.qinchao.cms.utils.ActionResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
@Service
public class MenusServiceImpl implements MenusService {

    @Autowired
    private MenusManageCustomMapper menusCustomMapper;
    @Autowired
    private BaseMenusMapper baseMenusMapper;

    public String gethtmlmenu(Integer loginId) {
        List<MenusCustomBean> menuList = menusCustomMapper.getRolesMenus(loginId);//角色菜单列表
        List<MenusCustomBean> usermenu = new ArrayList<>();
        for (MenusCustomBean menusCustomBean : menuList) {
            if (menusCustomBean.getParentmenuid() == 0) {
                usermenu.add(menusCustomBean);
            }
        }
        for (MenusCustomBean menusCustomBean : usermenu) {
            //递归生成菜单树
            menusCustomBean.setChildren(getChild(menusCustomBean.getMenuid(), menuList));
        }
        //遍历菜单树,拼接html
        StringBuilder htmlmenu = new StringBuilder("<ul id='mainnav-menu' class='list-group'><li class='list-header'>导航菜单</li>");
        for (MenusCustomBean menusCustomBean : usermenu) {
            if (menusCustomBean.getChildren() == null) {
                htmlmenu.append("<li><a href=#><i></i><span class='menu-title'><strong>").append(menusCustomBean.getMenuname()).append("</strong></span></a></li>");
            } else {
                //递归获取子菜单树的html
                htmlmenu.append(getmenus(menusCustomBean));
            }
        }
        htmlmenu.append("</ul>");
        return htmlmenu.toString();
    }

    private String getmenus(MenusCustomBean menusCustomBean) {
        StringBuilder html = new StringBuilder("<li><a href='#'><span class='menu-title'><strong>" + menusCustomBean.getMenuname() + "</strong></span><i class='arrow'></i></a><ul class='collapse'>");
        List<MenusCustomBean> children = menusCustomBean.getChildren();
        for (MenusCustomBean menus : children) {
            if (menus.getChildren() == null) {
                if (menus.getPath() != null && !menus.getPath().equals("")) {
                    html.append("<li><a href='").append(menus.getPath()).append("' target='");
                } else {
                    html.append("<li><a href='#' target='");
                }
                if (menus.getIsoutlink() == 1) {
                    html.append("_blank'>");
                } else {
                    html.append("_iframe'>");
                }
                html.append(menus.getMenuname()).append("</a></li>");
            } else {
                html.append(getmenus(menus));
            }
        }
        html.append("</ul></li>");
        return html.toString();
    }

    private List<MenusCustomBean> getChild(Integer menuid, List<MenusCustomBean> menuList) {
        List<MenusCustomBean> childs = new ArrayList<>();
        for (MenusCustomBean menusCustomBean : menuList) {
            if (menusCustomBean.getParentmenuid() != null) {
                if (menusCustomBean.getParentmenuid().equals(menuid)) {
                    childs.add(menusCustomBean);
                }
            }
        }
        for (MenusCustomBean menusCustomBean : childs) {
            if (StringUtils.isBlank(menusCustomBean.getPath())) {
                menusCustomBean.setChildren(getChild(menusCustomBean.getMenuid(), menuList));
            }
        }
        if (childs.size() == 0) {
            return null;
        }
        return childs;
    }

    public ActionResult listCustom() {
        BaseMenusExample example = new BaseMenusExample();
        List<MenusCustomBean> list = menusCustomMapper.selectByExample(example);
        List<MenusCustomBean> menusList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            menusList = iterateMenusTree(list, 0);
        }
        return ActionResult.ok(menusList);
    }


    //多级菜单查询方法
    private List<MenusCustomBean> iterateMenusTree(List<MenusCustomBean> menuVoList, Integer pid) {
        List<MenusCustomBean> result = new ArrayList<MenusCustomBean>();
        for (MenusCustomBean menuVo : menuVoList) {
            Integer menuid = menuVo.getMenuid();//获取菜单的id
            Integer parentid = menuVo.getParentmenuid();//获取菜单的父id
            if (parentid.equals(pid)) {
                List<MenusCustomBean> iterateMenu = iterateMenusTree(menuVoList, menuid);
                if (iterateMenu.size() > 0) {
                    menuVo.setChildren(iterateMenu);
                }
                result.add(menuVo);
            }
        }
        return result;
    }

    public ActionResult add(BaseMenus menus) {
        baseMenusMapper.insert(menus);
        return ActionResult.ok();
    }

    public ActionResult update(BaseMenus menus) {
        baseMenusMapper.updateByPrimaryKeySelective(menus);
        return ActionResult.ok();
    }

    public ActionResult del(Integer menuId) {
        baseMenusMapper.deleteByPrimaryKey(menuId);
        return ActionResult.ok();
    }

}
