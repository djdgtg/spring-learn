package com.qinchao.common.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.qinchao.common.base.service.LoginUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/3/1 15:07
 */
@Configuration
public class MyBatisPlusConfig {

    @Value("${mybatis-plus.multi-tenancy-enabled:false}")
    private Boolean enabled;

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(LoginUserService loginUserService) {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 数据库类型是MySql，因此参数填写DbType.MYSQL
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        // 是否启用多租户
        if (enabled) {
            interceptor.addInnerInterceptor(new MyTenantLineInnerInterceptor(new MyTenantLineHandler(loginUserService)));
        }
        return interceptor;
    }

    @Bean
    public DefaultSqlInjector defaultSqlInjector() {
        return new MpSqlInjector();
    }

    @Bean
    @ConditionalOnBean(LoginUserService.class)
    public MpMetaObjectHandler metaObjectHandler(LoginUserService loginUserService) {
        return new MpMetaObjectHandler(loginUserService);
    }

    @Bean
    @ConditionalOnMissingBean(LoginUserService.class)
    public LoginUserService LoginUserService() {
        return new LoginUserService() {
            @Override
            public Integer getCurrentUserId() {
                return 0;
            }

            @Override
            public String getCurrentUserOrgCode() {
                return "001";
            }
        };
    }

}
