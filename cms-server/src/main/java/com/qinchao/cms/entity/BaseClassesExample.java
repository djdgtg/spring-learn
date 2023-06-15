package com.qinchao.cms.entity;

import java.util.ArrayList;
import java.util.List;

public class BaseClassesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseClassesExample() {
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

        public Criteria andClassidIsNull() {
            addCriterion("ClassID is null");
            return (Criteria) this;
        }

        public Criteria andClassidIsNotNull() {
            addCriterion("ClassID is not null");
            return (Criteria) this;
        }

        public Criteria andClassidEqualTo(Integer value) {
            addCriterion("ClassID =", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotEqualTo(Integer value) {
            addCriterion("ClassID <>", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThan(Integer value) {
            addCriterion("ClassID >", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ClassID >=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThan(Integer value) {
            addCriterion("ClassID <", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThanOrEqualTo(Integer value) {
            addCriterion("ClassID <=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidIn(List<Integer> values) {
            addCriterion("ClassID in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotIn(List<Integer> values) {
            addCriterion("ClassID not in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidBetween(Integer value1, Integer value2) {
            addCriterion("ClassID between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotBetween(Integer value1, Integer value2) {
            addCriterion("ClassID not between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andParentclassidIsNull() {
            addCriterion("ParentClassID is null");
            return (Criteria) this;
        }

        public Criteria andParentclassidIsNotNull() {
            addCriterion("ParentClassID is not null");
            return (Criteria) this;
        }

        public Criteria andParentclassidEqualTo(Integer value) {
            addCriterion("ParentClassID =", value, "parentclassid");
            return (Criteria) this;
        }

        public Criteria andParentclassidNotEqualTo(Integer value) {
            addCriterion("ParentClassID <>", value, "parentclassid");
            return (Criteria) this;
        }

        public Criteria andParentclassidGreaterThan(Integer value) {
            addCriterion("ParentClassID >", value, "parentclassid");
            return (Criteria) this;
        }

        public Criteria andParentclassidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ParentClassID >=", value, "parentclassid");
            return (Criteria) this;
        }

        public Criteria andParentclassidLessThan(Integer value) {
            addCriterion("ParentClassID <", value, "parentclassid");
            return (Criteria) this;
        }

        public Criteria andParentclassidLessThanOrEqualTo(Integer value) {
            addCriterion("ParentClassID <=", value, "parentclassid");
            return (Criteria) this;
        }

        public Criteria andParentclassidIn(List<Integer> values) {
            addCriterion("ParentClassID in", values, "parentclassid");
            return (Criteria) this;
        }

        public Criteria andParentclassidNotIn(List<Integer> values) {
            addCriterion("ParentClassID not in", values, "parentclassid");
            return (Criteria) this;
        }

        public Criteria andParentclassidBetween(Integer value1, Integer value2) {
            addCriterion("ParentClassID between", value1, value2, "parentclassid");
            return (Criteria) this;
        }

        public Criteria andParentclassidNotBetween(Integer value1, Integer value2) {
            addCriterion("ParentClassID not between", value1, value2, "parentclassid");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNull() {
            addCriterion("ClassName is null");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNotNull() {
            addCriterion("ClassName is not null");
            return (Criteria) this;
        }

        public Criteria andClassnameEqualTo(String value) {
            addCriterion("ClassName =", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotEqualTo(String value) {
            addCriterion("ClassName <>", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThan(String value) {
            addCriterion("ClassName >", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThanOrEqualTo(String value) {
            addCriterion("ClassName >=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThan(String value) {
            addCriterion("ClassName <", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThanOrEqualTo(String value) {
            addCriterion("ClassName <=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLike(String value) {
            addCriterion("ClassName like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotLike(String value) {
            addCriterion("ClassName not like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameIn(List<String> values) {
            addCriterion("ClassName in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotIn(List<String> values) {
            addCriterion("ClassName not in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameBetween(String value1, String value2) {
            addCriterion("ClassName between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotBetween(String value1, String value2) {
            addCriterion("ClassName not between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andClassimgIsNull() {
            addCriterion("ClassImg is null");
            return (Criteria) this;
        }

        public Criteria andClassimgIsNotNull() {
            addCriterion("ClassImg is not null");
            return (Criteria) this;
        }

        public Criteria andClassimgEqualTo(String value) {
            addCriterion("ClassImg =", value, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgNotEqualTo(String value) {
            addCriterion("ClassImg <>", value, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgGreaterThan(String value) {
            addCriterion("ClassImg >", value, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgGreaterThanOrEqualTo(String value) {
            addCriterion("ClassImg >=", value, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgLessThan(String value) {
            addCriterion("ClassImg <", value, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgLessThanOrEqualTo(String value) {
            addCriterion("ClassImg <=", value, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgLike(String value) {
            addCriterion("ClassImg like", value, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgNotLike(String value) {
            addCriterion("ClassImg not like", value, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgIn(List<String> values) {
            addCriterion("ClassImg in", values, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgNotIn(List<String> values) {
            addCriterion("ClassImg not in", values, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgBetween(String value1, String value2) {
            addCriterion("ClassImg between", value1, value2, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassimgNotBetween(String value1, String value2) {
            addCriterion("ClassImg not between", value1, value2, "classimg");
            return (Criteria) this;
        }

        public Criteria andClassdescriptionIsNull() {
            addCriterion("ClassDescription is null");
            return (Criteria) this;
        }

        public Criteria andClassdescriptionIsNotNull() {
            addCriterion("ClassDescription is not null");
            return (Criteria) this;
        }

        public Criteria andClassdescriptionEqualTo(String value) {
            addCriterion("ClassDescription =", value, "classdescription");
            return (Criteria) this;
        }

        public Criteria andClassdescriptionNotEqualTo(String value) {
            addCriterion("ClassDescription <>", value, "classdescription");
            return (Criteria) this;
        }

        public Criteria andClassdescriptionGreaterThan(String value) {
            addCriterion("ClassDescription >", value, "classdescription");
            return (Criteria) this;
        }

        public Criteria andClassdescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("ClassDescription >=", value, "classdescription");
            return (Criteria) this;
        }

        public Criteria andClassdescriptionLessThan(String value) {
            addCriterion("ClassDescription <", value, "classdescription");
            return (Criteria) this;
        }

        public Criteria andClassdescriptionLessThanOrEqualTo(String value) {
            addCriterion("ClassDescription <=", value, "classdescription");
            return (Criteria) this;
        }

        public Criteria andClassdescriptionLike(String value) {
            addCriterion("ClassDescription like", value, "classdescription");
            return (Criteria) this;
        }

        public Criteria andClassdescriptionNotLike(String value) {
            addCriterion("ClassDescription not like", value, "classdescription");
            return (Criteria) this;
        }

        public Criteria andClassdescriptionIn(List<String> values) {
            addCriterion("ClassDescription in", values, "classdescription");
            return (Criteria) this;
        }

        public Criteria andClassdescriptionNotIn(List<String> values) {
            addCriterion("ClassDescription not in", values, "classdescription");
            return (Criteria) this;
        }

        public Criteria andClassdescriptionBetween(String value1, String value2) {
            addCriterion("ClassDescription between", value1, value2, "classdescription");
            return (Criteria) this;
        }

        public Criteria andClassdescriptionNotBetween(String value1, String value2) {
            addCriterion("ClassDescription not between", value1, value2, "classdescription");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("Sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("Sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("Sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("Sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("Sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("Sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("Sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("Sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("Sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("Sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("Sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("Sort not between", value1, value2, "sort");
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
