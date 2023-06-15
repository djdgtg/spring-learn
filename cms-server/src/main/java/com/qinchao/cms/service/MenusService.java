package com.qinchao.cms.service;


import com.qinchao.cms.entity.BaseMenus;
import com.qinchao.cms.utils.ActionResult;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface MenusService {

    String gethtmlmenu(Integer loginId);

    ActionResult listCustom();

    ActionResult add(BaseMenus menus);

    ActionResult update(BaseMenus menus);

    ActionResult del(Integer menuId);

}
