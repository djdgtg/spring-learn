package com.qinchao.common.resource.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@EnableWebSecurity
@Configuration(proxyBeanMethods = false)
public class ResourceServerConfig {

    private final static String AUTHORITY_PREFIX = "";

    private final static String CLAIM_NAME = "authorities";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   AccessDecisionManager accessDecisionManager,
                                                   FilterInvocationSecurityMetadataSource securityMetadataSource) throws Exception {
        http.authorizeRequests()
                // 动态授权
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <Interceptor extends FilterSecurityInterceptor> Interceptor postProcess(Interceptor interceptor) {
                        interceptor.setAccessDecisionManager(accessDecisionManager);
                        interceptor.setSecurityMetadataSource(securityMetadataSource);
                        return interceptor;
                    }
                })
                .anyRequest()
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(converter());
        return http.build();
    }

    private Converter<Jwt, ? extends AbstractAuthenticationToken> converter() {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        jwtGrantedAuthoritiesConverter.setAuthorityPrefix(AUTHORITY_PREFIX);
        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName(CLAIM_NAME);
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
        return jwtAuthenticationConverter;
    }

    @Bean
    public AccessDecisionManager accessDecisionManager() {
        return new MyAccessDecisionManager();
    }

    @Bean
    public FilterInvocationSecurityMetadataSource securityMetadataSource() {
        return new MySecurityMetadataSource();
    }

}
