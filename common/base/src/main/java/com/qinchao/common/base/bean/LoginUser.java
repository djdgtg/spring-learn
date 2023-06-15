package com.qinchao.common.base.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/3/28 9:58
 */
@Getter
@Setter
public class LoginUser {

    private Integer userId;

    private String username;

    private String password;

    private String phoneNumber;

    private String realName;
}
