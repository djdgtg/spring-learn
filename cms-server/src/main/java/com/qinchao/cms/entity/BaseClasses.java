package com.qinchao.cms.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Table: base_classes
 * Author: qinc
 * Date: 2019-01-18 14:45:07
 */
@Data
public class BaseClasses implements Serializable {
    /**
     * 分类ID
     * Column:    ClassID
     * Nullable:  false
     */
    private Integer classid;

    /**
     * 父分类
     * Column:    ParentClassID
     * Nullable:  false
     */
    private Integer parentclassid;

    /**
     * 分类名
     * Column:    ClassName
     * Nullable:  false
     */
    private String classname;

    /**
     * 分类图片
     * Column:    ClassImg
     * Nullable:  true
     */
    private String classimg;

    /**
     * 描述
     * Column:    ClassDescription
     * Nullable:  true
     */
    private String classdescription;

    /**
     * 排序
     * Column:    Sort
     * Nullable:  true
     */
    private Integer sort;

    private static final long serialVersionUID = 1L;
}
