package com.qinchao.common.web.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qinchao.common.base.enums.SpentLevelEnum;
import com.qinchao.common.base.util.SystemClock;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description 接口日志记录
 *
 * @author qinchao
 * @since 2023/03/07
 **/
@Aspect
@Component
@AllArgsConstructor
public class LogAspect {

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    @Pointcut("execution(public * com.qinchao.*..controller.*Controller.*(..))")
    public void methodPointCut() {
    }

    @Around("methodPointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        long startTime = SystemClock.now();
        //被代理的类的类名
        String className = pjp.getTarget().getClass().getName();
        //被代理的类的类名
        //方法名
        String methodName = signature.getName();
        //获取日志
        Logger logger = LoggerFactory.getLogger(className);
        //参数数组
        Object[] requestParams = pjp.getArgs();
        StringBuilder sb = new StringBuilder();
        for (Object requestParam : requestParams) {
            if (requestParam != null && !(requestParam instanceof MultipartFile)
                    && !(requestParam instanceof HttpServletRequest) && !(requestParam instanceof HttpServletResponse)) {
                sb.append(objectMapper.writeValueAsString(requestParam));
                sb.append(",");
            }
        }
        String requestParamsString = sb.toString();
        if (requestParamsString.length() > 0) {
            requestParamsString = requestParamsString.substring(0, requestParamsString.length() - 1);
        }
        //接口应答前打印日志
        logger.info("Method [{}] started, requestUri:{}, request parameters: {}", methodName, request.getRequestURI(), requestParamsString);
        //正常执行方法
        Object response = pjp.proceed();
        //接口调用结束时间
        long spent = SystemClock.now() - startTime;
        MDC.put("spent_ms", spent + "");
        //接口应答之后打印日志，并统计耗时
        logger.info("Method [{}] ended, spent {}ms, response parameters:{}",
                methodName, spent, objectMapper.writeValueAsString(response));
        return response;
    }
}

