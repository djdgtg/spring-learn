package com.qinchao.boot.integration.mapper;

import com.qinchao.boot.integration.entity.SysUser;
import com.qinchao.common.mybatisplus.MpBaseMapper;

import java.util.List;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/3/28 11:03
 */
public interface SysUserMapper extends MpBaseMapper<SysUser> {

    List<String> getRolesById(Integer id);
}
