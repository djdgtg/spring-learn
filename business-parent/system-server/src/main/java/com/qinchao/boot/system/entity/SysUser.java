package com.qinchao.boot.system.entity;

import com.qinchao.common.easyexcel.ExcelCheck;
import com.qinchao.common.mybatisplus.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/3/28 11:02
 */
@Getter
@Setter
@Builder
public class SysUser extends BaseEntity {

    @NotEmpty(message = "用户名不能为空")
    @ExcelCheck(notEmpty = true, maxLength = 20)
    private String username;
    @NotEmpty(message = "密码不能为空")
    @ExcelCheck(notEmpty = true, maxLength = 20)
    private String password;
    private String realName;
    private String phoneNumber;
    @Pattern(regexp = "^[A-Za-z0-9-_\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")
    private String email;
    private String avatarUrl;
    private String orgCode;
    private Boolean enabled;

}
