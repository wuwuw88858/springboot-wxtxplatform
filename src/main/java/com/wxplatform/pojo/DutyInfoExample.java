package com.wxplatform.pojo;

import java.util.ArrayList;
import java.util.List;

public class DutyInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DutyInfoExample() {
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

        public Criteria andDutyidIsNull() {
            addCriterion("dutyid is null");
            return (Criteria) this;
        }

        public Criteria andDutyidIsNotNull() {
            addCriterion("dutyid is not null");
            return (Criteria) this;
        }

        public Criteria andDutyidEqualTo(String value) {
            addCriterion("dutyid =", value, "dutyid");
            return (Criteria) this;
        }

        public Criteria andDutyidNotEqualTo(String value) {
            addCriterion("dutyid <>", value, "dutyid");
            return (Criteria) this;
        }

        public Criteria andDutyidGreaterThan(String value) {
            addCriterion("dutyid >", value, "dutyid");
            return (Criteria) this;
        }

        public Criteria andDutyidGreaterThanOrEqualTo(String value) {
            addCriterion("dutyid >=", value, "dutyid");
            return (Criteria) this;
        }

        public Criteria andDutyidLessThan(String value) {
            addCriterion("dutyid <", value, "dutyid");
            return (Criteria) this;
        }

        public Criteria andDutyidLessThanOrEqualTo(String value) {
            addCriterion("dutyid <=", value, "dutyid");
            return (Criteria) this;
        }

        public Criteria andDutyidLike(String value) {
            addCriterion("dutyid like", value, "dutyid");
            return (Criteria) this;
        }

        public Criteria andDutyidNotLike(String value) {
            addCriterion("dutyid not like", value, "dutyid");
            return (Criteria) this;
        }

        public Criteria andDutyidIn(List<String> values) {
            addCriterion("dutyid in", values, "dutyid");
            return (Criteria) this;
        }

        public Criteria andDutyidNotIn(List<String> values) {
            addCriterion("dutyid not in", values, "dutyid");
            return (Criteria) this;
        }

        public Criteria andDutyidBetween(String value1, String value2) {
            addCriterion("dutyid between", value1, value2, "dutyid");
            return (Criteria) this;
        }

        public Criteria andDutyidNotBetween(String value1, String value2) {
            addCriterion("dutyid not between", value1, value2, "dutyid");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNull() {
            addCriterion("memberid is null");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNotNull() {
            addCriterion("memberid is not null");
            return (Criteria) this;
        }

        public Criteria andMemberidEqualTo(String value) {
            addCriterion("memberid =", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotEqualTo(String value) {
            addCriterion("memberid <>", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThan(String value) {
            addCriterion("memberid >", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThanOrEqualTo(String value) {
            addCriterion("memberid >=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThan(String value) {
            addCriterion("memberid <", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThanOrEqualTo(String value) {
            addCriterion("memberid <=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLike(String value) {
            addCriterion("memberid like", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotLike(String value) {
            addCriterion("memberid not like", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidIn(List<String> values) {
            addCriterion("memberid in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotIn(List<String> values) {
            addCriterion("memberid not in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidBetween(String value1, String value2) {
            addCriterion("memberid between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotBetween(String value1, String value2) {
            addCriterion("memberid not between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andDutyxqdayIsNull() {
            addCriterion("dutyxqday is null");
            return (Criteria) this;
        }

        public Criteria andDutyxqdayIsNotNull() {
            addCriterion("dutyxqday is not null");
            return (Criteria) this;
        }

        public Criteria andDutyxqdayEqualTo(String value) {
            addCriterion("dutyxqday =", value, "dutyxqday");
            return (Criteria) this;
        }

        public Criteria andDutyxqdayNotEqualTo(String value) {
            addCriterion("dutyxqday <>", value, "dutyxqday");
            return (Criteria) this;
        }

        public Criteria andDutyxqdayGreaterThan(String value) {
            addCriterion("dutyxqday >", value, "dutyxqday");
            return (Criteria) this;
        }

        public Criteria andDutyxqdayGreaterThanOrEqualTo(String value) {
            addCriterion("dutyxqday >=", value, "dutyxqday");
            return (Criteria) this;
        }

        public Criteria andDutyxqdayLessThan(String value) {
            addCriterion("dutyxqday <", value, "dutyxqday");
            return (Criteria) this;
        }

        public Criteria andDutyxqdayLessThanOrEqualTo(String value) {
            addCriterion("dutyxqday <=", value, "dutyxqday");
            return (Criteria) this;
        }

        public Criteria andDutyxqdayLike(String value) {
            addCriterion("dutyxqday like", value, "dutyxqday");
            return (Criteria) this;
        }

        public Criteria andDutyxqdayNotLike(String value) {
            addCriterion("dutyxqday not like", value, "dutyxqday");
            return (Criteria) this;
        }

        public Criteria andDutyxqdayIn(List<String> values) {
            addCriterion("dutyxqday in", values, "dutyxqday");
            return (Criteria) this;
        }

        public Criteria andDutyxqdayNotIn(List<String> values) {
            addCriterion("dutyxqday not in", values, "dutyxqday");
            return (Criteria) this;
        }

        public Criteria andDutyxqdayBetween(String value1, String value2) {
            addCriterion("dutyxqday between", value1, value2, "dutyxqday");
            return (Criteria) this;
        }

        public Criteria andDutyxqdayNotBetween(String value1, String value2) {
            addCriterion("dutyxqday not between", value1, value2, "dutyxqday");
            return (Criteria) this;
        }

        public Criteria andDutybegintimeIsNull() {
            addCriterion("dutybegintime is null");
            return (Criteria) this;
        }

        public Criteria andDutybegintimeIsNotNull() {
            addCriterion("dutybegintime is not null");
            return (Criteria) this;
        }

        public Criteria andDutybegintimeEqualTo(String value) {
            addCriterion("dutybegintime =", value, "dutybegintime");
            return (Criteria) this;
        }

        public Criteria andDutybegintimeNotEqualTo(String value) {
            addCriterion("dutybegintime <>", value, "dutybegintime");
            return (Criteria) this;
        }

        public Criteria andDutybegintimeGreaterThan(String value) {
            addCriterion("dutybegintime >", value, "dutybegintime");
            return (Criteria) this;
        }

        public Criteria andDutybegintimeGreaterThanOrEqualTo(String value) {
            addCriterion("dutybegintime >=", value, "dutybegintime");
            return (Criteria) this;
        }

        public Criteria andDutybegintimeLessThan(String value) {
            addCriterion("dutybegintime <", value, "dutybegintime");
            return (Criteria) this;
        }

        public Criteria andDutybegintimeLessThanOrEqualTo(String value) {
            addCriterion("dutybegintime <=", value, "dutybegintime");
            return (Criteria) this;
        }

        public Criteria andDutybegintimeLike(String value) {
            addCriterion("dutybegintime like", value, "dutybegintime");
            return (Criteria) this;
        }

        public Criteria andDutybegintimeNotLike(String value) {
            addCriterion("dutybegintime not like", value, "dutybegintime");
            return (Criteria) this;
        }

        public Criteria andDutybegintimeIn(List<String> values) {
            addCriterion("dutybegintime in", values, "dutybegintime");
            return (Criteria) this;
        }

        public Criteria andDutybegintimeNotIn(List<String> values) {
            addCriterion("dutybegintime not in", values, "dutybegintime");
            return (Criteria) this;
        }

        public Criteria andDutybegintimeBetween(String value1, String value2) {
            addCriterion("dutybegintime between", value1, value2, "dutybegintime");
            return (Criteria) this;
        }

        public Criteria andDutybegintimeNotBetween(String value1, String value2) {
            addCriterion("dutybegintime not between", value1, value2, "dutybegintime");
            return (Criteria) this;
        }

        public Criteria andDutyendtimeIsNull() {
            addCriterion("dutyendtime is null");
            return (Criteria) this;
        }

        public Criteria andDutyendtimeIsNotNull() {
            addCriterion("dutyendtime is not null");
            return (Criteria) this;
        }

        public Criteria andDutyendtimeEqualTo(String value) {
            addCriterion("dutyendtime =", value, "dutyendtime");
            return (Criteria) this;
        }

        public Criteria andDutyendtimeNotEqualTo(String value) {
            addCriterion("dutyendtime <>", value, "dutyendtime");
            return (Criteria) this;
        }

        public Criteria andDutyendtimeGreaterThan(String value) {
            addCriterion("dutyendtime >", value, "dutyendtime");
            return (Criteria) this;
        }

        public Criteria andDutyendtimeGreaterThanOrEqualTo(String value) {
            addCriterion("dutyendtime >=", value, "dutyendtime");
            return (Criteria) this;
        }

        public Criteria andDutyendtimeLessThan(String value) {
            addCriterion("dutyendtime <", value, "dutyendtime");
            return (Criteria) this;
        }

        public Criteria andDutyendtimeLessThanOrEqualTo(String value) {
            addCriterion("dutyendtime <=", value, "dutyendtime");
            return (Criteria) this;
        }

        public Criteria andDutyendtimeLike(String value) {
            addCriterion("dutyendtime like", value, "dutyendtime");
            return (Criteria) this;
        }

        public Criteria andDutyendtimeNotLike(String value) {
            addCriterion("dutyendtime not like", value, "dutyendtime");
            return (Criteria) this;
        }

        public Criteria andDutyendtimeIn(List<String> values) {
            addCriterion("dutyendtime in", values, "dutyendtime");
            return (Criteria) this;
        }

        public Criteria andDutyendtimeNotIn(List<String> values) {
            addCriterion("dutyendtime not in", values, "dutyendtime");
            return (Criteria) this;
        }

        public Criteria andDutyendtimeBetween(String value1, String value2) {
            addCriterion("dutyendtime between", value1, value2, "dutyendtime");
            return (Criteria) this;
        }

        public Criteria andDutyendtimeNotBetween(String value1, String value2) {
            addCriterion("dutyendtime not between", value1, value2, "dutyendtime");
            return (Criteria) this;
        }

        public Criteria andOther1IsNull() {
            addCriterion("other1 is null");
            return (Criteria) this;
        }

        public Criteria andOther1IsNotNull() {
            addCriterion("other1 is not null");
            return (Criteria) this;
        }

        public Criteria andOther1EqualTo(String value) {
            addCriterion("other1 =", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotEqualTo(String value) {
            addCriterion("other1 <>", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1GreaterThan(String value) {
            addCriterion("other1 >", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1GreaterThanOrEqualTo(String value) {
            addCriterion("other1 >=", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1LessThan(String value) {
            addCriterion("other1 <", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1LessThanOrEqualTo(String value) {
            addCriterion("other1 <=", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1Like(String value) {
            addCriterion("other1 like", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotLike(String value) {
            addCriterion("other1 not like", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1In(List<String> values) {
            addCriterion("other1 in", values, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotIn(List<String> values) {
            addCriterion("other1 not in", values, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1Between(String value1, String value2) {
            addCriterion("other1 between", value1, value2, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotBetween(String value1, String value2) {
            addCriterion("other1 not between", value1, value2, "other1");
            return (Criteria) this;
        }

        public Criteria andOther2IsNull() {
            addCriterion("other2 is null");
            return (Criteria) this;
        }

        public Criteria andOther2IsNotNull() {
            addCriterion("other2 is not null");
            return (Criteria) this;
        }

        public Criteria andOther2EqualTo(String value) {
            addCriterion("other2 =", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotEqualTo(String value) {
            addCriterion("other2 <>", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2GreaterThan(String value) {
            addCriterion("other2 >", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2GreaterThanOrEqualTo(String value) {
            addCriterion("other2 >=", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2LessThan(String value) {
            addCriterion("other2 <", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2LessThanOrEqualTo(String value) {
            addCriterion("other2 <=", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2Like(String value) {
            addCriterion("other2 like", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotLike(String value) {
            addCriterion("other2 not like", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2In(List<String> values) {
            addCriterion("other2 in", values, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotIn(List<String> values) {
            addCriterion("other2 not in", values, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2Between(String value1, String value2) {
            addCriterion("other2 between", value1, value2, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotBetween(String value1, String value2) {
            addCriterion("other2 not between", value1, value2, "other2");
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