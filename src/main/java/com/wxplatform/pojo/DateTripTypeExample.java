package com.wxplatform.pojo;

import java.util.ArrayList;
import java.util.List;

public class DateTripTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DateTripTypeExample() {
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

        public Criteria andDatetriptypeidIsNull() {
            addCriterion("datetriptypeid is null");
            return (Criteria) this;
        }

        public Criteria andDatetriptypeidIsNotNull() {
            addCriterion("datetriptypeid is not null");
            return (Criteria) this;
        }

        public Criteria andDatetriptypeidEqualTo(Integer value) {
            addCriterion("datetriptypeid =", value, "datetriptypeid");
            return (Criteria) this;
        }

        public Criteria andDatetriptypeidNotEqualTo(Integer value) {
            addCriterion("datetriptypeid <>", value, "datetriptypeid");
            return (Criteria) this;
        }

        public Criteria andDatetriptypeidGreaterThan(Integer value) {
            addCriterion("datetriptypeid >", value, "datetriptypeid");
            return (Criteria) this;
        }

        public Criteria andDatetriptypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("datetriptypeid >=", value, "datetriptypeid");
            return (Criteria) this;
        }

        public Criteria andDatetriptypeidLessThan(Integer value) {
            addCriterion("datetriptypeid <", value, "datetriptypeid");
            return (Criteria) this;
        }

        public Criteria andDatetriptypeidLessThanOrEqualTo(Integer value) {
            addCriterion("datetriptypeid <=", value, "datetriptypeid");
            return (Criteria) this;
        }

        public Criteria andDatetriptypeidIn(List<Integer> values) {
            addCriterion("datetriptypeid in", values, "datetriptypeid");
            return (Criteria) this;
        }

        public Criteria andDatetriptypeidNotIn(List<Integer> values) {
            addCriterion("datetriptypeid not in", values, "datetriptypeid");
            return (Criteria) this;
        }

        public Criteria andDatetriptypeidBetween(Integer value1, Integer value2) {
            addCriterion("datetriptypeid between", value1, value2, "datetriptypeid");
            return (Criteria) this;
        }

        public Criteria andDatetriptypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("datetriptypeid not between", value1, value2, "datetriptypeid");
            return (Criteria) this;
        }

        public Criteria andDatetripnameIsNull() {
            addCriterion("datetripname is null");
            return (Criteria) this;
        }

        public Criteria andDatetripnameIsNotNull() {
            addCriterion("datetripname is not null");
            return (Criteria) this;
        }

        public Criteria andDatetripnameEqualTo(String value) {
            addCriterion("datetripname =", value, "datetripname");
            return (Criteria) this;
        }

        public Criteria andDatetripnameNotEqualTo(String value) {
            addCriterion("datetripname <>", value, "datetripname");
            return (Criteria) this;
        }

        public Criteria andDatetripnameGreaterThan(String value) {
            addCriterion("datetripname >", value, "datetripname");
            return (Criteria) this;
        }

        public Criteria andDatetripnameGreaterThanOrEqualTo(String value) {
            addCriterion("datetripname >=", value, "datetripname");
            return (Criteria) this;
        }

        public Criteria andDatetripnameLessThan(String value) {
            addCriterion("datetripname <", value, "datetripname");
            return (Criteria) this;
        }

        public Criteria andDatetripnameLessThanOrEqualTo(String value) {
            addCriterion("datetripname <=", value, "datetripname");
            return (Criteria) this;
        }

        public Criteria andDatetripnameLike(String value) {
            addCriterion("datetripname like", value, "datetripname");
            return (Criteria) this;
        }

        public Criteria andDatetripnameNotLike(String value) {
            addCriterion("datetripname not like", value, "datetripname");
            return (Criteria) this;
        }

        public Criteria andDatetripnameIn(List<String> values) {
            addCriterion("datetripname in", values, "datetripname");
            return (Criteria) this;
        }

        public Criteria andDatetripnameNotIn(List<String> values) {
            addCriterion("datetripname not in", values, "datetripname");
            return (Criteria) this;
        }

        public Criteria andDatetripnameBetween(String value1, String value2) {
            addCriterion("datetripname between", value1, value2, "datetripname");
            return (Criteria) this;
        }

        public Criteria andDatetripnameNotBetween(String value1, String value2) {
            addCriterion("datetripname not between", value1, value2, "datetripname");
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