package com.qinchao.boot.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class DefaultSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                // 测试权限：api/test为TEST角色权限，api/system为SYSTEM角色权限
                .mvcMatchers("/api/test").hasAnyRole("TEST")
                .mvcMatchers("/api/system").hasAnyRole("SYSTEM")
                // 静态资源放行
                .mvcMatchers( "/css/**", "/img/**", "/js/**","/scss/**", "/vendor/**").permitAll()
                // 其他资源要认证
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                // 自定义登录页面地址
                .loginPage("/login.html")
                // 登录接口（后端不用实现）
                .loginProcessingUrl("/login")
                // 成功后跳转页面
                .successForwardUrl("/loginSuccess")
                // 登录相关的请求放行
                .permitAll()
                .and()
                // 登出
                .logout()
                .and()
                .csrf()
                .disable();
        return http.build();
    }
}
