package com.qinchao.cms.entity.custom;


import com.qinchao.cms.entity.BaseLogs;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public class SysLogsCustomBean extends BaseLogs {

    private String creatorName;

    private String logTypeName;

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getLogTypeName() {
        return logTypeName;
    }

    public void setLogTypeName(String logTypeName) {
        this.logTypeName = logTypeName;
    }
}
