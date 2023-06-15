package com.qinchao.common.resource.server;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Description MyFilter
 *
 * @author qinchao
 * @since 2023/3/24 9:34
 */
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String uri = ((FilterInvocation) object).getRequest().getRequestURI();
        String method = ((FilterInvocation) object).getRequest().getMethod();
        List<String> authorities = getAuthorities(uri, method);
        return SecurityConfig.createList(authorities.toArray(new String[0]));
    }

    private List<String> getAuthorities(String uri, String method) {
        List<String> authorities = new ArrayList<>();
        if (uri.startsWith("/api/system")) {
            authorities.add("ROLE_SYSTEM");
        } else if (uri.startsWith("/api/test")) {
            authorities.add("ROLE_TEST");
        } else {
            authorities.add("ROLE_ADMIN");
        }
        return authorities;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
