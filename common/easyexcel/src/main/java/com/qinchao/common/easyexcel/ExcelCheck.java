package com.qinchao.common.easyexcel;

import java.lang.annotation.*;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/5/16 10:17
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelCheck {

    boolean notEmpty() default false;

    int maxLength() default 255;

}
