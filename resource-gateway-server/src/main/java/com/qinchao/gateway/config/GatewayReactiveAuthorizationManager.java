package com.qinchao.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * Description 自定义权限管理器
 *
 * @author qinchao
 * @since 2023/3/28 14:21
 */
@Slf4j
public class GatewayReactiveAuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();
        String url = request.getURI().getPath();
        String method = request.getMethodValue();
        //根据请求方式和url获取当前资源
        List<String> authorities = getAuthorities(url, method);
        return mono
                //用户是否已经认证，没有返回401(token没有或者失效)
                .filter(Authentication::isAuthenticated)
                //获取用户的权限
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                //资源权限跟用户拥有的权限匹配，有一个满足即可或者该资源没有指定访问权限
                .any(authority -> authorities.contains(authority) || authorities.size() == 0)
                .map(AuthorizationDecision::new)
                //为空返回true
                .defaultIfEmpty(new AuthorizationDecision(true));
    }

    private List<String> getAuthorities(String url, String method) {
        List<String> authorities = new ArrayList<>();
        switch (url) {
            case "/api/test":
                authorities.add("ROLE_TEST");
                authorities.add("ROLE_ADMIN");
                break;
            case "/api/system":
                authorities.add("ROLE_SYSTEM");
                authorities.add("ROLE_ADMIN");
                break;
            case "/api/admin":
                authorities.add("ROLE_ADMIN");
                break;
        }
        return authorities;
    }

}
