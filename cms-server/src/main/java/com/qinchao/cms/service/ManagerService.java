package com.qinchao.cms.service;


import com.qinchao.cms.entity.BaseManagers;
import com.qinchao.cms.entity.custom.ManagersCustomBean;
import com.qinchao.cms.entity.custom.ManagersManageSearchBean;
import com.qinchao.cms.utils.ActionResult;

import java.util.List;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface ManagerService {

    BaseManagers login(BaseManagers baseManagers);

    void updatelogintime(BaseManagers baseManagers);

    BaseManagers find(Integer id);

    List<ManagersCustomBean> list(ManagersManageSearchBean managers);

    boolean checkUniqueness(BaseManagers managers);

    int add(BaseManagers managers);

    int update(BaseManagers managers);

    ActionResult delBatch(String managerIds);

    ActionResult updateBatch(String managerIds, Integer status);

    int insert(int userid, List<String> roleList);

}
