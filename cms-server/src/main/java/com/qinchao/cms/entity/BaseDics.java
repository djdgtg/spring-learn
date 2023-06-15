package com.qinchao.cms.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Table: base_dics
 * Author: qinc
 * Date: 2019-01-18 14:45:07
 */
@Data
public class BaseDics implements Serializable {
    /**
     * 字典ID
     * Column:    DicID
     * Nullable:  false
     */
    private Integer dicid;

    /**
     * 字典类型
     * Column:    DicType
     * Nullable:  true
     */
    private String dictype;

    /**
     * 字典名
     * Column:    DicName
     * Nullable:  true
     */
    private String dicname;

    /**
     * 字典值
     * Column:    DicValue
     * Nullable:  true
     */
    private String dicvalue;

    /**
     * 字典类型中文名
     * Column:    DicTypeName
     * Nullable:  true
     */
    private String dictypename;

    /**
     * 是否字典类型
     * Column:    IsDicType
     * Nullable:  true
     */
    private Integer isdictype;

    private static final long serialVersionUID = 1L;
}
