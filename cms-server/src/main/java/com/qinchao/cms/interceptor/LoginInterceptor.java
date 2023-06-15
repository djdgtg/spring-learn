package com.qinchao.cms.interceptor;

import com.qinchao.cms.entity.BaseManagers;
import com.qinchao.cms.mapper.custom.MenusManageCustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @author qinc
 * @description 登录校验拦截器
 * @date 2018/12/11
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private MenusManageCustomMapper menusCustomMapper;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //获取当前请求的路径
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        String uri = request.getRequestURI();
        //除了去往login以及login，其他的URL都进行拦截控制
        if (uri.contains("login")) {
            return true;
        }
        //获取session
        BaseManagers loginUser = (BaseManagers) request.getSession().getAttribute("USER_VALUE_OBJECT");
        if (loginUser != null) {
            String contextPath = request.getContextPath() + "/";
            List<String> alllist = menusCustomMapper.getMenusStringList(contextPath);
            List<String> list = menusCustomMapper.getMenusStringListByUserId(loginUser.getUserid(), contextPath);
            //如果菜单中有的页面但用户没有的页面，重定向至main
            if (alllist.contains(uri) && !list.contains(uri)) {
                response.sendRedirect(basePath + "/main");
            }
            return true;
        }
        //如果request.getHeader("X-Requested-With") 返回的是"XMLHttpRequest"说明就是ajax请求，需要特殊处理
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            //告诉ajax我是重定向
            response.setHeader("REDIRECT", "REDIRECT");
            //告诉ajax我重定向的路径
            response.setHeader("CONTENTPATH", basePath + "/login");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            //否则重定向登录页面
            response.sendRedirect(basePath + "/login");
        }
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}
