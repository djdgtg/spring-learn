package com.qinchao.cms.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Table: front_product
 * Author: qinc
 * Date: 2019-01-18 14:45:07
 */
@Data
public class FrontProduct implements Serializable {
    /**
     * Column:    seqid
     * Nullable:  false
     */
    private Integer seqid;

    /**
     * 商品名
     * Column:    pname
     * Nullable:  true
     */
    private String pname;

    /**
     * 商品描述
     * Column:    description
     * Nullable:  true
     */
    private String description;

    /**
     * 是否上架中
     * Column:    pstatus
     * Nullable:  true
     */
    private String pstatus;

    /**
     * 商品卖点
     * Column:    point
     * Nullable:  true
     */
    private String point;

    /**
     * 封面
     * Column:    cover
     * Nullable:  true
     */
    private String cover;

    /**
     * 上架时间
     * Column:    publishtime
     * Nullable:  true
     */
    private Date publishtime;

    /**
     * 剩余数量
     * Column:    overplus
     * Nullable:  true
     */
    private Integer overplus;

    /**
     * 价格
     * Column:    price
     * Nullable:  true
     */
    private Float price;

    /**
     * 创建时间
     * Column:    createdtime
     * Nullable:  false
     */
    private Date createdtime;

    /**
     * 创建人
     * Column:    creatorid
     * Nullable:  true
     */
    private Integer creatorid;

    /**
     * 状态
     * Column:    status
     * Nullable:  true
     */
    private Integer status;

    /**
     * 图文简介
     * Column:    content
     * Nullable:  true
     */
    private String content;

    private static final long serialVersionUID = 1L;
}
