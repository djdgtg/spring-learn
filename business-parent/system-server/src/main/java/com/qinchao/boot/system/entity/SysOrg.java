package com.qinchao.boot.system.entity;

import com.qinchao.common.mybatisplus.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/3/28 11:02
 */
@Getter
@Setter
public class SysOrg extends BaseEntity {

    private String orgName;
    private String orgCode;
    private Integer parentId;
    private String description;

}
