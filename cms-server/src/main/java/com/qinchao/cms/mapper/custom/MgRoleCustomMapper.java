package com.qinchao.cms.mapper.custom;


import com.qinchao.cms.entity.BaseMgrole;
import com.qinchao.cms.entity.custom.MgRoleCustomBean;

import java.util.List;


/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public interface MgRoleCustomMapper {
    /**
     * 查询角色列表
     *
     * @param userid
     * @return
     */
    List<MgRoleCustomBean> getManagerRoleList(Integer userid);

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    int insertBatch(List<BaseMgrole> list);

    /**
     * 根据管理员批量删除
     *
     * @param mgids
     * @return
     */
    int deleteBatchByMgId(List<String> mgids);

    /**
     * 根据角色批量删除
     *
     * @param roleids
     * @return
     */
    int deleteBatchByRoleId(List<String> roleids);
}
