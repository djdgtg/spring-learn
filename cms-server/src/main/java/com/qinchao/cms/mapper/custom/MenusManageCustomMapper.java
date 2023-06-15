package com.qinchao.cms.mapper.custom;

import com.qinchao.cms.entity.BaseMenus;
import com.qinchao.cms.entity.BaseMenusExample;
import com.qinchao.cms.entity.custom.MenusCustomBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface MenusManageCustomMapper {

    int checkUniqueness(BaseMenus baseMenus);

    List<MenusCustomBean> selectByExample(BaseMenusExample example);

    int countByExample(BaseMenusExample example);

    int deleteBatch(List<String> menuids);

    int delRoleMenuBatch(List<String> menuids);

    List<MenusCustomBean> getRolesMenus(Integer userid);

    List<String> getMenusStringList(String contextPath);

    List<String> getMenusStringListByUserId(@Param("id") Integer id,@Param("contextPath") String contextPath);
}
