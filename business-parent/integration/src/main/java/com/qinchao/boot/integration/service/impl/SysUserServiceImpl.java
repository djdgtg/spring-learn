package com.qinchao.boot.integration.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qinchao.boot.integration.entity.SysUser;
import com.qinchao.boot.integration.mapper.SysUserMapper;
import com.qinchao.boot.integration.service.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/5/10 15:22
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl implements SysUserService, UserDetailsService {

    private final SysUserMapper sysUserMapper;

    @Override
    public SysUser getById(Integer id) {
        return sysUserMapper.selectById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserMapper.selectOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username));
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户名或者密码不正确");
        }
        List<String> roles = sysUserMapper.getRolesById(sysUser.getId());
        return User.withUsername(username).password(sysUser.getPassword()).roles(roles.toArray(new String[]{})).build();
    }
}
