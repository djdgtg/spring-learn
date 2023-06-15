package com.qinchao.cms.entity;

import java.util.ArrayList;
import java.util.List;

public class DbLibrarynexusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DbLibrarynexusExample() {
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

        public Criteria andNexusidIsNull() {
            addCriterion("nexusid is null");
            return (Criteria) this;
        }

        public Criteria andNexusidIsNotNull() {
            addCriterion("nexusid is not null");
            return (Criteria) this;
        }

        public Criteria andNexusidEqualTo(Integer value) {
            addCriterion("nexusid =", value, "nexusid");
            return (Criteria) this;
        }

        public Criteria andNexusidNotEqualTo(Integer value) {
            addCriterion("nexusid <>", value, "nexusid");
            return (Criteria) this;
        }

        public Criteria andNexusidGreaterThan(Integer value) {
            addCriterion("nexusid >", value, "nexusid");
            return (Criteria) this;
        }

        public Criteria andNexusidGreaterThanOrEqualTo(Integer value) {
            addCriterion("nexusid >=", value, "nexusid");
            return (Criteria) this;
        }

        public Criteria andNexusidLessThan(Integer value) {
            addCriterion("nexusid <", value, "nexusid");
            return (Criteria) this;
        }

        public Criteria andNexusidLessThanOrEqualTo(Integer value) {
            addCriterion("nexusid <=", value, "nexusid");
            return (Criteria) this;
        }

        public Criteria andNexusidIn(List<Integer> values) {
            addCriterion("nexusid in", values, "nexusid");
            return (Criteria) this;
        }

        public Criteria andNexusidNotIn(List<Integer> values) {
            addCriterion("nexusid not in", values, "nexusid");
            return (Criteria) this;
        }

        public Criteria andNexusidBetween(Integer value1, Integer value2) {
            addCriterion("nexusid between", value1, value2, "nexusid");
            return (Criteria) this;
        }

        public Criteria andNexusidNotBetween(Integer value1, Integer value2) {
            addCriterion("nexusid not between", value1, value2, "nexusid");
            return (Criteria) this;
        }

        public Criteria andMdbnameIsNull() {
            addCriterion("mdbname is null");
            return (Criteria) this;
        }

        public Criteria andMdbnameIsNotNull() {
            addCriterion("mdbname is not null");
            return (Criteria) this;
        }

        public Criteria andMdbnameEqualTo(String value) {
            addCriterion("mdbname =", value, "mdbname");
            return (Criteria) this;
        }

        public Criteria andMdbnameNotEqualTo(String value) {
            addCriterion("mdbname <>", value, "mdbname");
            return (Criteria) this;
        }

        public Criteria andMdbnameGreaterThan(String value) {
            addCriterion("mdbname >", value, "mdbname");
            return (Criteria) this;
        }

        public Criteria andMdbnameGreaterThanOrEqualTo(String value) {
            addCriterion("mdbname >=", value, "mdbname");
            return (Criteria) this;
        }

        public Criteria andMdbnameLessThan(String value) {
            addCriterion("mdbname <", value, "mdbname");
            return (Criteria) this;
        }

        public Criteria andMdbnameLessThanOrEqualTo(String value) {
            addCriterion("mdbname <=", value, "mdbname");
            return (Criteria) this;
        }

        public Criteria andMdbnameLike(String value) {
            addCriterion("mdbname like", value, "mdbname");
            return (Criteria) this;
        }

        public Criteria andMdbnameNotLike(String value) {
            addCriterion("mdbname not like", value, "mdbname");
            return (Criteria) this;
        }

        public Criteria andMdbnameIn(List<String> values) {
            addCriterion("mdbname in", values, "mdbname");
            return (Criteria) this;
        }

        public Criteria andMdbnameNotIn(List<String> values) {
            addCriterion("mdbname not in", values, "mdbname");
            return (Criteria) this;
        }

        public Criteria andMdbnameBetween(String value1, String value2) {
            addCriterion("mdbname between", value1, value2, "mdbname");
            return (Criteria) this;
        }

        public Criteria andMdbnameNotBetween(String value1, String value2) {
            addCriterion("mdbname not between", value1, value2, "mdbname");
            return (Criteria) this;
        }

        public Criteria andMdbfieldIsNull() {
            addCriterion("mdbfield is null");
            return (Criteria) this;
        }

        public Criteria andMdbfieldIsNotNull() {
            addCriterion("mdbfield is not null");
            return (Criteria) this;
        }

        public Criteria andMdbfieldEqualTo(String value) {
            addCriterion("mdbfield =", value, "mdbfield");
            return (Criteria) this;
        }

        public Criteria andMdbfieldNotEqualTo(String value) {
            addCriterion("mdbfield <>", value, "mdbfield");
            return (Criteria) this;
        }

        public Criteria andMdbfieldGreaterThan(String value) {
            addCriterion("mdbfield >", value, "mdbfield");
            return (Criteria) this;
        }

        public Criteria andMdbfieldGreaterThanOrEqualTo(String value) {
            addCriterion("mdbfield >=", value, "mdbfield");
            return (Criteria) this;
        }

        public Criteria andMdbfieldLessThan(String value) {
            addCriterion("mdbfield <", value, "mdbfield");
            return (Criteria) this;
        }

        public Criteria andMdbfieldLessThanOrEqualTo(String value) {
            addCriterion("mdbfield <=", value, "mdbfield");
            return (Criteria) this;
        }

        public Criteria andMdbfieldLike(String value) {
            addCriterion("mdbfield like", value, "mdbfield");
            return (Criteria) this;
        }

        public Criteria andMdbfieldNotLike(String value) {
            addCriterion("mdbfield not like", value, "mdbfield");
            return (Criteria) this;
        }

        public Criteria andMdbfieldIn(List<String> values) {
            addCriterion("mdbfield in", values, "mdbfield");
            return (Criteria) this;
        }

        public Criteria andMdbfieldNotIn(List<String> values) {
            addCriterion("mdbfield not in", values, "mdbfield");
            return (Criteria) this;
        }

        public Criteria andMdbfieldBetween(String value1, String value2) {
            addCriterion("mdbfield between", value1, value2, "mdbfield");
            return (Criteria) this;
        }

        public Criteria andMdbfieldNotBetween(String value1, String value2) {
            addCriterion("mdbfield not between", value1, value2, "mdbfield");
            return (Criteria) this;
        }

        public Criteria andSdbnameIsNull() {
            addCriterion("sdbname is null");
            return (Criteria) this;
        }

        public Criteria andSdbnameIsNotNull() {
            addCriterion("sdbname is not null");
            return (Criteria) this;
        }

        public Criteria andSdbnameEqualTo(String value) {
            addCriterion("sdbname =", value, "sdbname");
            return (Criteria) this;
        }

        public Criteria andSdbnameNotEqualTo(String value) {
            addCriterion("sdbname <>", value, "sdbname");
            return (Criteria) this;
        }

        public Criteria andSdbnameGreaterThan(String value) {
            addCriterion("sdbname >", value, "sdbname");
            return (Criteria) this;
        }

        public Criteria andSdbnameGreaterThanOrEqualTo(String value) {
            addCriterion("sdbname >=", value, "sdbname");
            return (Criteria) this;
        }

        public Criteria andSdbnameLessThan(String value) {
            addCriterion("sdbname <", value, "sdbname");
            return (Criteria) this;
        }

        public Criteria andSdbnameLessThanOrEqualTo(String value) {
            addCriterion("sdbname <=", value, "sdbname");
            return (Criteria) this;
        }

        public Criteria andSdbnameLike(String value) {
            addCriterion("sdbname like", value, "sdbname");
            return (Criteria) this;
        }

        public Criteria andSdbnameNotLike(String value) {
            addCriterion("sdbname not like", value, "sdbname");
            return (Criteria) this;
        }

        public Criteria andSdbnameIn(List<String> values) {
            addCriterion("sdbname in", values, "sdbname");
            return (Criteria) this;
        }

        public Criteria andSdbnameNotIn(List<String> values) {
            addCriterion("sdbname not in", values, "sdbname");
            return (Criteria) this;
        }

        public Criteria andSdbnameBetween(String value1, String value2) {
            addCriterion("sdbname between", value1, value2, "sdbname");
            return (Criteria) this;
        }

        public Criteria andSdbnameNotBetween(String value1, String value2) {
            addCriterion("sdbname not between", value1, value2, "sdbname");
            return (Criteria) this;
        }

        public Criteria andSdbnamefieldIsNull() {
            addCriterion("sdbnamefield is null");
            return (Criteria) this;
        }

        public Criteria andSdbnamefieldIsNotNull() {
            addCriterion("sdbnamefield is not null");
            return (Criteria) this;
        }

        public Criteria andSdbnamefieldEqualTo(String value) {
            addCriterion("sdbnamefield =", value, "sdbnamefield");
            return (Criteria) this;
        }

        public Criteria andSdbnamefieldNotEqualTo(String value) {
            addCriterion("sdbnamefield <>", value, "sdbnamefield");
            return (Criteria) this;
        }

        public Criteria andSdbnamefieldGreaterThan(String value) {
            addCriterion("sdbnamefield >", value, "sdbnamefield");
            return (Criteria) this;
        }

        public Criteria andSdbnamefieldGreaterThanOrEqualTo(String value) {
            addCriterion("sdbnamefield >=", value, "sdbnamefield");
            return (Criteria) this;
        }

        public Criteria andSdbnamefieldLessThan(String value) {
            addCriterion("sdbnamefield <", value, "sdbnamefield");
            return (Criteria) this;
        }

        public Criteria andSdbnamefieldLessThanOrEqualTo(String value) {
            addCriterion("sdbnamefield <=", value, "sdbnamefield");
            return (Criteria) this;
        }

        public Criteria andSdbnamefieldLike(String value) {
            addCriterion("sdbnamefield like", value, "sdbnamefield");
            return (Criteria) this;
        }

        public Criteria andSdbnamefieldNotLike(String value) {
            addCriterion("sdbnamefield not like", value, "sdbnamefield");
            return (Criteria) this;
        }

        public Criteria andSdbnamefieldIn(List<String> values) {
            addCriterion("sdbnamefield in", values, "sdbnamefield");
            return (Criteria) this;
        }

        public Criteria andSdbnamefieldNotIn(List<String> values) {
            addCriterion("sdbnamefield not in", values, "sdbnamefield");
            return (Criteria) this;
        }

        public Criteria andSdbnamefieldBetween(String value1, String value2) {
            addCriterion("sdbnamefield between", value1, value2, "sdbnamefield");
            return (Criteria) this;
        }

        public Criteria andSdbnamefieldNotBetween(String value1, String value2) {
            addCriterion("sdbnamefield not between", value1, value2, "sdbnamefield");
            return (Criteria) this;
        }

        public Criteria andSdbvaluefieldIsNull() {
            addCriterion("sdbvaluefield is null");
            return (Criteria) this;
        }

        public Criteria andSdbvaluefieldIsNotNull() {
            addCriterion("sdbvaluefield is not null");
            return (Criteria) this;
        }

        public Criteria andSdbvaluefieldEqualTo(String value) {
            addCriterion("sdbvaluefield =", value, "sdbvaluefield");
            return (Criteria) this;
        }

        public Criteria andSdbvaluefieldNotEqualTo(String value) {
            addCriterion("sdbvaluefield <>", value, "sdbvaluefield");
            return (Criteria) this;
        }

        public Criteria andSdbvaluefieldGreaterThan(String value) {
            addCriterion("sdbvaluefield >", value, "sdbvaluefield");
            return (Criteria) this;
        }

        public Criteria andSdbvaluefieldGreaterThanOrEqualTo(String value) {
            addCriterion("sdbvaluefield >=", value, "sdbvaluefield");
            return (Criteria) this;
        }

        public Criteria andSdbvaluefieldLessThan(String value) {
            addCriterion("sdbvaluefield <", value, "sdbvaluefield");
            return (Criteria) this;
        }

        public Criteria andSdbvaluefieldLessThanOrEqualTo(String value) {
            addCriterion("sdbvaluefield <=", value, "sdbvaluefield");
            return (Criteria) this;
        }

        public Criteria andSdbvaluefieldLike(String value) {
            addCriterion("sdbvaluefield like", value, "sdbvaluefield");
            return (Criteria) this;
        }

        public Criteria andSdbvaluefieldNotLike(String value) {
            addCriterion("sdbvaluefield not like", value, "sdbvaluefield");
            return (Criteria) this;
        }

        public Criteria andSdbvaluefieldIn(List<String> values) {
            addCriterion("sdbvaluefield in", values, "sdbvaluefield");
            return (Criteria) this;
        }

        public Criteria andSdbvaluefieldNotIn(List<String> values) {
            addCriterion("sdbvaluefield not in", values, "sdbvaluefield");
            return (Criteria) this;
        }

        public Criteria andSdbvaluefieldBetween(String value1, String value2) {
            addCriterion("sdbvaluefield between", value1, value2, "sdbvaluefield");
            return (Criteria) this;
        }

        public Criteria andSdbvaluefieldNotBetween(String value1, String value2) {
            addCriterion("sdbvaluefield not between", value1, value2, "sdbvaluefield");
            return (Criteria) this;
        }

        public Criteria andSdbsqlIsNull() {
            addCriterion("sdbsql is null");
            return (Criteria) this;
        }

        public Criteria andSdbsqlIsNotNull() {
            addCriterion("sdbsql is not null");
            return (Criteria) this;
        }

        public Criteria andSdbsqlEqualTo(String value) {
            addCriterion("sdbsql =", value, "sdbsql");
            return (Criteria) this;
        }

        public Criteria andSdbsqlNotEqualTo(String value) {
            addCriterion("sdbsql <>", value, "sdbsql");
            return (Criteria) this;
        }

        public Criteria andSdbsqlGreaterThan(String value) {
            addCriterion("sdbsql >", value, "sdbsql");
            return (Criteria) this;
        }

        public Criteria andSdbsqlGreaterThanOrEqualTo(String value) {
            addCriterion("sdbsql >=", value, "sdbsql");
            return (Criteria) this;
        }

        public Criteria andSdbsqlLessThan(String value) {
            addCriterion("sdbsql <", value, "sdbsql");
            return (Criteria) this;
        }

        public Criteria andSdbsqlLessThanOrEqualTo(String value) {
            addCriterion("sdbsql <=", value, "sdbsql");
            return (Criteria) this;
        }

        public Criteria andSdbsqlLike(String value) {
            addCriterion("sdbsql like", value, "sdbsql");
            return (Criteria) this;
        }

        public Criteria andSdbsqlNotLike(String value) {
            addCriterion("sdbsql not like", value, "sdbsql");
            return (Criteria) this;
        }

        public Criteria andSdbsqlIn(List<String> values) {
            addCriterion("sdbsql in", values, "sdbsql");
            return (Criteria) this;
        }

        public Criteria andSdbsqlNotIn(List<String> values) {
            addCriterion("sdbsql not in", values, "sdbsql");
            return (Criteria) this;
        }

        public Criteria andSdbsqlBetween(String value1, String value2) {
            addCriterion("sdbsql between", value1, value2, "sdbsql");
            return (Criteria) this;
        }

        public Criteria andSdbsqlNotBetween(String value1, String value2) {
            addCriterion("sdbsql not between", value1, value2, "sdbsql");
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
