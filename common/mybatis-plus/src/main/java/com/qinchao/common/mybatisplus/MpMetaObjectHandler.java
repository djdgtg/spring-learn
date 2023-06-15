package com.qinchao.common.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.qinchao.common.base.service.LoginUserService;
import lombok.AllArgsConstructor;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

@AllArgsConstructor
public class MpMetaObjectHandler implements MetaObjectHandler {

    private final LoginUserService loginUserService;

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("createBy", loginUserService.getCurrentUserId(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updateBy", loginUserService.getCurrentUserId(), metaObject);
    }
}
