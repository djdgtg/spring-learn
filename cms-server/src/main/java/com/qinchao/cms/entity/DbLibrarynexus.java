package com.qinchao.cms.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Table: db_librarynexus
 * Author: qinc
 * Date: 2019-01-18 14:45:07
 */
@Data
public class DbLibrarynexus implements Serializable {
    /**
     * Column:    nexusid
     * Nullable:  false
     */
    private Integer nexusid;

    /**
     * Column:    mdbname
     * Nullable:  true
     */
    private String mdbname;

    /**
     * Column:    mdbfield
     * Nullable:  true
     */
    private String mdbfield;

    /**
     * Column:    sdbname
     * Nullable:  true
     */
    private String sdbname;

    /**
     * Column:    sdbnamefield
     * Nullable:  true
     */
    private String sdbnamefield;

    /**
     * Column:    sdbvaluefield
     * Nullable:  true
     */
    private String sdbvaluefield;

    /**
     * Column:    sdbsql
     * Nullable:  true
     */
    private String sdbsql;

    private static final long serialVersionUID = 1L;
}
