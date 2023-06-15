package com.qinchao.cms.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Table: base_mgrole
 * Author: qinc
 * Date: 2019-01-18 14:45:07
 */
@Data
public class BaseMgrole implements Serializable {
    /**
     * 用户ID
     * Column:    UserID
     * Nullable:  true
     */
    private Integer userid;

    /**
     * 角色ID
     * Column:    RoleID
     * Nullable:  true
     */
    private Integer roleid;

    private static final long serialVersionUID = 1L;
}
