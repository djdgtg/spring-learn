package com.qinchao.common.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import lombok.AllArgsConstructor;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.relational.LikeExpression;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;

/**
 * Description 自带的拦截器无法实现like查询（用的tenant_id=xxx），实际使用中可能涉及查询本租户及该租户下面的子租户
 *
 * @author djdgt
 * @since 2023/4/26 10:37
 */
@AllArgsConstructor
public class MyTenantLineInnerInterceptor extends TenantLineInnerInterceptor {

    private final TenantLineHandler tenantLineHandler;

    @Override
    public Expression buildTableExpression(final Table table, final Expression where, final String whereSegment) {
        return this.tenantLineHandler.ignoreTable(table.getName()) ? null : new LikeExpression()
                .withLeftExpression(this.getAliasColumn(table)).withRightExpression(this.tenantLineHandler.getTenantId());
    }

    protected Column getAliasColumn(Table table) {
        StringBuilder column = new StringBuilder();
        if (table.getAlias() != null) {
            column.append(table.getAlias().getName()).append(".");
        }
        column.append(this.tenantLineHandler.getTenantIdColumn());
        return new Column(column.toString());
    }
}
