package com.qinchao.cms.mapper.custom;


import com.qinchao.cms.entity.BaseMenus;
import com.qinchao.cms.entity.BaseRoles;

import java.util.List;


/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface RolesManageCustomMapper {

    int checkUniqueness(BaseRoles baseRoles);

    int deleteBatch(List<String> roleids);

    List<BaseMenus> getRoleMenus(Integer roleId);
}
