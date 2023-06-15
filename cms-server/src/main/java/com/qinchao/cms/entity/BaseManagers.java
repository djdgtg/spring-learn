package com.qinchao.cms.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Table: base_managers
 * Author: qinc
 * Date: 2019-01-18 14:45:07
 */
@Data
public class BaseManagers implements Serializable {
    /**
     * 用户ID
     * Column:    UserID
     * Nullable:  false
     */
    private Integer userid;

    /**
     * 用户名
     * Column:    UserName
     * Nullable:  false
     */
    private String username;

    /**
     * 密码，默认初始密码为123456(MD5)
     * Column:    Passwd
     * Nullable:  false
     */
    private String passwd;

    /**
     * 真实姓名
     * Column:    RealName
     * Nullable:  false
     */
    private String realname;

    /**
     * 电话
     * Column:    Phone
     * Nullable:  true
     */
    private String phone;

    /**
     * 邮箱
     * Column:    Email
     * Nullable:  true
     */
    private String email;

    /**
     * 更新者
     * Column:    Modifier
     * Nullable:  true
     */
    private Integer modifier;

    /**
     * 更新时间
     * Column:    ModifyTime
     * Nullable:  true
     */
    private Date modifytime;

    /**
     * 上次登录时间
     * Column:    LastLoginTime
     * Nullable:  true
     */
    private Date lastlogintime;

    /**
     * 创建者
     * Column:    Creator
     * Nullable:  false
     */
    private Integer creator;

    /**
     * 创建时间
     * Column:    CreateTime
     * Nullable:  false
     */
    private Date createtime;

    /**
     * Column:    Status
     * Nullable:  true
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}
