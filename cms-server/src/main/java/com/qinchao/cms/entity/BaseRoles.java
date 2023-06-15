package com.qinchao.cms.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Table: base_roles
 * Author: qinc
 * Date: 2019-01-18 14:45:07
 */
@Data
public class BaseRoles implements Serializable {
    /**
     * 角色ID
     * Column:    RoleID
     * Nullable:  false
     */
    private Integer roleid;

    /**
     * 角色名
     * Column:    RoleName
     * Nullable:  false
     */
    private String rolename;

    /**
     * 角色描述
     * Column:    Description
     * Nullable:  false
     */
    private String description;

    private static final long serialVersionUID = 1L;
}
