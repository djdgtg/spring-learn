package com.qinchao.cms.entity;

import java.util.ArrayList;
import java.util.List;

public class DbMetadatasExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DbMetadatasExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMetadataidIsNull() {
            addCriterion("MetaDataID is null");
            return (Criteria) this;
        }

        public Criteria andMetadataidIsNotNull() {
            addCriterion("MetaDataID is not null");
            return (Criteria) this;
        }

        public Criteria andMetadataidEqualTo(Integer value) {
            addCriterion("MetaDataID =", value, "metadataid");
            return (Criteria) this;
        }

        public Criteria andMetadataidNotEqualTo(Integer value) {
            addCriterion("MetaDataID <>", value, "metadataid");
            return (Criteria) this;
        }

        public Criteria andMetadataidGreaterThan(Integer value) {
            addCriterion("MetaDataID >", value, "metadataid");
            return (Criteria) this;
        }

        public Criteria andMetadataidGreaterThanOrEqualTo(Integer value) {
            addCriterion("MetaDataID >=", value, "metadataid");
            return (Criteria) this;
        }

        public Criteria andMetadataidLessThan(Integer value) {
            addCriterion("MetaDataID <", value, "metadataid");
            return (Criteria) this;
        }

        public Criteria andMetadataidLessThanOrEqualTo(Integer value) {
            addCriterion("MetaDataID <=", value, "metadataid");
            return (Criteria) this;
        }

        public Criteria andMetadataidIn(List<Integer> values) {
            addCriterion("MetaDataID in", values, "metadataid");
            return (Criteria) this;
        }

        public Criteria andMetadataidNotIn(List<Integer> values) {
            addCriterion("MetaDataID not in", values, "metadataid");
            return (Criteria) this;
        }

        public Criteria andMetadataidBetween(Integer value1, Integer value2) {
            addCriterion("MetaDataID between", value1, value2, "metadataid");
            return (Criteria) this;
        }

        public Criteria andMetadataidNotBetween(Integer value1, Integer value2) {
            addCriterion("MetaDataID not between", value1, value2, "metadataid");
            return (Criteria) this;
        }

        public Criteria andColumnnameIsNull() {
            addCriterion("ColumnName is null");
            return (Criteria) this;
        }

        public Criteria andColumnnameIsNotNull() {
            addCriterion("ColumnName is not null");
            return (Criteria) this;
        }

        public Criteria andColumnnameEqualTo(String value) {
            addCriterion("ColumnName =", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotEqualTo(String value) {
            addCriterion("ColumnName <>", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameGreaterThan(String value) {
            addCriterion("ColumnName >", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameGreaterThanOrEqualTo(String value) {
            addCriterion("ColumnName >=", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameLessThan(String value) {
            addCriterion("ColumnName <", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameLessThanOrEqualTo(String value) {
            addCriterion("ColumnName <=", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameLike(String value) {
            addCriterion("ColumnName like", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotLike(String value) {
            addCriterion("ColumnName not like", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameIn(List<String> values) {
            addCriterion("ColumnName in", values, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotIn(List<String> values) {
            addCriterion("ColumnName not in", values, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameBetween(String value1, String value2) {
            addCriterion("ColumnName between", value1, value2, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotBetween(String value1, String value2) {
            addCriterion("ColumnName not between", value1, value2, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumncnameIsNull() {
            addCriterion("ColumnCName is null");
            return (Criteria) this;
        }

        public Criteria andColumncnameIsNotNull() {
            addCriterion("ColumnCName is not null");
            return (Criteria) this;
        }

        public Criteria andColumncnameEqualTo(String value) {
            addCriterion("ColumnCName =", value, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameNotEqualTo(String value) {
            addCriterion("ColumnCName <>", value, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameGreaterThan(String value) {
            addCriterion("ColumnCName >", value, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameGreaterThanOrEqualTo(String value) {
            addCriterion("ColumnCName >=", value, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameLessThan(String value) {
            addCriterion("ColumnCName <", value, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameLessThanOrEqualTo(String value) {
            addCriterion("ColumnCName <=", value, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameLike(String value) {
            addCriterion("ColumnCName like", value, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameNotLike(String value) {
            addCriterion("ColumnCName not like", value, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameIn(List<String> values) {
            addCriterion("ColumnCName in", values, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameNotIn(List<String> values) {
            addCriterion("ColumnCName not in", values, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameBetween(String value1, String value2) {
            addCriterion("ColumnCName between", value1, value2, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameNotBetween(String value1, String value2) {
            addCriterion("ColumnCName not between", value1, value2, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumntypeIsNull() {
            addCriterion("ColumnType is null");
            return (Criteria) this;
        }

        public Criteria andColumntypeIsNotNull() {
            addCriterion("ColumnType is not null");
            return (Criteria) this;
        }

        public Criteria andColumntypeEqualTo(Integer value) {
            addCriterion("ColumnType =", value, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeNotEqualTo(Integer value) {
            addCriterion("ColumnType <>", value, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeGreaterThan(Integer value) {
            addCriterion("ColumnType >", value, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ColumnType >=", value, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeLessThan(Integer value) {
            addCriterion("ColumnType <", value, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeLessThanOrEqualTo(Integer value) {
            addCriterion("ColumnType <=", value, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeIn(List<Integer> values) {
            addCriterion("ColumnType in", values, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeNotIn(List<Integer> values) {
            addCriterion("ColumnType not in", values, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeBetween(Integer value1, Integer value2) {
            addCriterion("ColumnType between", value1, value2, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ColumnType not between", value1, value2, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumnsourceIsNull() {
            addCriterion("ColumnSource is null");
            return (Criteria) this;
        }

        public Criteria andColumnsourceIsNotNull() {
            addCriterion("ColumnSource is not null");
            return (Criteria) this;
        }

        public Criteria andColumnsourceEqualTo(Integer value) {
            addCriterion("ColumnSource =", value, "columnsource");
            return (Criteria) this;
        }

        public Criteria andColumnsourceNotEqualTo(Integer value) {
            addCriterion("ColumnSource <>", value, "columnsource");
            return (Criteria) this;
        }

        public Criteria andColumnsourceGreaterThan(Integer value) {
            addCriterion("ColumnSource >", value, "columnsource");
            return (Criteria) this;
        }

        public Criteria andColumnsourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("ColumnSource >=", value, "columnsource");
            return (Criteria) this;
        }

        public Criteria andColumnsourceLessThan(Integer value) {
            addCriterion("ColumnSource <", value, "columnsource");
            return (Criteria) this;
        }

        public Criteria andColumnsourceLessThanOrEqualTo(Integer value) {
            addCriterion("ColumnSource <=", value, "columnsource");
            return (Criteria) this;
        }

        public Criteria andColumnsourceIn(List<Integer> values) {
            addCriterion("ColumnSource in", values, "columnsource");
            return (Criteria) this;
        }

        public Criteria andColumnsourceNotIn(List<Integer> values) {
            addCriterion("ColumnSource not in", values, "columnsource");
            return (Criteria) this;
        }

        public Criteria andColumnsourceBetween(Integer value1, Integer value2) {
            addCriterion("ColumnSource between", value1, value2, "columnsource");
            return (Criteria) this;
        }

        public Criteria andColumnsourceNotBetween(Integer value1, Integer value2) {
            addCriterion("ColumnSource not between", value1, value2, "columnsource");
            return (Criteria) this;
        }

        public Criteria andColumntyperuleIsNull() {
            addCriterion("ColumnTypeRule is null");
            return (Criteria) this;
        }

        public Criteria andColumntyperuleIsNotNull() {
            addCriterion("ColumnTypeRule is not null");
            return (Criteria) this;
        }

        public Criteria andColumntyperuleEqualTo(String value) {
            addCriterion("ColumnTypeRule =", value, "columntyperule");
            return (Criteria) this;
        }

        public Criteria andColumntyperuleNotEqualTo(String value) {
            addCriterion("ColumnTypeRule <>", value, "columntyperule");
            return (Criteria) this;
        }

        public Criteria andColumntyperuleGreaterThan(String value) {
            addCriterion("ColumnTypeRule >", value, "columntyperule");
            return (Criteria) this;
        }

        public Criteria andColumntyperuleGreaterThanOrEqualTo(String value) {
            addCriterion("ColumnTypeRule >=", value, "columntyperule");
            return (Criteria) this;
        }

        public Criteria andColumntyperuleLessThan(String value) {
            addCriterion("ColumnTypeRule <", value, "columntyperule");
            return (Criteria) this;
        }

        public Criteria andColumntyperuleLessThanOrEqualTo(String value) {
            addCriterion("ColumnTypeRule <=", value, "columntyperule");
            return (Criteria) this;
        }

        public Criteria andColumntyperuleLike(String value) {
            addCriterion("ColumnTypeRule like", value, "columntyperule");
            return (Criteria) this;
        }

        public Criteria andColumntyperuleNotLike(String value) {
            addCriterion("ColumnTypeRule not like", value, "columntyperule");
            return (Criteria) this;
        }

        public Criteria andColumntyperuleIn(List<String> values) {
            addCriterion("ColumnTypeRule in", values, "columntyperule");
            return (Criteria) this;
        }

        public Criteria andColumntyperuleNotIn(List<String> values) {
            addCriterion("ColumnTypeRule not in", values, "columntyperule");
            return (Criteria) this;
        }

        public Criteria andColumntyperuleBetween(String value1, String value2) {
            addCriterion("ColumnTypeRule between", value1, value2, "columntyperule");
            return (Criteria) this;
        }

        public Criteria andColumntyperuleNotBetween(String value1, String value2) {
            addCriterion("ColumnTypeRule not between", value1, value2, "columntyperule");
            return (Criteria) this;
        }

        public Criteria andDatatypeIsNull() {
            addCriterion("DataType is null");
            return (Criteria) this;
        }

        public Criteria andDatatypeIsNotNull() {
            addCriterion("DataType is not null");
            return (Criteria) this;
        }

        public Criteria andDatatypeEqualTo(String value) {
            addCriterion("DataType =", value, "datatype");
            return (Criteria) this;
        }

        public Criteria andDatatypeNotEqualTo(String value) {
            addCriterion("DataType <>", value, "datatype");
            return (Criteria) this;
        }

        public Criteria andDatatypeGreaterThan(String value) {
            addCriterion("DataType >", value, "datatype");
            return (Criteria) this;
        }

        public Criteria andDatatypeGreaterThanOrEqualTo(String value) {
            addCriterion("DataType >=", value, "datatype");
            return (Criteria) this;
        }

        public Criteria andDatatypeLessThan(String value) {
            addCriterion("DataType <", value, "datatype");
            return (Criteria) this;
        }

        public Criteria andDatatypeLessThanOrEqualTo(String value) {
            addCriterion("DataType <=", value, "datatype");
            return (Criteria) this;
        }

        public Criteria andDatatypeLike(String value) {
            addCriterion("DataType like", value, "datatype");
            return (Criteria) this;
        }

        public Criteria andDatatypeNotLike(String value) {
            addCriterion("DataType not like", value, "datatype");
            return (Criteria) this;
        }

        public Criteria andDatatypeIn(List<String> values) {
            addCriterion("DataType in", values, "datatype");
            return (Criteria) this;
        }

        public Criteria andDatatypeNotIn(List<String> values) {
            addCriterion("DataType not in", values, "datatype");
            return (Criteria) this;
        }

        public Criteria andDatatypeBetween(String value1, String value2) {
            addCriterion("DataType between", value1, value2, "datatype");
            return (Criteria) this;
        }

        public Criteria andDatatypeNotBetween(String value1, String value2) {
            addCriterion("DataType not between", value1, value2, "datatype");
            return (Criteria) this;
        }

        public Criteria andColumnlengthIsNull() {
            addCriterion("ColumnLength is null");
            return (Criteria) this;
        }

        public Criteria andColumnlengthIsNotNull() {
            addCriterion("ColumnLength is not null");
            return (Criteria) this;
        }

        public Criteria andColumnlengthEqualTo(Integer value) {
            addCriterion("ColumnLength =", value, "columnlength");
            return (Criteria) this;
        }

        public Criteria andColumnlengthNotEqualTo(Integer value) {
            addCriterion("ColumnLength <>", value, "columnlength");
            return (Criteria) this;
        }

        public Criteria andColumnlengthGreaterThan(Integer value) {
            addCriterion("ColumnLength >", value, "columnlength");
            return (Criteria) this;
        }

        public Criteria andColumnlengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("ColumnLength >=", value, "columnlength");
            return (Criteria) this;
        }

        public Criteria andColumnlengthLessThan(Integer value) {
            addCriterion("ColumnLength <", value, "columnlength");
            return (Criteria) this;
        }

        public Criteria andColumnlengthLessThanOrEqualTo(Integer value) {
            addCriterion("ColumnLength <=", value, "columnlength");
            return (Criteria) this;
        }

        public Criteria andColumnlengthIn(List<Integer> values) {
            addCriterion("ColumnLength in", values, "columnlength");
            return (Criteria) this;
        }

        public Criteria andColumnlengthNotIn(List<Integer> values) {
            addCriterion("ColumnLength not in", values, "columnlength");
            return (Criteria) this;
        }

        public Criteria andColumnlengthBetween(Integer value1, Integer value2) {
            addCriterion("ColumnLength between", value1, value2, "columnlength");
            return (Criteria) this;
        }

        public Criteria andColumnlengthNotBetween(Integer value1, Integer value2) {
            addCriterion("ColumnLength not between", value1, value2, "columnlength");
            return (Criteria) this;
        }

        public Criteria andFormshowIsNull() {
            addCriterion("FormShow is null");
            return (Criteria) this;
        }

        public Criteria andFormshowIsNotNull() {
            addCriterion("FormShow is not null");
            return (Criteria) this;
        }

        public Criteria andFormshowEqualTo(Integer value) {
            addCriterion("FormShow =", value, "formshow");
            return (Criteria) this;
        }

        public Criteria andFormshowNotEqualTo(Integer value) {
            addCriterion("FormShow <>", value, "formshow");
            return (Criteria) this;
        }

        public Criteria andFormshowGreaterThan(Integer value) {
            addCriterion("FormShow >", value, "formshow");
            return (Criteria) this;
        }

        public Criteria andFormshowGreaterThanOrEqualTo(Integer value) {
            addCriterion("FormShow >=", value, "formshow");
            return (Criteria) this;
        }

        public Criteria andFormshowLessThan(Integer value) {
            addCriterion("FormShow <", value, "formshow");
            return (Criteria) this;
        }

        public Criteria andFormshowLessThanOrEqualTo(Integer value) {
            addCriterion("FormShow <=", value, "formshow");
            return (Criteria) this;
        }

        public Criteria andFormshowIn(List<Integer> values) {
            addCriterion("FormShow in", values, "formshow");
            return (Criteria) this;
        }

        public Criteria andFormshowNotIn(List<Integer> values) {
            addCriterion("FormShow not in", values, "formshow");
            return (Criteria) this;
        }

        public Criteria andFormshowBetween(Integer value1, Integer value2) {
            addCriterion("FormShow between", value1, value2, "formshow");
            return (Criteria) this;
        }

        public Criteria andFormshowNotBetween(Integer value1, Integer value2) {
            addCriterion("FormShow not between", value1, value2, "formshow");
            return (Criteria) this;
        }

        public Criteria andGridshowIsNull() {
            addCriterion("GridShow is null");
            return (Criteria) this;
        }

        public Criteria andGridshowIsNotNull() {
            addCriterion("GridShow is not null");
            return (Criteria) this;
        }

        public Criteria andGridshowEqualTo(Integer value) {
            addCriterion("GridShow =", value, "gridshow");
            return (Criteria) this;
        }

        public Criteria andGridshowNotEqualTo(Integer value) {
            addCriterion("GridShow <>", value, "gridshow");
            return (Criteria) this;
        }

        public Criteria andGridshowGreaterThan(Integer value) {
            addCriterion("GridShow >", value, "gridshow");
            return (Criteria) this;
        }

        public Criteria andGridshowGreaterThanOrEqualTo(Integer value) {
            addCriterion("GridShow >=", value, "gridshow");
            return (Criteria) this;
        }

        public Criteria andGridshowLessThan(Integer value) {
            addCriterion("GridShow <", value, "gridshow");
            return (Criteria) this;
        }

        public Criteria andGridshowLessThanOrEqualTo(Integer value) {
            addCriterion("GridShow <=", value, "gridshow");
            return (Criteria) this;
        }

        public Criteria andGridshowIn(List<Integer> values) {
            addCriterion("GridShow in", values, "gridshow");
            return (Criteria) this;
        }

        public Criteria andGridshowNotIn(List<Integer> values) {
            addCriterion("GridShow not in", values, "gridshow");
            return (Criteria) this;
        }

        public Criteria andGridshowBetween(Integer value1, Integer value2) {
            addCriterion("GridShow between", value1, value2, "gridshow");
            return (Criteria) this;
        }

        public Criteria andGridshowNotBetween(Integer value1, Integer value2) {
            addCriterion("GridShow not between", value1, value2, "gridshow");
            return (Criteria) this;
        }

        public Criteria andSortsIsNull() {
            addCriterion("Sorts is null");
            return (Criteria) this;
        }

        public Criteria andSortsIsNotNull() {
            addCriterion("Sorts is not null");
            return (Criteria) this;
        }

        public Criteria andSortsEqualTo(Integer value) {
            addCriterion("Sorts =", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotEqualTo(Integer value) {
            addCriterion("Sorts <>", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsGreaterThan(Integer value) {
            addCriterion("Sorts >", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsGreaterThanOrEqualTo(Integer value) {
            addCriterion("Sorts >=", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsLessThan(Integer value) {
            addCriterion("Sorts <", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsLessThanOrEqualTo(Integer value) {
            addCriterion("Sorts <=", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsIn(List<Integer> values) {
            addCriterion("Sorts in", values, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotIn(List<Integer> values) {
            addCriterion("Sorts not in", values, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsBetween(Integer value1, Integer value2) {
            addCriterion("Sorts between", value1, value2, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotBetween(Integer value1, Integer value2) {
            addCriterion("Sorts not between", value1, value2, "sorts");
            return (Criteria) this;
        }

        public Criteria andMouldidIsNull() {
            addCriterion("MouldID is null");
            return (Criteria) this;
        }

        public Criteria andMouldidIsNotNull() {
            addCriterion("MouldID is not null");
            return (Criteria) this;
        }

        public Criteria andMouldidEqualTo(Integer value) {
            addCriterion("MouldID =", value, "mouldid");
            return (Criteria) this;
        }

        public Criteria andMouldidNotEqualTo(Integer value) {
            addCriterion("MouldID <>", value, "mouldid");
            return (Criteria) this;
        }

        public Criteria andMouldidGreaterThan(Integer value) {
            addCriterion("MouldID >", value, "mouldid");
            return (Criteria) this;
        }

        public Criteria andMouldidGreaterThanOrEqualTo(Integer value) {
            addCriterion("MouldID >=", value, "mouldid");
            return (Criteria) this;
        }

        public Criteria andMouldidLessThan(Integer value) {
            addCriterion("MouldID <", value, "mouldid");
            return (Criteria) this;
        }

        public Criteria andMouldidLessThanOrEqualTo(Integer value) {
            addCriterion("MouldID <=", value, "mouldid");
            return (Criteria) this;
        }

        public Criteria andMouldidIn(List<Integer> values) {
            addCriterion("MouldID in", values, "mouldid");
            return (Criteria) this;
        }

        public Criteria andMouldidNotIn(List<Integer> values) {
            addCriterion("MouldID not in", values, "mouldid");
            return (Criteria) this;
        }

        public Criteria andMouldidBetween(Integer value1, Integer value2) {
            addCriterion("MouldID between", value1, value2, "mouldid");
            return (Criteria) this;
        }

        public Criteria andMouldidNotBetween(Integer value1, Integer value2) {
            addCriterion("MouldID not between", value1, value2, "mouldid");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueIsNull() {
            addCriterion("DefaultValue is null");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueIsNotNull() {
            addCriterion("DefaultValue is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueEqualTo(String value) {
            addCriterion("DefaultValue =", value, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueNotEqualTo(String value) {
            addCriterion("DefaultValue <>", value, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueGreaterThan(String value) {
            addCriterion("DefaultValue >", value, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueGreaterThanOrEqualTo(String value) {
            addCriterion("DefaultValue >=", value, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueLessThan(String value) {
            addCriterion("DefaultValue <", value, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueLessThanOrEqualTo(String value) {
            addCriterion("DefaultValue <=", value, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueLike(String value) {
            addCriterion("DefaultValue like", value, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueNotLike(String value) {
            addCriterion("DefaultValue not like", value, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueIn(List<String> values) {
            addCriterion("DefaultValue in", values, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueNotIn(List<String> values) {
            addCriterion("DefaultValue not in", values, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueBetween(String value1, String value2) {
            addCriterion("DefaultValue between", value1, value2, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andDefaultvalueNotBetween(String value1, String value2) {
            addCriterion("DefaultValue not between", value1, value2, "defaultvalue");
            return (Criteria) this;
        }

        public Criteria andSearchshowIsNull() {
            addCriterion("SearchShow is null");
            return (Criteria) this;
        }

        public Criteria andSearchshowIsNotNull() {
            addCriterion("SearchShow is not null");
            return (Criteria) this;
        }

        public Criteria andSearchshowEqualTo(Integer value) {
            addCriterion("SearchShow =", value, "searchshow");
            return (Criteria) this;
        }

        public Criteria andSearchshowNotEqualTo(Integer value) {
            addCriterion("SearchShow <>", value, "searchshow");
            return (Criteria) this;
        }

        public Criteria andSearchshowGreaterThan(Integer value) {
            addCriterion("SearchShow >", value, "searchshow");
            return (Criteria) this;
        }

        public Criteria andSearchshowGreaterThanOrEqualTo(Integer value) {
            addCriterion("SearchShow >=", value, "searchshow");
            return (Criteria) this;
        }

        public Criteria andSearchshowLessThan(Integer value) {
            addCriterion("SearchShow <", value, "searchshow");
            return (Criteria) this;
        }

        public Criteria andSearchshowLessThanOrEqualTo(Integer value) {
            addCriterion("SearchShow <=", value, "searchshow");
            return (Criteria) this;
        }

        public Criteria andSearchshowIn(List<Integer> values) {
            addCriterion("SearchShow in", values, "searchshow");
            return (Criteria) this;
        }

        public Criteria andSearchshowNotIn(List<Integer> values) {
            addCriterion("SearchShow not in", values, "searchshow");
            return (Criteria) this;
        }

        public Criteria andSearchshowBetween(Integer value1, Integer value2) {
            addCriterion("SearchShow between", value1, value2, "searchshow");
            return (Criteria) this;
        }

        public Criteria andSearchshowNotBetween(Integer value1, Integer value2) {
            addCriterion("SearchShow not between", value1, value2, "searchshow");
            return (Criteria) this;
        }

        public Criteria andImportandexportshowIsNull() {
            addCriterion("ImportAndExportShow is null");
            return (Criteria) this;
        }

        public Criteria andImportandexportshowIsNotNull() {
            addCriterion("ImportAndExportShow is not null");
            return (Criteria) this;
        }

        public Criteria andImportandexportshowEqualTo(Integer value) {
            addCriterion("ImportAndExportShow =", value, "importandexportshow");
            return (Criteria) this;
        }

        public Criteria andImportandexportshowNotEqualTo(Integer value) {
            addCriterion("ImportAndExportShow <>", value, "importandexportshow");
            return (Criteria) this;
        }

        public Criteria andImportandexportshowGreaterThan(Integer value) {
            addCriterion("ImportAndExportShow >", value, "importandexportshow");
            return (Criteria) this;
        }

        public Criteria andImportandexportshowGreaterThanOrEqualTo(Integer value) {
            addCriterion("ImportAndExportShow >=", value, "importandexportshow");
            return (Criteria) this;
        }

        public Criteria andImportandexportshowLessThan(Integer value) {
            addCriterion("ImportAndExportShow <", value, "importandexportshow");
            return (Criteria) this;
        }

        public Criteria andImportandexportshowLessThanOrEqualTo(Integer value) {
            addCriterion("ImportAndExportShow <=", value, "importandexportshow");
            return (Criteria) this;
        }

        public Criteria andImportandexportshowIn(List<Integer> values) {
            addCriterion("ImportAndExportShow in", values, "importandexportshow");
            return (Criteria) this;
        }

        public Criteria andImportandexportshowNotIn(List<Integer> values) {
            addCriterion("ImportAndExportShow not in", values, "importandexportshow");
            return (Criteria) this;
        }

        public Criteria andImportandexportshowBetween(Integer value1, Integer value2) {
            addCriterion("ImportAndExportShow between", value1, value2, "importandexportshow");
            return (Criteria) this;
        }

        public Criteria andImportandexportshowNotBetween(Integer value1, Integer value2) {
            addCriterion("ImportAndExportShow not between", value1, value2, "importandexportshow");
            return (Criteria) this;
        }

        public Criteria andRequiredIsNull() {
            addCriterion("Required is null");
            return (Criteria) this;
        }

        public Criteria andRequiredIsNotNull() {
            addCriterion("Required is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredEqualTo(Integer value) {
            addCriterion("Required =", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotEqualTo(Integer value) {
            addCriterion("Required <>", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThan(Integer value) {
            addCriterion("Required >", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThanOrEqualTo(Integer value) {
            addCriterion("Required >=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThan(Integer value) {
            addCriterion("Required <", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThanOrEqualTo(Integer value) {
            addCriterion("Required <=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredIn(List<Integer> values) {
            addCriterion("Required in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotIn(List<Integer> values) {
            addCriterion("Required not in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredBetween(Integer value1, Integer value2) {
            addCriterion("Required between", value1, value2, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotBetween(Integer value1, Integer value2) {
            addCriterion("Required not between", value1, value2, "required");
            return (Criteria) this;
        }

        public Criteria andEditableIsNull() {
            addCriterion("Editable is null");
            return (Criteria) this;
        }

        public Criteria andEditableIsNotNull() {
            addCriterion("Editable is not null");
            return (Criteria) this;
        }

        public Criteria andEditableEqualTo(Integer value) {
            addCriterion("Editable =", value, "editable");
            return (Criteria) this;
        }

        public Criteria andEditableNotEqualTo(Integer value) {
            addCriterion("Editable <>", value, "editable");
            return (Criteria) this;
        }

        public Criteria andEditableGreaterThan(Integer value) {
            addCriterion("Editable >", value, "editable");
            return (Criteria) this;
        }

        public Criteria andEditableGreaterThanOrEqualTo(Integer value) {
            addCriterion("Editable >=", value, "editable");
            return (Criteria) this;
        }

        public Criteria andEditableLessThan(Integer value) {
            addCriterion("Editable <", value, "editable");
            return (Criteria) this;
        }

        public Criteria andEditableLessThanOrEqualTo(Integer value) {
            addCriterion("Editable <=", value, "editable");
            return (Criteria) this;
        }

        public Criteria andEditableIn(List<Integer> values) {
            addCriterion("Editable in", values, "editable");
            return (Criteria) this;
        }

        public Criteria andEditableNotIn(List<Integer> values) {
            addCriterion("Editable not in", values, "editable");
            return (Criteria) this;
        }

        public Criteria andEditableBetween(Integer value1, Integer value2) {
            addCriterion("Editable between", value1, value2, "editable");
            return (Criteria) this;
        }

        public Criteria andEditableNotBetween(Integer value1, Integer value2) {
            addCriterion("Editable not between", value1, value2, "editable");
            return (Criteria) this;
        }

        public Criteria andOnlyIsNull() {
            addCriterion("Only is null");
            return (Criteria) this;
        }

        public Criteria andOnlyIsNotNull() {
            addCriterion("Only is not null");
            return (Criteria) this;
        }

        public Criteria andOnlyEqualTo(Integer value) {
            addCriterion("Only =", value, "only");
            return (Criteria) this;
        }

        public Criteria andOnlyNotEqualTo(Integer value) {
            addCriterion("Only <>", value, "only");
            return (Criteria) this;
        }

        public Criteria andOnlyGreaterThan(Integer value) {
            addCriterion("Only >", value, "only");
            return (Criteria) this;
        }

        public Criteria andOnlyGreaterThanOrEqualTo(Integer value) {
            addCriterion("Only >=", value, "only");
            return (Criteria) this;
        }

        public Criteria andOnlyLessThan(Integer value) {
            addCriterion("Only <", value, "only");
            return (Criteria) this;
        }

        public Criteria andOnlyLessThanOrEqualTo(Integer value) {
            addCriterion("Only <=", value, "only");
            return (Criteria) this;
        }

        public Criteria andOnlyIn(List<Integer> values) {
            addCriterion("Only in", values, "only");
            return (Criteria) this;
        }

        public Criteria andOnlyNotIn(List<Integer> values) {
            addCriterion("Only not in", values, "only");
            return (Criteria) this;
        }

        public Criteria andOnlyBetween(Integer value1, Integer value2) {
            addCriterion("Only between", value1, value2, "only");
            return (Criteria) this;
        }

        public Criteria andOnlyNotBetween(Integer value1, Integer value2) {
            addCriterion("Only not between", value1, value2, "only");
            return (Criteria) this;
        }

        public Criteria andValidexpIsNull() {
            addCriterion("ValidExp is null");
            return (Criteria) this;
        }

        public Criteria andValidexpIsNotNull() {
            addCriterion("ValidExp is not null");
            return (Criteria) this;
        }

        public Criteria andValidexpEqualTo(String value) {
            addCriterion("ValidExp =", value, "validexp");
            return (Criteria) this;
        }

        public Criteria andValidexpNotEqualTo(String value) {
            addCriterion("ValidExp <>", value, "validexp");
            return (Criteria) this;
        }

        public Criteria andValidexpGreaterThan(String value) {
            addCriterion("ValidExp >", value, "validexp");
            return (Criteria) this;
        }

        public Criteria andValidexpGreaterThanOrEqualTo(String value) {
            addCriterion("ValidExp >=", value, "validexp");
            return (Criteria) this;
        }

        public Criteria andValidexpLessThan(String value) {
            addCriterion("ValidExp <", value, "validexp");
            return (Criteria) this;
        }

        public Criteria andValidexpLessThanOrEqualTo(String value) {
            addCriterion("ValidExp <=", value, "validexp");
            return (Criteria) this;
        }

        public Criteria andValidexpLike(String value) {
            addCriterion("ValidExp like", value, "validexp");
            return (Criteria) this;
        }

        public Criteria andValidexpNotLike(String value) {
            addCriterion("ValidExp not like", value, "validexp");
            return (Criteria) this;
        }

        public Criteria andValidexpIn(List<String> values) {
            addCriterion("ValidExp in", values, "validexp");
            return (Criteria) this;
        }

        public Criteria andValidexpNotIn(List<String> values) {
            addCriterion("ValidExp not in", values, "validexp");
            return (Criteria) this;
        }

        public Criteria andValidexpBetween(String value1, String value2) {
            addCriterion("ValidExp between", value1, value2, "validexp");
            return (Criteria) this;
        }

        public Criteria andValidexpNotBetween(String value1, String value2) {
            addCriterion("ValidExp not between", value1, value2, "validexp");
            return (Criteria) this;
        }

        public Criteria andValidmsgIsNull() {
            addCriterion("ValidMsg is null");
            return (Criteria) this;
        }

        public Criteria andValidmsgIsNotNull() {
            addCriterion("ValidMsg is not null");
            return (Criteria) this;
        }

        public Criteria andValidmsgEqualTo(String value) {
            addCriterion("ValidMsg =", value, "validmsg");
            return (Criteria) this;
        }

        public Criteria andValidmsgNotEqualTo(String value) {
            addCriterion("ValidMsg <>", value, "validmsg");
            return (Criteria) this;
        }

        public Criteria andValidmsgGreaterThan(String value) {
            addCriterion("ValidMsg >", value, "validmsg");
            return (Criteria) this;
        }

        public Criteria andValidmsgGreaterThanOrEqualTo(String value) {
            addCriterion("ValidMsg >=", value, "validmsg");
            return (Criteria) this;
        }

        public Criteria andValidmsgLessThan(String value) {
            addCriterion("ValidMsg <", value, "validmsg");
            return (Criteria) this;
        }

        public Criteria andValidmsgLessThanOrEqualTo(String value) {
            addCriterion("ValidMsg <=", value, "validmsg");
            return (Criteria) this;
        }

        public Criteria andValidmsgLike(String value) {
            addCriterion("ValidMsg like", value, "validmsg");
            return (Criteria) this;
        }

        public Criteria andValidmsgNotLike(String value) {
            addCriterion("ValidMsg not like", value, "validmsg");
            return (Criteria) this;
        }

        public Criteria andValidmsgIn(List<String> values) {
            addCriterion("ValidMsg in", values, "validmsg");
            return (Criteria) this;
        }

        public Criteria andValidmsgNotIn(List<String> values) {
            addCriterion("ValidMsg not in", values, "validmsg");
            return (Criteria) this;
        }

        public Criteria andValidmsgBetween(String value1, String value2) {
            addCriterion("ValidMsg between", value1, value2, "validmsg");
            return (Criteria) this;
        }

        public Criteria andValidmsgNotBetween(String value1, String value2) {
            addCriterion("ValidMsg not between", value1, value2, "validmsg");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
