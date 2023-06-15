package com.qinchao.cms.entity;

import java.util.ArrayList;
import java.util.List;

public class NationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NationExample() {
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

        public Criteria andNationidIsNull() {
            addCriterion("NationID is null");
            return (Criteria) this;
        }

        public Criteria andNationidIsNotNull() {
            addCriterion("NationID is not null");
            return (Criteria) this;
        }

        public Criteria andNationidEqualTo(Integer value) {
            addCriterion("NationID =", value, "nationid");
            return (Criteria) this;
        }

        public Criteria andNationidNotEqualTo(Integer value) {
            addCriterion("NationID <>", value, "nationid");
            return (Criteria) this;
        }

        public Criteria andNationidGreaterThan(Integer value) {
            addCriterion("NationID >", value, "nationid");
            return (Criteria) this;
        }

        public Criteria andNationidGreaterThanOrEqualTo(Integer value) {
            addCriterion("NationID >=", value, "nationid");
            return (Criteria) this;
        }

        public Criteria andNationidLessThan(Integer value) {
            addCriterion("NationID <", value, "nationid");
            return (Criteria) this;
        }

        public Criteria andNationidLessThanOrEqualTo(Integer value) {
            addCriterion("NationID <=", value, "nationid");
            return (Criteria) this;
        }

        public Criteria andNationidIn(List<Integer> values) {
            addCriterion("NationID in", values, "nationid");
            return (Criteria) this;
        }

        public Criteria andNationidNotIn(List<Integer> values) {
            addCriterion("NationID not in", values, "nationid");
            return (Criteria) this;
        }

        public Criteria andNationidBetween(Integer value1, Integer value2) {
            addCriterion("NationID between", value1, value2, "nationid");
            return (Criteria) this;
        }

        public Criteria andNationidNotBetween(Integer value1, Integer value2) {
            addCriterion("NationID not between", value1, value2, "nationid");
            return (Criteria) this;
        }

        public Criteria andNationnameIsNull() {
            addCriterion("NationName is null");
            return (Criteria) this;
        }

        public Criteria andNationnameIsNotNull() {
            addCriterion("NationName is not null");
            return (Criteria) this;
        }

        public Criteria andNationnameEqualTo(String value) {
            addCriterion("NationName =", value, "nationname");
            return (Criteria) this;
        }

        public Criteria andNationnameNotEqualTo(String value) {
            addCriterion("NationName <>", value, "nationname");
            return (Criteria) this;
        }

        public Criteria andNationnameGreaterThan(String value) {
            addCriterion("NationName >", value, "nationname");
            return (Criteria) this;
        }

        public Criteria andNationnameGreaterThanOrEqualTo(String value) {
            addCriterion("NationName >=", value, "nationname");
            return (Criteria) this;
        }

        public Criteria andNationnameLessThan(String value) {
            addCriterion("NationName <", value, "nationname");
            return (Criteria) this;
        }

        public Criteria andNationnameLessThanOrEqualTo(String value) {
            addCriterion("NationName <=", value, "nationname");
            return (Criteria) this;
        }

        public Criteria andNationnameLike(String value) {
            addCriterion("NationName like", value, "nationname");
            return (Criteria) this;
        }

        public Criteria andNationnameNotLike(String value) {
            addCriterion("NationName not like", value, "nationname");
            return (Criteria) this;
        }

        public Criteria andNationnameIn(List<String> values) {
            addCriterion("NationName in", values, "nationname");
            return (Criteria) this;
        }

        public Criteria andNationnameNotIn(List<String> values) {
            addCriterion("NationName not in", values, "nationname");
            return (Criteria) this;
        }

        public Criteria andNationnameBetween(String value1, String value2) {
            addCriterion("NationName between", value1, value2, "nationname");
            return (Criteria) this;
        }

        public Criteria andNationnameNotBetween(String value1, String value2) {
            addCriterion("NationName not between", value1, value2, "nationname");
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
