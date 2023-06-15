package com.qinchao.cms.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Table: db_metadatas
 * Author: qinc
 * Date: 2019-01-18 14:45:07
 */
@Data
public class DbMetadatas implements Serializable {
    /**
     * 字段ID
     * Column:    MetaDataID
     * Nullable:  false
     */
    private Integer metadataid;

    /**
     * 字段英文名
     * Column:    ColumnName
     * Nullable:  false
     */
    private String columnname;

    /**
     * 字段中文名
     * Column:    ColumnCName
     * Nullable:  false
     */
    private String columncname;

    /**
     * 字段类型
     * Column:    ColumnType
     * Nullable:  false
     */
    private Integer columntype;

    /**
     * 字段来源
     * Column:    ColumnSource
     * Nullable:  true
     */
    private Integer columnsource;

    /**
     * 类型规则
     * Column:    ColumnTypeRule
     * Nullable:  true
     */
    private String columntyperule;

    /**
     * 数据类型
     * Column:    DataType
     * Nullable:  false
     */
    private String datatype;

    /**
     * 字段长度
     * Column:    ColumnLength
     * Nullable:  true
     */
    private Integer columnlength;

    /**
     * 表单显示
     * Column:    FormShow
     * Nullable:  false
     */
    private Integer formshow;

    /**
     * 列表显示
     * Column:    GridShow
     * Nullable:  false
     */
    private Integer gridshow;

    /**
     * 排序
     * Column:    Sorts
     * Nullable:  false
     */
    private Integer sorts;

    /**
     * 模型ID
     * Column:    MouldID
     * Nullable:  false
     */
    private Integer mouldid;

    /**
     * 默认值
     * Column:    DefaultValue
     * Nullable:  true
     */
    private String defaultvalue;

    /**
     * 搜索显示
     * Column:    SearchShow
     * Nullable:  true
     */
    private Integer searchshow;

    /**
     * 导入导出显示
     * Column:    ImportAndExportShow
     * Nullable:  true
     */
    private Integer importandexportshow;

    /**
     * 是否为必填项
     * Column:    Required
     * Nullable:  true
     */
    private Integer required;

    /**
     * 是否可修改列值
     * Column:    Editable
     * Nullable:  true
     */
    private Integer editable;

    /**
     * Column:    Only
     * Nullable:  true
     */
    private Integer only;

    /**
     * 校验的正则表达式
     * Column:    ValidExp
     * Nullable:  true
     */
    private String validexp;

    /**
     * 校验错误的提示信息
     * Column:    ValidMsg
     * Nullable:  true
     */
    private String validmsg;

    private static final long serialVersionUID = 1L;
}
