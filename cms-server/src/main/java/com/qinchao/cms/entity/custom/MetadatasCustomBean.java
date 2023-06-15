package com.qinchao.cms.entity.custom;


import com.qinchao.cms.entity.DbMetadatas;

/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public class MetadatasCustomBean extends DbMetadatas {

    private String columntypename;//字段类型中文名

    private String columnsourcename;//字段来源中文名

    private String metaType;

    public String getColumntypename() {
        return columntypename;
    }

    public void setColumntypename(String columntypename) {
        this.columntypename = columntypename;
    }

    public String getColumnsourcename() {
        return columnsourcename;
    }

    public void setColumnsourcename(String columnsourcename) {
        this.columnsourcename = columnsourcename;
    }

    public MetadatasCustomBean() {
        super();
    }

    public MetadatasCustomBean(Integer metaId, String columnName, String columnCName, Integer columnType, Integer columnSource, String columnTypeRule, String dataType, Integer columnLength, Integer formShow, Integer gridShow, Integer sorts, Integer mouldId, String defaultValue, Integer searchShow, String validExp, String metaType) {
        this.setMetadataid(metaId);
        this.setColumnname(columnName);
        this.setColumncname(columnCName);
        this.setColumntype(columnType);
        this.setColumnsource(columnSource);
        this.setColumntyperule(columnTypeRule);
        this.setDatatype(dataType);
        this.setColumnlength(columnLength);
        this.setFormshow(formShow);
        this.setGridshow(gridShow);
        this.setSorts(sorts);
        this.setMouldid(mouldId);
        this.setDefaultvalue(defaultValue);
        this.setSearchshow(searchShow);
        this.setValidexp(validExp);
        this.setMetaType(metaType);
    }

    public String getMetaType() {
        return metaType;
    }

    public void setMetaType(String metaType) {
        this.metaType = metaType;
    }
}
