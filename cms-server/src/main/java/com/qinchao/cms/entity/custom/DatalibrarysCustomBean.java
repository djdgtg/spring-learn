package com.qinchao.cms.entity.custom;


import com.qinchao.cms.entity.DbDatalibrarys;
import com.qinchao.cms.entity.DbLibrarynexus;

import java.util.List;


/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public class DatalibrarysCustomBean extends DbDatalibrarys {

    private String mouldname;//模型名

    private String mouldtypename;//模型类型名

    private Integer mouldtype;

    private List<DbLibrarynexus> libraryNexus;

    private String statusname;

    private String datasteptypename;

    private Integer parentmenuid;


    public String getMouldname() {
        return mouldname;
    }

    public void setMouldname(String mouldname) {
        this.mouldname = mouldname;
    }

    public String getMouldtypename() {
        return mouldtypename;
    }

    public void setMouldtypename(String mouldtypename) {
        this.mouldtypename = mouldtypename;
    }

    public List<DbLibrarynexus> getLibraryNexus() {
        return libraryNexus;
    }

    public void setLibraryNexus(List<DbLibrarynexus> libraryNexus) {
        this.libraryNexus = libraryNexus;
    }

    public Integer getMouldtype() {
        return mouldtype;
    }

    public void setMouldtype(Integer mouldtype) {
        this.mouldtype = mouldtype;
    }

    public String getStatusname() {
        return statusname;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname;
    }

    public String getDatasteptypename() {
        return datasteptypename;
    }

    public void setDatasteptypename(String datasteptypename) {
        this.datasteptypename = datasteptypename;
    }

    public Integer getParentmenuid() {
        return parentmenuid;
    }

    public void setParentmenuid(Integer parentmenuid) {
        this.parentmenuid = parentmenuid;
    }
}
