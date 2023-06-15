package com.qinchao.cms.entity;

import java.util.ArrayList;
import java.util.List;

public class DbMouldsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DbMouldsExample() {
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

        public Criteria andMouldnameIsNull() {
            addCriterion("MouldName is null");
            return (Criteria) this;
        }

        public Criteria andMouldnameIsNotNull() {
            addCriterion("MouldName is not null");
            return (Criteria) this;
        }

        public Criteria andMouldnameEqualTo(String value) {
            addCriterion("MouldName =", value, "mouldname");
            return (Criteria) this;
        }

        public Criteria andMouldnameNotEqualTo(String value) {
            addCriterion("MouldName <>", value, "mouldname");
            return (Criteria) this;
        }

        public Criteria andMouldnameGreaterThan(String value) {
            addCriterion("MouldName >", value, "mouldname");
            return (Criteria) this;
        }

        public Criteria andMouldnameGreaterThanOrEqualTo(String value) {
            addCriterion("MouldName >=", value, "mouldname");
            return (Criteria) this;
        }

        public Criteria andMouldnameLessThan(String value) {
            addCriterion("MouldName <", value, "mouldname");
            return (Criteria) this;
        }

        public Criteria andMouldnameLessThanOrEqualTo(String value) {
            addCriterion("MouldName <=", value, "mouldname");
            return (Criteria) this;
        }

        public Criteria andMouldnameLike(String value) {
            addCriterion("MouldName like", value, "mouldname");
            return (Criteria) this;
        }

        public Criteria andMouldnameNotLike(String value) {
            addCriterion("MouldName not like", value, "mouldname");
            return (Criteria) this;
        }

        public Criteria andMouldnameIn(List<String> values) {
            addCriterion("MouldName in", values, "mouldname");
            return (Criteria) this;
        }

        public Criteria andMouldnameNotIn(List<String> values) {
            addCriterion("MouldName not in", values, "mouldname");
            return (Criteria) this;
        }

        public Criteria andMouldnameBetween(String value1, String value2) {
            addCriterion("MouldName between", value1, value2, "mouldname");
            return (Criteria) this;
        }

        public Criteria andMouldnameNotBetween(String value1, String value2) {
            addCriterion("MouldName not between", value1, value2, "mouldname");
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
