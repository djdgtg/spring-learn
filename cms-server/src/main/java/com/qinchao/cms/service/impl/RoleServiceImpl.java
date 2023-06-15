package com.qinchao.cms.service.impl;

import com.qinchao.cms.entity.BaseRoles;
import com.qinchao.cms.entity.BaseRolesExample;
import com.qinchao.cms.mapper.BaseRolesMapper;
import com.qinchao.cms.mapper.custom.RolesManageCustomMapper;
import com.qinchao.cms.service.RolesService;
import com.qinchao.cms.utils.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
@Service
public class RoleServiceImpl implements RolesService {

    @Autowired
    private BaseRolesMapper baseRolesMapper;

    @Autowired
    private RolesManageCustomMapper rolesCustomMapper;

    public List<BaseRoles> list() {
        BaseRolesExample example = new BaseRolesExample();
        return baseRolesMapper.selectByExample(example);
    }

    public boolean checkUniqueness(BaseRoles baseRoles) {
        return rolesCustomMapper.checkUniqueness(baseRoles) > 0;
    }

    public void add(BaseRoles baseRoles) {
        baseRolesMapper.insert(baseRoles);
    }

    public void update(BaseRoles baseRoles) {
        baseRolesMapper.updateByPrimaryKey(baseRoles);
    }

    public ActionResult delBatch(String roleIds) {
        try {
            String[] ids = roleIds.split(",");
            for (String id : ids) {
                baseRolesMapper.deleteByPrimaryKey(Integer.valueOf(id));
            }
            return ActionResult.ok();
        } catch (Exception e) {
            return ActionResult.build(400, "操作失败，请先解除对此角色有关联的用户及配置菜单！");
        }
    }


}
