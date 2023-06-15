package com.qinchao.common.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.qinchao.common.base.service.LoginUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;

@Slf4j
@AllArgsConstructor
public class MyTenantLineHandler implements TenantLineHandler {

    private LoginUserService loginUserService;

    @Override
    public String getTenantIdColumn() {
        return "org_code";
    }

    /**
     * 获取租户ID 实际应该从用户信息中获取
     */
    @Override
    public Expression getTenantId() {
        return new StringValue(loginUserService.getCurrentUserOrgCode() + "%");
    }

    /**
     * 表过滤，返回true，表示当前表不进行租户过滤
     */
    @Override
    public boolean ignoreTable(String tableName) {
        return false;
    }
}

