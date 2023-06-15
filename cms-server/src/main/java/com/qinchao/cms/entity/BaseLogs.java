package com.qinchao.cms.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Table: base_logs
 * Author: qinc
 * Date: 2019-01-18 14:45:07
 */
@Data
public class BaseLogs implements Serializable {
    /**
     * 日志ID
     * Column:    LogID
     * Nullable:  false
     */
    private Integer logid;

    /**
     * 日志类型
     * Column:    LogType
     * Nullable:  false
     */
    private Integer logtype;

    /**
     * 日志详细
     * Column:    LogDetail
     * Nullable:  false
     */
    private String logdetail;

    /**
     * 创建者
     * Column:    Creator
     * Nullable:  true
     */
    private Integer creator;

    /**
     * 创建时间
     * Column:    CreateTime
     * Nullable:  false
     */
    private Date createtime;

    private static final long serialVersionUID = 1L;
}
