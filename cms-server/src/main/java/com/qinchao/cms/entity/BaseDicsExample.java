package com.qinchao.cms.entity;

import java.util.ArrayList;
import java.util.List;

public class BaseDicsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseDicsExample() {
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

        public Criteria andDicidIsNull() {
            addCriterion("DicID is null");
            return (Criteria) this;
        }

        public Criteria andDicidIsNotNull() {
            addCriterion("DicID is not null");
            return (Criteria) this;
        }

        public Criteria andDicidEqualTo(Integer value) {
            addCriterion("DicID =", value, "dicid");
            return (Criteria) this;
        }

        public Criteria andDicidNotEqualTo(Integer value) {
            addCriterion("DicID <>", value, "dicid");
            return (Criteria) this;
        }

        public Criteria andDicidGreaterThan(Integer value) {
            addCriterion("DicID >", value, "dicid");
            return (Criteria) this;
        }

        public Criteria andDicidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DicID >=", value, "dicid");
            return (Criteria) this;
        }

        public Criteria andDicidLessThan(Integer value) {
            addCriterion("DicID <", value, "dicid");
            return (Criteria) this;
        }

        public Criteria andDicidLessThanOrEqualTo(Integer value) {
            addCriterion("DicID <=", value, "dicid");
            return (Criteria) this;
        }

        public Criteria andDicidIn(List<Integer> values) {
            addCriterion("DicID in", values, "dicid");
            return (Criteria) this;
        }

        public Criteria andDicidNotIn(List<Integer> values) {
            addCriterion("DicID not in", values, "dicid");
            return (Criteria) this;
        }

        public Criteria andDicidBetween(Integer value1, Integer value2) {
            addCriterion("DicID between", value1, value2, "dicid");
            return (Criteria) this;
        }

        public Criteria andDicidNotBetween(Integer value1, Integer value2) {
            addCriterion("DicID not between", value1, value2, "dicid");
            return (Criteria) this;
        }

        public Criteria andDictypeIsNull() {
            addCriterion("DicType is null");
            return (Criteria) this;
        }

        public Criteria andDictypeIsNotNull() {
            addCriterion("DicType is not null");
            return (Criteria) this;
        }

        public Criteria andDictypeEqualTo(String value) {
            addCriterion("DicType =", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeNotEqualTo(String value) {
            addCriterion("DicType <>", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeGreaterThan(String value) {
            addCriterion("DicType >", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeGreaterThanOrEqualTo(String value) {
            addCriterion("DicType >=", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeLessThan(String value) {
            addCriterion("DicType <", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeLessThanOrEqualTo(String value) {
            addCriterion("DicType <=", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeLike(String value) {
            addCriterion("DicType like", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeNotLike(String value) {
            addCriterion("DicType not like", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeIn(List<String> values) {
            addCriterion("DicType in", values, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeNotIn(List<String> values) {
            addCriterion("DicType not in", values, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeBetween(String value1, String value2) {
            addCriterion("DicType between", value1, value2, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeNotBetween(String value1, String value2) {
            addCriterion("DicType not between", value1, value2, "dictype");
            return (Criteria) this;
        }

        public Criteria andDicnameIsNull() {
            addCriterion("DicName is null");
            return (Criteria) this;
        }

        public Criteria andDicnameIsNotNull() {
            addCriterion("DicName is not null");
            return (Criteria) this;
        }

        public Criteria andDicnameEqualTo(String value) {
            addCriterion("DicName =", value, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameNotEqualTo(String value) {
            addCriterion("DicName <>", value, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameGreaterThan(String value) {
            addCriterion("DicName >", value, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameGreaterThanOrEqualTo(String value) {
            addCriterion("DicName >=", value, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameLessThan(String value) {
            addCriterion("DicName <", value, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameLessThanOrEqualTo(String value) {
            addCriterion("DicName <=", value, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameLike(String value) {
            addCriterion("DicName like", value, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameNotLike(String value) {
            addCriterion("DicName not like", value, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameIn(List<String> values) {
            addCriterion("DicName in", values, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameNotIn(List<String> values) {
            addCriterion("DicName not in", values, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameBetween(String value1, String value2) {
            addCriterion("DicName between", value1, value2, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicnameNotBetween(String value1, String value2) {
            addCriterion("DicName not between", value1, value2, "dicname");
            return (Criteria) this;
        }

        public Criteria andDicvalueIsNull() {
            addCriterion("DicValue is null");
            return (Criteria) this;
        }

        public Criteria andDicvalueIsNotNull() {
            addCriterion("DicValue is not null");
            return (Criteria) this;
        }

        public Criteria andDicvalueEqualTo(String value) {
            addCriterion("DicValue =", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueNotEqualTo(String value) {
            addCriterion("DicValue <>", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueGreaterThan(String value) {
            addCriterion("DicValue >", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueGreaterThanOrEqualTo(String value) {
            addCriterion("DicValue >=", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueLessThan(String value) {
            addCriterion("DicValue <", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueLessThanOrEqualTo(String value) {
            addCriterion("DicValue <=", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueLike(String value) {
            addCriterion("DicValue like", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueNotLike(String value) {
            addCriterion("DicValue not like", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueIn(List<String> values) {
            addCriterion("DicValue in", values, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueNotIn(List<String> values) {
            addCriterion("DicValue not in", values, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueBetween(String value1, String value2) {
            addCriterion("DicValue between", value1, value2, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueNotBetween(String value1, String value2) {
            addCriterion("DicValue not between", value1, value2, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDictypenameIsNull() {
            addCriterion("DicTypeName is null");
            return (Criteria) this;
        }

        public Criteria andDictypenameIsNotNull() {
            addCriterion("DicTypeName is not null");
            return (Criteria) this;
        }

        public Criteria andDictypenameEqualTo(String value) {
            addCriterion("DicTypeName =", value, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameNotEqualTo(String value) {
            addCriterion("DicTypeName <>", value, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameGreaterThan(String value) {
            addCriterion("DicTypeName >", value, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameGreaterThanOrEqualTo(String value) {
            addCriterion("DicTypeName >=", value, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameLessThan(String value) {
            addCriterion("DicTypeName <", value, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameLessThanOrEqualTo(String value) {
            addCriterion("DicTypeName <=", value, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameLike(String value) {
            addCriterion("DicTypeName like", value, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameNotLike(String value) {
            addCriterion("DicTypeName not like", value, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameIn(List<String> values) {
            addCriterion("DicTypeName in", values, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameNotIn(List<String> values) {
            addCriterion("DicTypeName not in", values, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameBetween(String value1, String value2) {
            addCriterion("DicTypeName between", value1, value2, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameNotBetween(String value1, String value2) {
            addCriterion("DicTypeName not between", value1, value2, "dictypename");
            return (Criteria) this;
        }

        public Criteria andIsdictypeIsNull() {
            addCriterion("IsDicType is null");
            return (Criteria) this;
        }

        public Criteria andIsdictypeIsNotNull() {
            addCriterion("IsDicType is not null");
            return (Criteria) this;
        }

        public Criteria andIsdictypeEqualTo(Integer value) {
            addCriterion("IsDicType =", value, "isdictype");
            return (Criteria) this;
        }

        public Criteria andIsdictypeNotEqualTo(Integer value) {
            addCriterion("IsDicType <>", value, "isdictype");
            return (Criteria) this;
        }

        public Criteria andIsdictypeGreaterThan(Integer value) {
            addCriterion("IsDicType >", value, "isdictype");
            return (Criteria) this;
        }

        public Criteria andIsdictypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsDicType >=", value, "isdictype");
            return (Criteria) this;
        }

        public Criteria andIsdictypeLessThan(Integer value) {
            addCriterion("IsDicType <", value, "isdictype");
            return (Criteria) this;
        }

        public Criteria andIsdictypeLessThanOrEqualTo(Integer value) {
            addCriterion("IsDicType <=", value, "isdictype");
            return (Criteria) this;
        }

        public Criteria andIsdictypeIn(List<Integer> values) {
            addCriterion("IsDicType in", values, "isdictype");
            return (Criteria) this;
        }

        public Criteria andIsdictypeNotIn(List<Integer> values) {
            addCriterion("IsDicType not in", values, "isdictype");
            return (Criteria) this;
        }

        public Criteria andIsdictypeBetween(Integer value1, Integer value2) {
            addCriterion("IsDicType between", value1, value2, "isdictype");
            return (Criteria) this;
        }

        public Criteria andIsdictypeNotBetween(Integer value1, Integer value2) {
            addCriterion("IsDicType not between", value1, value2, "isdictype");
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
