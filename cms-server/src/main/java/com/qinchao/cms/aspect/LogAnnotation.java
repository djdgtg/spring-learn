package com.qinchao.cms.aspect;

import java.lang.annotation.*;


/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {

    String logtype();

    String logdetail() default "";

    String creator() default "";

}
