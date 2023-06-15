package com.qinchao.cms.service;


import com.qinchao.cms.entity.BaseRoles;
import com.qinchao.cms.utils.ActionResult;

import java.util.List;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface RolesService {

    List<BaseRoles> list();

    void add(BaseRoles baseRoles);

    void update(BaseRoles baseRoles);

    ActionResult delBatch(String roleIds);

    boolean checkUniqueness(BaseRoles baseRoles);

}
