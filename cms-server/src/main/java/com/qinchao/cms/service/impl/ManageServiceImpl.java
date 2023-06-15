package com.qinchao.cms.service.impl;

import com.qinchao.cms.entity.BaseManagers;
import com.qinchao.cms.entity.BaseManagersExample;
import com.qinchao.cms.entity.BaseMgrole;
import com.qinchao.cms.entity.custom.ManagersCustomBean;
import com.qinchao.cms.entity.custom.ManagersManageSearchBean;
import com.qinchao.cms.mapper.BaseManagersMapper;
import com.qinchao.cms.mapper.custom.ManagersManageCustomMapper;
import com.qinchao.cms.mapper.custom.MgRoleCustomMapper;
import com.qinchao.cms.service.ManagerService;
import com.qinchao.cms.utils.ActionResult;
import com.qinchao.cms.utils.MD5Util;
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
public class ManageServiceImpl implements ManagerService {

    @Autowired
    private BaseManagersMapper baseManagersMapper;

    @Autowired
    private ManagersManageCustomMapper manageCustomMapper;

    @Autowired
    private MgRoleCustomMapper mgRoleCustomMapper;

    public BaseManagers login(BaseManagers baseManagers) {
        String md5Pswd = MD5Util.MD5ToDepth(baseManagers.getPasswd()).toUpperCase();
        BaseManagersExample example = new BaseManagersExample();
        example.createCriteria().andUsernameEqualTo(baseManagers.getUsername()).
                andPasswdEqualTo(md5Pswd);
        List<BaseManagers> list = baseManagersMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public void updatelogintime(BaseManagers baseManagers) {
        baseManagersMapper.updateByPrimaryKey(baseManagers);
    }

    public BaseManagers find(Integer id) {
        return baseManagersMapper.selectByPrimaryKey(id);
    }

    public List<ManagersCustomBean> list(ManagersManageSearchBean managers) {
        return manageCustomMapper.listManagersCustomBean(managers);
    }

    public boolean checkUniqueness(BaseManagers managers) {
        return manageCustomMapper.checkUniqueness(managers) > 0;
    }

    public int add(BaseManagers managers) {
        manageCustomMapper.insertSelective(managers);
        return managers.getUserid();
    }

    public int update(BaseManagers managers) {
        return baseManagersMapper.updateByPrimaryKeySelective(managers);
    }

    public ActionResult delBatch(String managerIds) {
        String[] ids = managerIds.split(",");
        for (String id : ids) {
            baseManagersMapper.deleteByPrimaryKey(Integer.valueOf(id));
        }
        return ActionResult.ok();
    }

    public ActionResult updateBatch(String managerIds, Integer status) {
        String[] ids = managerIds.split(",");
        for (String id : ids) {
            BaseManagers managers = baseManagersMapper.selectByPrimaryKey(Integer.valueOf(id));
            if (status == null) {
                managers.setPasswd("689EE787E0EA220E6D5A72163EB8C437");//默认123456
            } else {
                managers.setStatus(status);//锁定解锁
            }
            baseManagersMapper.updateByPrimaryKey(managers);
        }
        return ActionResult.ok();
    }

    public int insert(int userid, List<String> roleList) {
        List<String> roleIdList = new ArrayList<>();
        roleIdList.add(String.valueOf(userid));
        mgRoleCustomMapper.deleteBatchByMgId(roleIdList);
        if (roleList != null) {
            List<BaseMgrole> mgRoleList = new ArrayList<>();
            for (String roleid : roleList) {
                BaseMgrole mgRole = new BaseMgrole();
                mgRole.setRoleid(Integer.valueOf(roleid.trim()));
                mgRole.setUserid(userid);
                mgRoleList.add(mgRole);
            }
            return mgRoleCustomMapper.insertBatch(mgRoleList);
        }
        return 0;
    }

}
