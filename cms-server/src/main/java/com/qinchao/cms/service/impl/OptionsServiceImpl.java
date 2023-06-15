package com.qinchao.cms.service.impl;

import com.qinchao.cms.entity.*;
import com.qinchao.cms.entity.custom.Options;
import com.qinchao.cms.entity.custom.OptionsSearchBean;
import com.qinchao.cms.mapper.BaseClassesMapper;
import com.qinchao.cms.mapper.BaseMenusMapper;
import com.qinchao.cms.mapper.BaseMgroleMapper;
import com.qinchao.cms.mapper.BaseRolemenuMapper;
import com.qinchao.cms.service.OptionsService;
import com.qinchao.cms.utils.ActionResult;
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
public class OptionsServiceImpl implements OptionsService {

    @Autowired
    private BaseMenusMapper baseMenusMapper;

    @Autowired
    private BaseMgroleMapper baseMgroleMapper;

    @Autowired
    private BaseRolemenuMapper baseRolemenuMapper;

    @Autowired
    private BaseClassesMapper classesMapper;

    public ActionResult getMenuTreeOptionsByRole(OptionsSearchBean optionsSearchBean) {
        int roleId = optionsSearchBean.getRoleId();
        int userid = optionsSearchBean.getUserId();
        BaseMenusExample example = new BaseMenusExample();
        example.createCriteria().andMenuidIsNotNull();
        // 设置id不为空
        example.setOrderByClause("parentmenuid asc,sort asc");
        List<BaseMenus> menuslist = baseMenusMapper.selectByExample(example);
        List<Options> menuTreeList = new ArrayList<>();
        if (menuslist != null && menuslist.size() > 0) {
            List<Integer> menuidarr = new ArrayList<>();
            if (roleId > 0 || userid > 0) {
                List<Integer> rolearr = null;
                if (roleId > 0) {
                    rolearr = new ArrayList<>();
                    rolearr.add(roleId);
                } else {
                    BaseMgroleExample mgRoleExample = new BaseMgroleExample();
                    mgRoleExample.createCriteria().andUseridEqualTo(userid);
                    List<BaseMgrole> mgrolelist = baseMgroleMapper.selectByExample(mgRoleExample);
                    if (mgrolelist != null && mgrolelist.size() > 0) {
                        rolearr = new ArrayList<>(mgrolelist.size());
                        int i = 0;
                        for (BaseMgrole mgrole : mgrolelist) {
                            rolearr.add(i, mgrole.getRoleid());
                        }
                    }
                }
                BaseRolemenuExample roleMenuExample = new BaseRolemenuExample();
                roleMenuExample.createCriteria().andRoleidIn(rolearr);
                List<BaseRolemenu> rolemenulist = baseRolemenuMapper.selectByExample(roleMenuExample);
                if (rolemenulist != null && rolemenulist.size() > 0) {
                    for (BaseRolemenu rolemenu : rolemenulist)
                        menuidarr.add(rolemenu.getMenuid());
                }
            }

            menuTreeList = setMenusChildren(0, menuslist, menuidarr);
        }

        return ActionResult.ok(menuTreeList);
    }

    private List<Options> setMenusChildren(int parentOption, List<BaseMenus> list, List<Integer> rolemenuarr) {
        List<Options> menusChildren = new ArrayList<>();
        Options option;
        for (BaseMenus menu : list) {
            Integer menuid = menu.getMenuid();// 获取菜单的id
            Integer parentid = menu.getParentmenuid();// 获取菜单的父id
            if (parentid == parentOption) {
                option = new Options();
                option.setId(menu.getMenuid());
                option.setText(menu.getMenuname());
                option.setSelected(rolemenuarr.contains(menuid));
                menusChildren.add(option);

                List<Options> iterateMenu = setMenusChildren(menuid, list, rolemenuarr);
                if (iterateMenu.size() > 0) {
                    option.setChildren(iterateMenu);
                }
            }
        }
        return menusChildren;
    }

    @Override
    public ActionResult getClassTreeOptionsByParent(OptionsSearchBean optionsSearchBean) {
        List<Options> clsTreeList = new ArrayList<>();
        int parentId = optionsSearchBean.getParentId();
        if (parentId < 0) {
            parentId = 0;
        }
        BaseClassesExample example = new BaseClassesExample();
        example.setOrderByClause("parentclassid asc");
        List<BaseClasses> classlist = classesMapper.selectByExample(example);
        if (classlist != null) {
            clsTreeList = setClsChildren(parentId, classlist);
        }
        if (optionsSearchBean.isWithNone()) {
            Options option = new Options();
            option.setId(-1);
            option.setText("--请选择--");
            clsTreeList.add(0, option);
        }
        return ActionResult.ok(clsTreeList);
    }

    private List<Options> setClsChildren(int parentId, List<BaseClasses> list) {
        List<Options> clsChildren = new ArrayList<>();
        for (BaseClasses cls : list) {
            Integer clsid = cls.getClassid();// 获取分类的id
            Integer parentid = cls.getParentclassid();// 获取分类的父id
            if (parentid == parentId) {
                Options option = new Options();
                option.setId(clsid);
                option.setText(cls.getClassname());

                List<Options> iterateCls = setClsChildren(clsid, list);
                if (iterateCls.size() > 0) {
                    option.setChildren(iterateCls);
                }
                clsChildren.add(option);
            }
        }
        return clsChildren;
    }

}
