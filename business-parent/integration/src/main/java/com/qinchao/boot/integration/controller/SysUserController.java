package com.qinchao.boot.integration.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qinchao.boot.integration.entity.SysUser;
import com.qinchao.boot.integration.mapper.SysUserMapper;
import com.qinchao.common.base.bean.CustomException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/3/28 10:56
 */
@RestController
@RequestMapping("user")
@AllArgsConstructor
public class SysUserController {

    private final SysUserMapper userMapper;

    private final SysUser sysUser;

    @GetMapping("{id}")
    public SysUser getById(@PathVariable Integer id) {
        if (id > 100 || id < 1) {
            throw new CustomException("请输入合适用户id");
        }
        userMapper.selectOne(new QueryWrapper<SysUser>().lambda().eq(SysUser::getPassword, ""));
        return userMapper.selectById(id);
    }

    @GetMapping("config")
    public SysUser sysUser() {
        return sysUser;
    }
}
