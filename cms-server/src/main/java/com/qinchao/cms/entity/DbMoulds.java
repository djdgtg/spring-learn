package com.qinchao.cms.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Table: db_moulds
 * Author: qinc
 * Date: 2019-01-18 14:45:07
 */
@Data
public class DbMoulds implements Serializable {
    /**
     * 模型ID
     * Column:    MouldID
     * Nullable:  false
     */
    private Integer mouldid;

    /**
     * 模型名称
     * Column:    MouldName
     * Nullable:  false
     */
    private String mouldname;

    /**
     * 模型描述
     * Column:    Description
     * Nullable:  true
     */
    private String description;

    private static final long serialVersionUID = 1L;
}
