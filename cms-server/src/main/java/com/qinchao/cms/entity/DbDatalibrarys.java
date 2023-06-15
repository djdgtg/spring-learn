package com.qinchao.cms.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Table: db_datalibrarys
 * Author: qinc
 * Date: 2019-01-18 14:45:07
 */
@Data
public class DbDatalibrarys implements Serializable {
    /**
     * 库ID
     * Column:    DataBaseID
     * Nullable:  false
     */
    private Integer databaseid;

    /**
     * 库英文名
     * Column:    DataBaseName
     * Nullable:  false
     */
    private String databasename;

    /**
     * 库中文名
     * Column:    DataBaseCName
     * Nullable:  false
     */
    private String databasecname;

    /**
     * 库描述
     * Column:    Description
     * Nullable:  true
     */
    private String description;

    /**
     * 模型ID
     * Column:    MouldID
     * Nullable:  false
     */
    private Integer mouldid;

    /**
     * 状态
     * Column:    Status
     * Nullable:  false
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}
