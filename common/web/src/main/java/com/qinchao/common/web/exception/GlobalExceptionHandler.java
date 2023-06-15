package com.qinchao.common.web.exception;

import com.qinchao.common.base.bean.CustomException;
import com.qinchao.common.base.bean.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 全局异常处理器
 *
 * @author fsmer
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    /**
     * 请求方式不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
                                                              HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("Request url'{}', method '{}' was not supported", requestURI, e.getMethod(), e);
        return Result.fail("请求方式不支持，请联系管理员！");
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public Result<Object> handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("Request url'{}', occurred runtime exception: ", requestURI, e);
        if (e instanceof CustomException) {
            return Result.fail(e.getMessage());
        } else {
            return Result.fail("信息有误，请联系管理员");
        }
    }


    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public Result<Object> handleException(Exception e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("Request url'{}', occurred system exception: ", requestURI, e);
        return Result.fail("信息有误，请联系管理员");
    }

    /**
     * 自定义验证异常
     */
    @ExceptionHandler(BindException.class)
    public Result<Object> handleBindException(BindException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("Request url'{}', occurred bind exception: ", requestURI, e);
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return Result.fail(message);
    }

    /**
     * 自定义验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("Request url'{}', occurred validating exception: ", requestURI, e);
        String message = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        return Result.fail(message);
    }

}
