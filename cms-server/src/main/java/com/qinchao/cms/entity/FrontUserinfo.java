package com.qinchao.cms.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Table: front_userinfo
 * Author: qinc
 * Date: 2019-01-18 14:45:07
 */
@Data
public class FrontUserinfo implements Serializable {
    /**
     * Column:    seqid
     * Nullable:  false
     */
    private Integer seqid;

    /**
     * Column:    userclass
     * Nullable:  true
     */
    private String userclass;

    /**
     * 姓名
     * Column:    name
     * Nullable:  true
     */
    private String name;

    /**
     * 性别：1男，0女
     * Column:    gender
     * Nullable:  true
     */
    private Integer gender;

    /**
     * 出生日期
     * Column:    age
     * Nullable:  true
     */
    private Integer age;

    /**
     * Column:    nation
     * Nullable:  true
     */
    private Integer nation;

    /**
     * 手机号
     * Column:    phone
     * Nullable:  true
     */
    private String phone;

    /**
     * 籍贯
     * Column:    hometown
     * Nullable:  true
     */
    private String hometown;

    /**
     * 学位：0大专以下，1专科，2本科，3研究生及以上
     * Column:    degree
     * Nullable:  true
     */
    private Integer degree;

    /**
     * 转正时间
     * Column:    formaltime
     * Nullable:  true
     */
    private Date formaltime;

    /**
     * 用户头像保存地址
     * Column:    image
     * Nullable:  true
     */
    private String image;

    /**
     * 密码，默认初始密码为123456(MD5)
     * Column:    password
     * Nullable:  true
     */
    private String password;

    /**
     * Column:    userstatus
     * Nullable:  true
     */
    private Integer userstatus;

    /**
     * Column:    createdtime
     * Nullable:  false
     */
    private Date createdtime;

    /**
     * Column:    creatorid
     * Nullable:  true
     */
    private Integer creatorid;

    /**
     * -1 删除 , 0 未激活, 1 激活
     * Column:    status
     * Nullable:  true
     */
    private Integer status;

    /**
     * 奖惩情况
     * Column:    bonuspenalty
     * Nullable:  true
     */
    private String bonuspenalty;

    private static final long serialVersionUID = 1L;
}
