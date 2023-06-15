package com.qinchao.cms.entity;

import java.util.ArrayList;
import java.util.List;

public class DbDatalibrarysExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DbDatalibrarysExample() {
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

        public Criteria andDatabaseidIsNull() {
            addCriterion("DataBaseID is null");
            return (Criteria) this;
        }

        public Criteria andDatabaseidIsNotNull() {
            addCriterion("DataBaseID is not null");
            return (Criteria) this;
        }

        public Criteria andDatabaseidEqualTo(Integer value) {
            addCriterion("DataBaseID =", value, "databaseid");
            return (Criteria) this;
        }

        public Criteria andDatabaseidNotEqualTo(Integer value) {
            addCriterion("DataBaseID <>", value, "databaseid");
            return (Criteria) this;
        }

        public Criteria andDatabaseidGreaterThan(Integer value) {
            addCriterion("DataBaseID >", value, "databaseid");
            return (Criteria) this;
        }

        public Criteria andDatabaseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DataBaseID >=", value, "databaseid");
            return (Criteria) this;
        }

        public Criteria andDatabaseidLessThan(Integer value) {
            addCriterion("DataBaseID <", value, "databaseid");
            return (Criteria) this;
        }

        public Criteria andDatabaseidLessThanOrEqualTo(Integer value) {
            addCriterion("DataBaseID <=", value, "databaseid");
            return (Criteria) this;
        }

        public Criteria andDatabaseidIn(List<Integer> values) {
            addCriterion("DataBaseID in", values, "databaseid");
            return (Criteria) this;
        }

        public Criteria andDatabaseidNotIn(List<Integer> values) {
            addCriterion("DataBaseID not in", values, "databaseid");
            return (Criteria) this;
        }

        public Criteria andDatabaseidBetween(Integer value1, Integer value2) {
            addCriterion("DataBaseID between", value1, value2, "databaseid");
            return (Criteria) this;
        }

        public Criteria andDatabaseidNotBetween(Integer value1, Integer value2) {
            addCriterion("DataBaseID not between", value1, value2, "databaseid");
            return (Criteria) this;
        }

        public Criteria andDatabasenameIsNull() {
            addCriterion("DataBaseName is null");
            return (Criteria) this;
        }

        public Criteria andDatabasenameIsNotNull() {
            addCriterion("DataBaseName is not null");
            return (Criteria) this;
        }

        public Criteria andDatabasenameEqualTo(String value) {
            addCriterion("DataBaseName =", value, "databasename");
            return (Criteria) this;
        }

        public Criteria andDatabasenameNotEqualTo(String value) {
            addCriterion("DataBaseName <>", value, "databasename");
            return (Criteria) this;
        }

        public Criteria andDatabasenameGreaterThan(String value) {
            addCriterion("DataBaseName >", value, "databasename");
            return (Criteria) this;
        }

        public Criteria andDatabasenameGreaterThanOrEqualTo(String value) {
            addCriterion("DataBaseName >=", value, "databasename");
            return (Criteria) this;
        }

        public Criteria andDatabasenameLessThan(String value) {
            addCriterion("DataBaseName <", value, "databasename");
            return (Criteria) this;
        }

        public Criteria andDatabasenameLessThanOrEqualTo(String value) {
            addCriterion("DataBaseName <=", value, "databasename");
            return (Criteria) this;
        }

        public Criteria andDatabasenameLike(String value) {
            addCriterion("DataBaseName like", value, "databasename");
            return (Criteria) this;
        }

        public Criteria andDatabasenameNotLike(String value) {
            addCriterion("DataBaseName not like", value, "databasename");
            return (Criteria) this;
        }

        public Criteria andDatabasenameIn(List<String> values) {
            addCriterion("DataBaseName in", values, "databasename");
            return (Criteria) this;
        }

        public Criteria andDatabasenameNotIn(List<String> values) {
            addCriterion("DataBaseName not in", values, "databasename");
            return (Criteria) this;
        }

        public Criteria andDatabasenameBetween(String value1, String value2) {
            addCriterion("DataBaseName between", value1, value2, "databasename");
            return (Criteria) this;
        }

        public Criteria andDatabasenameNotBetween(String value1, String value2) {
            addCriterion("DataBaseName not between", value1, value2, "databasename");
            return (Criteria) this;
        }

        public Criteria andDatabasecnameIsNull() {
            addCriterion("DataBaseCName is null");
            return (Criteria) this;
        }

        public Criteria andDatabasecnameIsNotNull() {
            addCriterion("DataBaseCName is not null");
            return (Criteria) this;
        }

        public Criteria andDatabasecnameEqualTo(String value) {
            addCriterion("DataBaseCName =", value, "databasecname");
            return (Criteria) this;
        }

        public Criteria andDatabasecnameNotEqualTo(String value) {
            addCriterion("DataBaseCName <>", value, "databasecname");
            return (Criteria) this;
        }

        public Criteria andDatabasecnameGreaterThan(String value) {
            addCriterion("DataBaseCName >", value, "databasecname");
            return (Criteria) this;
        }

        public Criteria andDatabasecnameGreaterThanOrEqualTo(String value) {
            addCriterion("DataBaseCName >=", value, "databasecname");
            return (Criteria) this;
        }

        public Criteria andDatabasecnameLessThan(String value) {
            addCriterion("DataBaseCName <", value, "databasecname");
            return (Criteria) this;
        }

        public Criteria andDatabasecnameLessThanOrEqualTo(String value) {
            addCriterion("DataBaseCName <=", value, "databasecname");
            return (Criteria) this;
        }

        public Criteria andDatabasecnameLike(String value) {
            addCriterion("DataBaseCName like", value, "databasecname");
            return (Criteria) this;
        }

        public Criteria andDatabasecnameNotLike(String value) {
            addCriterion("DataBaseCName not like", value, "databasecname");
            return (Criteria) this;
        }

        public Criteria andDatabasecnameIn(List<String> values) {
            addCriterion("DataBaseCName in", values, "databasecname");
            return (Criteria) this;
        }

        public Criteria andDatabasecnameNotIn(List<String> values) {
            addCriterion("DataBaseCName not in", values, "databasecname");
            return (Criteria) this;
        }

        public Criteria andDatabasecnameBetween(String value1, String value2) {
            addCriterion("DataBaseCName between", value1, value2, "databasecname");
            return (Criteria) this;
        }

        public Criteria andDatabasecnameNotBetween(String value1, String value2) {
            addCriterion("DataBaseCName not between", value1, value2, "databasecname");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("Description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("Description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("Description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("Description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("Description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("Description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("Description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("Description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("Description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("Description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("Description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("Description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("Description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("Description not between", value1, value2, "description");
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

        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Status not between", value1, value2, "status");
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
