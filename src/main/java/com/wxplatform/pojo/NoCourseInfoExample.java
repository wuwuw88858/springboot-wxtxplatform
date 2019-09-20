package com.wxplatform.pojo;

import java.util.ArrayList;
import java.util.List;

public class NoCourseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoCourseInfoExample() {
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

        public Criteria andMembernameIsNull() {
            addCriterion("membername is null");
            return (Criteria) this;
        }

        public Criteria andMembernameIsNotNull() {
            addCriterion("membername is not null");
            return (Criteria) this;
        }

        public Criteria andMembernameEqualTo(String value) {
            addCriterion("membername =", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameNotEqualTo(String value) {
            addCriterion("membername <>", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameGreaterThan(String value) {
            addCriterion("membername >", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameGreaterThanOrEqualTo(String value) {
            addCriterion("membername >=", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameLessThan(String value) {
            addCriterion("membername <", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameLessThanOrEqualTo(String value) {
            addCriterion("membername <=", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameLike(String value) {
            addCriterion("membername like", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameNotLike(String value) {
            addCriterion("membername not like", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameIn(List<String> values) {
            addCriterion("membername in", values, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameNotIn(List<String> values) {
            addCriterion("membername not in", values, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameBetween(String value1, String value2) {
            addCriterion("membername between", value1, value2, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameNotBetween(String value1, String value2) {
            addCriterion("membername not between", value1, value2, "membername");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIsNull() {
            addCriterion("departmentid is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIsNotNull() {
            addCriterion("departmentid is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidEqualTo(Integer value) {
            addCriterion("departmentid =", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotEqualTo(Integer value) {
            addCriterion("departmentid <>", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThan(Integer value) {
            addCriterion("departmentid >", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("departmentid >=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThan(Integer value) {
            addCriterion("departmentid <", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThanOrEqualTo(Integer value) {
            addCriterion("departmentid <=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIn(List<Integer> values) {
            addCriterion("departmentid in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotIn(List<Integer> values) {
            addCriterion("departmentid not in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidBetween(Integer value1, Integer value2) {
            addCriterion("departmentid between", value1, value2, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotBetween(Integer value1, Integer value2) {
            addCriterion("departmentid not between", value1, value2, "departmentid");
            return (Criteria) this;
        }

        public Criteria andCourse1IsNull() {
            addCriterion("course1 is null");
            return (Criteria) this;
        }

        public Criteria andCourse1IsNotNull() {
            addCriterion("course1 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse1EqualTo(String value) {
            addCriterion("course1 =", value, "course1");
            return (Criteria) this;
        }

        public Criteria andCourse1NotEqualTo(String value) {
            addCriterion("course1 <>", value, "course1");
            return (Criteria) this;
        }

        public Criteria andCourse1GreaterThan(String value) {
            addCriterion("course1 >", value, "course1");
            return (Criteria) this;
        }

        public Criteria andCourse1GreaterThanOrEqualTo(String value) {
            addCriterion("course1 >=", value, "course1");
            return (Criteria) this;
        }

        public Criteria andCourse1LessThan(String value) {
            addCriterion("course1 <", value, "course1");
            return (Criteria) this;
        }

        public Criteria andCourse1LessThanOrEqualTo(String value) {
            addCriterion("course1 <=", value, "course1");
            return (Criteria) this;
        }

        public Criteria andCourse1Like(String value) {
            addCriterion("course1 like", value, "course1");
            return (Criteria) this;
        }

        public Criteria andCourse1NotLike(String value) {
            addCriterion("course1 not like", value, "course1");
            return (Criteria) this;
        }

        public Criteria andCourse1In(List<String> values) {
            addCriterion("course1 in", values, "course1");
            return (Criteria) this;
        }

        public Criteria andCourse1NotIn(List<String> values) {
            addCriterion("course1 not in", values, "course1");
            return (Criteria) this;
        }

        public Criteria andCourse1Between(String value1, String value2) {
            addCriterion("course1 between", value1, value2, "course1");
            return (Criteria) this;
        }

        public Criteria andCourse1NotBetween(String value1, String value2) {
            addCriterion("course1 not between", value1, value2, "course1");
            return (Criteria) this;
        }

        public Criteria andCourse2IsNull() {
            addCriterion("course2 is null");
            return (Criteria) this;
        }

        public Criteria andCourse2IsNotNull() {
            addCriterion("course2 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse2EqualTo(String value) {
            addCriterion("course2 =", value, "course2");
            return (Criteria) this;
        }

        public Criteria andCourse2NotEqualTo(String value) {
            addCriterion("course2 <>", value, "course2");
            return (Criteria) this;
        }

        public Criteria andCourse2GreaterThan(String value) {
            addCriterion("course2 >", value, "course2");
            return (Criteria) this;
        }

        public Criteria andCourse2GreaterThanOrEqualTo(String value) {
            addCriterion("course2 >=", value, "course2");
            return (Criteria) this;
        }

        public Criteria andCourse2LessThan(String value) {
            addCriterion("course2 <", value, "course2");
            return (Criteria) this;
        }

        public Criteria andCourse2LessThanOrEqualTo(String value) {
            addCriterion("course2 <=", value, "course2");
            return (Criteria) this;
        }

        public Criteria andCourse2Like(String value) {
            addCriterion("course2 like", value, "course2");
            return (Criteria) this;
        }

        public Criteria andCourse2NotLike(String value) {
            addCriterion("course2 not like", value, "course2");
            return (Criteria) this;
        }

        public Criteria andCourse2In(List<String> values) {
            addCriterion("course2 in", values, "course2");
            return (Criteria) this;
        }

        public Criteria andCourse2NotIn(List<String> values) {
            addCriterion("course2 not in", values, "course2");
            return (Criteria) this;
        }

        public Criteria andCourse2Between(String value1, String value2) {
            addCriterion("course2 between", value1, value2, "course2");
            return (Criteria) this;
        }

        public Criteria andCourse2NotBetween(String value1, String value2) {
            addCriterion("course2 not between", value1, value2, "course2");
            return (Criteria) this;
        }

        public Criteria andCourse3IsNull() {
            addCriterion("course3 is null");
            return (Criteria) this;
        }

        public Criteria andCourse3IsNotNull() {
            addCriterion("course3 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse3EqualTo(String value) {
            addCriterion("course3 =", value, "course3");
            return (Criteria) this;
        }

        public Criteria andCourse3NotEqualTo(String value) {
            addCriterion("course3 <>", value, "course3");
            return (Criteria) this;
        }

        public Criteria andCourse3GreaterThan(String value) {
            addCriterion("course3 >", value, "course3");
            return (Criteria) this;
        }

        public Criteria andCourse3GreaterThanOrEqualTo(String value) {
            addCriterion("course3 >=", value, "course3");
            return (Criteria) this;
        }

        public Criteria andCourse3LessThan(String value) {
            addCriterion("course3 <", value, "course3");
            return (Criteria) this;
        }

        public Criteria andCourse3LessThanOrEqualTo(String value) {
            addCriterion("course3 <=", value, "course3");
            return (Criteria) this;
        }

        public Criteria andCourse3Like(String value) {
            addCriterion("course3 like", value, "course3");
            return (Criteria) this;
        }

        public Criteria andCourse3NotLike(String value) {
            addCriterion("course3 not like", value, "course3");
            return (Criteria) this;
        }

        public Criteria andCourse3In(List<String> values) {
            addCriterion("course3 in", values, "course3");
            return (Criteria) this;
        }

        public Criteria andCourse3NotIn(List<String> values) {
            addCriterion("course3 not in", values, "course3");
            return (Criteria) this;
        }

        public Criteria andCourse3Between(String value1, String value2) {
            addCriterion("course3 between", value1, value2, "course3");
            return (Criteria) this;
        }

        public Criteria andCourse3NotBetween(String value1, String value2) {
            addCriterion("course3 not between", value1, value2, "course3");
            return (Criteria) this;
        }

        public Criteria andCourse4IsNull() {
            addCriterion("course4 is null");
            return (Criteria) this;
        }

        public Criteria andCourse4IsNotNull() {
            addCriterion("course4 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse4EqualTo(String value) {
            addCriterion("course4 =", value, "course4");
            return (Criteria) this;
        }

        public Criteria andCourse4NotEqualTo(String value) {
            addCriterion("course4 <>", value, "course4");
            return (Criteria) this;
        }

        public Criteria andCourse4GreaterThan(String value) {
            addCriterion("course4 >", value, "course4");
            return (Criteria) this;
        }

        public Criteria andCourse4GreaterThanOrEqualTo(String value) {
            addCriterion("course4 >=", value, "course4");
            return (Criteria) this;
        }

        public Criteria andCourse4LessThan(String value) {
            addCriterion("course4 <", value, "course4");
            return (Criteria) this;
        }

        public Criteria andCourse4LessThanOrEqualTo(String value) {
            addCriterion("course4 <=", value, "course4");
            return (Criteria) this;
        }

        public Criteria andCourse4Like(String value) {
            addCriterion("course4 like", value, "course4");
            return (Criteria) this;
        }

        public Criteria andCourse4NotLike(String value) {
            addCriterion("course4 not like", value, "course4");
            return (Criteria) this;
        }

        public Criteria andCourse4In(List<String> values) {
            addCriterion("course4 in", values, "course4");
            return (Criteria) this;
        }

        public Criteria andCourse4NotIn(List<String> values) {
            addCriterion("course4 not in", values, "course4");
            return (Criteria) this;
        }

        public Criteria andCourse4Between(String value1, String value2) {
            addCriterion("course4 between", value1, value2, "course4");
            return (Criteria) this;
        }

        public Criteria andCourse4NotBetween(String value1, String value2) {
            addCriterion("course4 not between", value1, value2, "course4");
            return (Criteria) this;
        }

        public Criteria andCourse5IsNull() {
            addCriterion("course5 is null");
            return (Criteria) this;
        }

        public Criteria andCourse5IsNotNull() {
            addCriterion("course5 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse5EqualTo(String value) {
            addCriterion("course5 =", value, "course5");
            return (Criteria) this;
        }

        public Criteria andCourse5NotEqualTo(String value) {
            addCriterion("course5 <>", value, "course5");
            return (Criteria) this;
        }

        public Criteria andCourse5GreaterThan(String value) {
            addCriterion("course5 >", value, "course5");
            return (Criteria) this;
        }

        public Criteria andCourse5GreaterThanOrEqualTo(String value) {
            addCriterion("course5 >=", value, "course5");
            return (Criteria) this;
        }

        public Criteria andCourse5LessThan(String value) {
            addCriterion("course5 <", value, "course5");
            return (Criteria) this;
        }

        public Criteria andCourse5LessThanOrEqualTo(String value) {
            addCriterion("course5 <=", value, "course5");
            return (Criteria) this;
        }

        public Criteria andCourse5Like(String value) {
            addCriterion("course5 like", value, "course5");
            return (Criteria) this;
        }

        public Criteria andCourse5NotLike(String value) {
            addCriterion("course5 not like", value, "course5");
            return (Criteria) this;
        }

        public Criteria andCourse5In(List<String> values) {
            addCriterion("course5 in", values, "course5");
            return (Criteria) this;
        }

        public Criteria andCourse5NotIn(List<String> values) {
            addCriterion("course5 not in", values, "course5");
            return (Criteria) this;
        }

        public Criteria andCourse5Between(String value1, String value2) {
            addCriterion("course5 between", value1, value2, "course5");
            return (Criteria) this;
        }

        public Criteria andCourse5NotBetween(String value1, String value2) {
            addCriterion("course5 not between", value1, value2, "course5");
            return (Criteria) this;
        }

        public Criteria andCourse6IsNull() {
            addCriterion("course6 is null");
            return (Criteria) this;
        }

        public Criteria andCourse6IsNotNull() {
            addCriterion("course6 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse6EqualTo(String value) {
            addCriterion("course6 =", value, "course6");
            return (Criteria) this;
        }

        public Criteria andCourse6NotEqualTo(String value) {
            addCriterion("course6 <>", value, "course6");
            return (Criteria) this;
        }

        public Criteria andCourse6GreaterThan(String value) {
            addCriterion("course6 >", value, "course6");
            return (Criteria) this;
        }

        public Criteria andCourse6GreaterThanOrEqualTo(String value) {
            addCriterion("course6 >=", value, "course6");
            return (Criteria) this;
        }

        public Criteria andCourse6LessThan(String value) {
            addCriterion("course6 <", value, "course6");
            return (Criteria) this;
        }

        public Criteria andCourse6LessThanOrEqualTo(String value) {
            addCriterion("course6 <=", value, "course6");
            return (Criteria) this;
        }

        public Criteria andCourse6Like(String value) {
            addCriterion("course6 like", value, "course6");
            return (Criteria) this;
        }

        public Criteria andCourse6NotLike(String value) {
            addCriterion("course6 not like", value, "course6");
            return (Criteria) this;
        }

        public Criteria andCourse6In(List<String> values) {
            addCriterion("course6 in", values, "course6");
            return (Criteria) this;
        }

        public Criteria andCourse6NotIn(List<String> values) {
            addCriterion("course6 not in", values, "course6");
            return (Criteria) this;
        }

        public Criteria andCourse6Between(String value1, String value2) {
            addCriterion("course6 between", value1, value2, "course6");
            return (Criteria) this;
        }

        public Criteria andCourse6NotBetween(String value1, String value2) {
            addCriterion("course6 not between", value1, value2, "course6");
            return (Criteria) this;
        }

        public Criteria andCourse7IsNull() {
            addCriterion("course7 is null");
            return (Criteria) this;
        }

        public Criteria andCourse7IsNotNull() {
            addCriterion("course7 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse7EqualTo(String value) {
            addCriterion("course7 =", value, "course7");
            return (Criteria) this;
        }

        public Criteria andCourse7NotEqualTo(String value) {
            addCriterion("course7 <>", value, "course7");
            return (Criteria) this;
        }

        public Criteria andCourse7GreaterThan(String value) {
            addCriterion("course7 >", value, "course7");
            return (Criteria) this;
        }

        public Criteria andCourse7GreaterThanOrEqualTo(String value) {
            addCriterion("course7 >=", value, "course7");
            return (Criteria) this;
        }

        public Criteria andCourse7LessThan(String value) {
            addCriterion("course7 <", value, "course7");
            return (Criteria) this;
        }

        public Criteria andCourse7LessThanOrEqualTo(String value) {
            addCriterion("course7 <=", value, "course7");
            return (Criteria) this;
        }

        public Criteria andCourse7Like(String value) {
            addCriterion("course7 like", value, "course7");
            return (Criteria) this;
        }

        public Criteria andCourse7NotLike(String value) {
            addCriterion("course7 not like", value, "course7");
            return (Criteria) this;
        }

        public Criteria andCourse7In(List<String> values) {
            addCriterion("course7 in", values, "course7");
            return (Criteria) this;
        }

        public Criteria andCourse7NotIn(List<String> values) {
            addCriterion("course7 not in", values, "course7");
            return (Criteria) this;
        }

        public Criteria andCourse7Between(String value1, String value2) {
            addCriterion("course7 between", value1, value2, "course7");
            return (Criteria) this;
        }

        public Criteria andCourse7NotBetween(String value1, String value2) {
            addCriterion("course7 not between", value1, value2, "course7");
            return (Criteria) this;
        }

        public Criteria andCourse8IsNull() {
            addCriterion("course8 is null");
            return (Criteria) this;
        }

        public Criteria andCourse8IsNotNull() {
            addCriterion("course8 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse8EqualTo(String value) {
            addCriterion("course8 =", value, "course8");
            return (Criteria) this;
        }

        public Criteria andCourse8NotEqualTo(String value) {
            addCriterion("course8 <>", value, "course8");
            return (Criteria) this;
        }

        public Criteria andCourse8GreaterThan(String value) {
            addCriterion("course8 >", value, "course8");
            return (Criteria) this;
        }

        public Criteria andCourse8GreaterThanOrEqualTo(String value) {
            addCriterion("course8 >=", value, "course8");
            return (Criteria) this;
        }

        public Criteria andCourse8LessThan(String value) {
            addCriterion("course8 <", value, "course8");
            return (Criteria) this;
        }

        public Criteria andCourse8LessThanOrEqualTo(String value) {
            addCriterion("course8 <=", value, "course8");
            return (Criteria) this;
        }

        public Criteria andCourse8Like(String value) {
            addCriterion("course8 like", value, "course8");
            return (Criteria) this;
        }

        public Criteria andCourse8NotLike(String value) {
            addCriterion("course8 not like", value, "course8");
            return (Criteria) this;
        }

        public Criteria andCourse8In(List<String> values) {
            addCriterion("course8 in", values, "course8");
            return (Criteria) this;
        }

        public Criteria andCourse8NotIn(List<String> values) {
            addCriterion("course8 not in", values, "course8");
            return (Criteria) this;
        }

        public Criteria andCourse8Between(String value1, String value2) {
            addCriterion("course8 between", value1, value2, "course8");
            return (Criteria) this;
        }

        public Criteria andCourse8NotBetween(String value1, String value2) {
            addCriterion("course8 not between", value1, value2, "course8");
            return (Criteria) this;
        }

        public Criteria andCourse9IsNull() {
            addCriterion("course9 is null");
            return (Criteria) this;
        }

        public Criteria andCourse9IsNotNull() {
            addCriterion("course9 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse9EqualTo(String value) {
            addCriterion("course9 =", value, "course9");
            return (Criteria) this;
        }

        public Criteria andCourse9NotEqualTo(String value) {
            addCriterion("course9 <>", value, "course9");
            return (Criteria) this;
        }

        public Criteria andCourse9GreaterThan(String value) {
            addCriterion("course9 >", value, "course9");
            return (Criteria) this;
        }

        public Criteria andCourse9GreaterThanOrEqualTo(String value) {
            addCriterion("course9 >=", value, "course9");
            return (Criteria) this;
        }

        public Criteria andCourse9LessThan(String value) {
            addCriterion("course9 <", value, "course9");
            return (Criteria) this;
        }

        public Criteria andCourse9LessThanOrEqualTo(String value) {
            addCriterion("course9 <=", value, "course9");
            return (Criteria) this;
        }

        public Criteria andCourse9Like(String value) {
            addCriterion("course9 like", value, "course9");
            return (Criteria) this;
        }

        public Criteria andCourse9NotLike(String value) {
            addCriterion("course9 not like", value, "course9");
            return (Criteria) this;
        }

        public Criteria andCourse9In(List<String> values) {
            addCriterion("course9 in", values, "course9");
            return (Criteria) this;
        }

        public Criteria andCourse9NotIn(List<String> values) {
            addCriterion("course9 not in", values, "course9");
            return (Criteria) this;
        }

        public Criteria andCourse9Between(String value1, String value2) {
            addCriterion("course9 between", value1, value2, "course9");
            return (Criteria) this;
        }

        public Criteria andCourse9NotBetween(String value1, String value2) {
            addCriterion("course9 not between", value1, value2, "course9");
            return (Criteria) this;
        }

        public Criteria andCourse10IsNull() {
            addCriterion("course10 is null");
            return (Criteria) this;
        }

        public Criteria andCourse10IsNotNull() {
            addCriterion("course10 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse10EqualTo(String value) {
            addCriterion("course10 =", value, "course10");
            return (Criteria) this;
        }

        public Criteria andCourse10NotEqualTo(String value) {
            addCriterion("course10 <>", value, "course10");
            return (Criteria) this;
        }

        public Criteria andCourse10GreaterThan(String value) {
            addCriterion("course10 >", value, "course10");
            return (Criteria) this;
        }

        public Criteria andCourse10GreaterThanOrEqualTo(String value) {
            addCriterion("course10 >=", value, "course10");
            return (Criteria) this;
        }

        public Criteria andCourse10LessThan(String value) {
            addCriterion("course10 <", value, "course10");
            return (Criteria) this;
        }

        public Criteria andCourse10LessThanOrEqualTo(String value) {
            addCriterion("course10 <=", value, "course10");
            return (Criteria) this;
        }

        public Criteria andCourse10Like(String value) {
            addCriterion("course10 like", value, "course10");
            return (Criteria) this;
        }

        public Criteria andCourse10NotLike(String value) {
            addCriterion("course10 not like", value, "course10");
            return (Criteria) this;
        }

        public Criteria andCourse10In(List<String> values) {
            addCriterion("course10 in", values, "course10");
            return (Criteria) this;
        }

        public Criteria andCourse10NotIn(List<String> values) {
            addCriterion("course10 not in", values, "course10");
            return (Criteria) this;
        }

        public Criteria andCourse10Between(String value1, String value2) {
            addCriterion("course10 between", value1, value2, "course10");
            return (Criteria) this;
        }

        public Criteria andCourse10NotBetween(String value1, String value2) {
            addCriterion("course10 not between", value1, value2, "course10");
            return (Criteria) this;
        }

        public Criteria andCourse11IsNull() {
            addCriterion("course11 is null");
            return (Criteria) this;
        }

        public Criteria andCourse11IsNotNull() {
            addCriterion("course11 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse11EqualTo(String value) {
            addCriterion("course11 =", value, "course11");
            return (Criteria) this;
        }

        public Criteria andCourse11NotEqualTo(String value) {
            addCriterion("course11 <>", value, "course11");
            return (Criteria) this;
        }

        public Criteria andCourse11GreaterThan(String value) {
            addCriterion("course11 >", value, "course11");
            return (Criteria) this;
        }

        public Criteria andCourse11GreaterThanOrEqualTo(String value) {
            addCriterion("course11 >=", value, "course11");
            return (Criteria) this;
        }

        public Criteria andCourse11LessThan(String value) {
            addCriterion("course11 <", value, "course11");
            return (Criteria) this;
        }

        public Criteria andCourse11LessThanOrEqualTo(String value) {
            addCriterion("course11 <=", value, "course11");
            return (Criteria) this;
        }

        public Criteria andCourse11Like(String value) {
            addCriterion("course11 like", value, "course11");
            return (Criteria) this;
        }

        public Criteria andCourse11NotLike(String value) {
            addCriterion("course11 not like", value, "course11");
            return (Criteria) this;
        }

        public Criteria andCourse11In(List<String> values) {
            addCriterion("course11 in", values, "course11");
            return (Criteria) this;
        }

        public Criteria andCourse11NotIn(List<String> values) {
            addCriterion("course11 not in", values, "course11");
            return (Criteria) this;
        }

        public Criteria andCourse11Between(String value1, String value2) {
            addCriterion("course11 between", value1, value2, "course11");
            return (Criteria) this;
        }

        public Criteria andCourse11NotBetween(String value1, String value2) {
            addCriterion("course11 not between", value1, value2, "course11");
            return (Criteria) this;
        }

        public Criteria andCourse12IsNull() {
            addCriterion("course12 is null");
            return (Criteria) this;
        }

        public Criteria andCourse12IsNotNull() {
            addCriterion("course12 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse12EqualTo(String value) {
            addCriterion("course12 =", value, "course12");
            return (Criteria) this;
        }

        public Criteria andCourse12NotEqualTo(String value) {
            addCriterion("course12 <>", value, "course12");
            return (Criteria) this;
        }

        public Criteria andCourse12GreaterThan(String value) {
            addCriterion("course12 >", value, "course12");
            return (Criteria) this;
        }

        public Criteria andCourse12GreaterThanOrEqualTo(String value) {
            addCriterion("course12 >=", value, "course12");
            return (Criteria) this;
        }

        public Criteria andCourse12LessThan(String value) {
            addCriterion("course12 <", value, "course12");
            return (Criteria) this;
        }

        public Criteria andCourse12LessThanOrEqualTo(String value) {
            addCriterion("course12 <=", value, "course12");
            return (Criteria) this;
        }

        public Criteria andCourse12Like(String value) {
            addCriterion("course12 like", value, "course12");
            return (Criteria) this;
        }

        public Criteria andCourse12NotLike(String value) {
            addCriterion("course12 not like", value, "course12");
            return (Criteria) this;
        }

        public Criteria andCourse12In(List<String> values) {
            addCriterion("course12 in", values, "course12");
            return (Criteria) this;
        }

        public Criteria andCourse12NotIn(List<String> values) {
            addCriterion("course12 not in", values, "course12");
            return (Criteria) this;
        }

        public Criteria andCourse12Between(String value1, String value2) {
            addCriterion("course12 between", value1, value2, "course12");
            return (Criteria) this;
        }

        public Criteria andCourse12NotBetween(String value1, String value2) {
            addCriterion("course12 not between", value1, value2, "course12");
            return (Criteria) this;
        }

        public Criteria andCourse13IsNull() {
            addCriterion("course13 is null");
            return (Criteria) this;
        }

        public Criteria andCourse13IsNotNull() {
            addCriterion("course13 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse13EqualTo(String value) {
            addCriterion("course13 =", value, "course13");
            return (Criteria) this;
        }

        public Criteria andCourse13NotEqualTo(String value) {
            addCriterion("course13 <>", value, "course13");
            return (Criteria) this;
        }

        public Criteria andCourse13GreaterThan(String value) {
            addCriterion("course13 >", value, "course13");
            return (Criteria) this;
        }

        public Criteria andCourse13GreaterThanOrEqualTo(String value) {
            addCriterion("course13 >=", value, "course13");
            return (Criteria) this;
        }

        public Criteria andCourse13LessThan(String value) {
            addCriterion("course13 <", value, "course13");
            return (Criteria) this;
        }

        public Criteria andCourse13LessThanOrEqualTo(String value) {
            addCriterion("course13 <=", value, "course13");
            return (Criteria) this;
        }

        public Criteria andCourse13Like(String value) {
            addCriterion("course13 like", value, "course13");
            return (Criteria) this;
        }

        public Criteria andCourse13NotLike(String value) {
            addCriterion("course13 not like", value, "course13");
            return (Criteria) this;
        }

        public Criteria andCourse13In(List<String> values) {
            addCriterion("course13 in", values, "course13");
            return (Criteria) this;
        }

        public Criteria andCourse13NotIn(List<String> values) {
            addCriterion("course13 not in", values, "course13");
            return (Criteria) this;
        }

        public Criteria andCourse13Between(String value1, String value2) {
            addCriterion("course13 between", value1, value2, "course13");
            return (Criteria) this;
        }

        public Criteria andCourse13NotBetween(String value1, String value2) {
            addCriterion("course13 not between", value1, value2, "course13");
            return (Criteria) this;
        }

        public Criteria andCourse14IsNull() {
            addCriterion("course14 is null");
            return (Criteria) this;
        }

        public Criteria andCourse14IsNotNull() {
            addCriterion("course14 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse14EqualTo(String value) {
            addCriterion("course14 =", value, "course14");
            return (Criteria) this;
        }

        public Criteria andCourse14NotEqualTo(String value) {
            addCriterion("course14 <>", value, "course14");
            return (Criteria) this;
        }

        public Criteria andCourse14GreaterThan(String value) {
            addCriterion("course14 >", value, "course14");
            return (Criteria) this;
        }

        public Criteria andCourse14GreaterThanOrEqualTo(String value) {
            addCriterion("course14 >=", value, "course14");
            return (Criteria) this;
        }

        public Criteria andCourse14LessThan(String value) {
            addCriterion("course14 <", value, "course14");
            return (Criteria) this;
        }

        public Criteria andCourse14LessThanOrEqualTo(String value) {
            addCriterion("course14 <=", value, "course14");
            return (Criteria) this;
        }

        public Criteria andCourse14Like(String value) {
            addCriterion("course14 like", value, "course14");
            return (Criteria) this;
        }

        public Criteria andCourse14NotLike(String value) {
            addCriterion("course14 not like", value, "course14");
            return (Criteria) this;
        }

        public Criteria andCourse14In(List<String> values) {
            addCriterion("course14 in", values, "course14");
            return (Criteria) this;
        }

        public Criteria andCourse14NotIn(List<String> values) {
            addCriterion("course14 not in", values, "course14");
            return (Criteria) this;
        }

        public Criteria andCourse14Between(String value1, String value2) {
            addCriterion("course14 between", value1, value2, "course14");
            return (Criteria) this;
        }

        public Criteria andCourse14NotBetween(String value1, String value2) {
            addCriterion("course14 not between", value1, value2, "course14");
            return (Criteria) this;
        }

        public Criteria andCourse15IsNull() {
            addCriterion("course15 is null");
            return (Criteria) this;
        }

        public Criteria andCourse15IsNotNull() {
            addCriterion("course15 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse15EqualTo(String value) {
            addCriterion("course15 =", value, "course15");
            return (Criteria) this;
        }

        public Criteria andCourse15NotEqualTo(String value) {
            addCriterion("course15 <>", value, "course15");
            return (Criteria) this;
        }

        public Criteria andCourse15GreaterThan(String value) {
            addCriterion("course15 >", value, "course15");
            return (Criteria) this;
        }

        public Criteria andCourse15GreaterThanOrEqualTo(String value) {
            addCriterion("course15 >=", value, "course15");
            return (Criteria) this;
        }

        public Criteria andCourse15LessThan(String value) {
            addCriterion("course15 <", value, "course15");
            return (Criteria) this;
        }

        public Criteria andCourse15LessThanOrEqualTo(String value) {
            addCriterion("course15 <=", value, "course15");
            return (Criteria) this;
        }

        public Criteria andCourse15Like(String value) {
            addCriterion("course15 like", value, "course15");
            return (Criteria) this;
        }

        public Criteria andCourse15NotLike(String value) {
            addCriterion("course15 not like", value, "course15");
            return (Criteria) this;
        }

        public Criteria andCourse15In(List<String> values) {
            addCriterion("course15 in", values, "course15");
            return (Criteria) this;
        }

        public Criteria andCourse15NotIn(List<String> values) {
            addCriterion("course15 not in", values, "course15");
            return (Criteria) this;
        }

        public Criteria andCourse15Between(String value1, String value2) {
            addCriterion("course15 between", value1, value2, "course15");
            return (Criteria) this;
        }

        public Criteria andCourse15NotBetween(String value1, String value2) {
            addCriterion("course15 not between", value1, value2, "course15");
            return (Criteria) this;
        }

        public Criteria andCourse16IsNull() {
            addCriterion("course16 is null");
            return (Criteria) this;
        }

        public Criteria andCourse16IsNotNull() {
            addCriterion("course16 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse16EqualTo(String value) {
            addCriterion("course16 =", value, "course16");
            return (Criteria) this;
        }

        public Criteria andCourse16NotEqualTo(String value) {
            addCriterion("course16 <>", value, "course16");
            return (Criteria) this;
        }

        public Criteria andCourse16GreaterThan(String value) {
            addCriterion("course16 >", value, "course16");
            return (Criteria) this;
        }

        public Criteria andCourse16GreaterThanOrEqualTo(String value) {
            addCriterion("course16 >=", value, "course16");
            return (Criteria) this;
        }

        public Criteria andCourse16LessThan(String value) {
            addCriterion("course16 <", value, "course16");
            return (Criteria) this;
        }

        public Criteria andCourse16LessThanOrEqualTo(String value) {
            addCriterion("course16 <=", value, "course16");
            return (Criteria) this;
        }

        public Criteria andCourse16Like(String value) {
            addCriterion("course16 like", value, "course16");
            return (Criteria) this;
        }

        public Criteria andCourse16NotLike(String value) {
            addCriterion("course16 not like", value, "course16");
            return (Criteria) this;
        }

        public Criteria andCourse16In(List<String> values) {
            addCriterion("course16 in", values, "course16");
            return (Criteria) this;
        }

        public Criteria andCourse16NotIn(List<String> values) {
            addCriterion("course16 not in", values, "course16");
            return (Criteria) this;
        }

        public Criteria andCourse16Between(String value1, String value2) {
            addCriterion("course16 between", value1, value2, "course16");
            return (Criteria) this;
        }

        public Criteria andCourse16NotBetween(String value1, String value2) {
            addCriterion("course16 not between", value1, value2, "course16");
            return (Criteria) this;
        }

        public Criteria andCourse17IsNull() {
            addCriterion("course17 is null");
            return (Criteria) this;
        }

        public Criteria andCourse17IsNotNull() {
            addCriterion("course17 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse17EqualTo(String value) {
            addCriterion("course17 =", value, "course17");
            return (Criteria) this;
        }

        public Criteria andCourse17NotEqualTo(String value) {
            addCriterion("course17 <>", value, "course17");
            return (Criteria) this;
        }

        public Criteria andCourse17GreaterThan(String value) {
            addCriterion("course17 >", value, "course17");
            return (Criteria) this;
        }

        public Criteria andCourse17GreaterThanOrEqualTo(String value) {
            addCriterion("course17 >=", value, "course17");
            return (Criteria) this;
        }

        public Criteria andCourse17LessThan(String value) {
            addCriterion("course17 <", value, "course17");
            return (Criteria) this;
        }

        public Criteria andCourse17LessThanOrEqualTo(String value) {
            addCriterion("course17 <=", value, "course17");
            return (Criteria) this;
        }

        public Criteria andCourse17Like(String value) {
            addCriterion("course17 like", value, "course17");
            return (Criteria) this;
        }

        public Criteria andCourse17NotLike(String value) {
            addCriterion("course17 not like", value, "course17");
            return (Criteria) this;
        }

        public Criteria andCourse17In(List<String> values) {
            addCriterion("course17 in", values, "course17");
            return (Criteria) this;
        }

        public Criteria andCourse17NotIn(List<String> values) {
            addCriterion("course17 not in", values, "course17");
            return (Criteria) this;
        }

        public Criteria andCourse17Between(String value1, String value2) {
            addCriterion("course17 between", value1, value2, "course17");
            return (Criteria) this;
        }

        public Criteria andCourse17NotBetween(String value1, String value2) {
            addCriterion("course17 not between", value1, value2, "course17");
            return (Criteria) this;
        }

        public Criteria andCourse18IsNull() {
            addCriterion("course18 is null");
            return (Criteria) this;
        }

        public Criteria andCourse18IsNotNull() {
            addCriterion("course18 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse18EqualTo(String value) {
            addCriterion("course18 =", value, "course18");
            return (Criteria) this;
        }

        public Criteria andCourse18NotEqualTo(String value) {
            addCriterion("course18 <>", value, "course18");
            return (Criteria) this;
        }

        public Criteria andCourse18GreaterThan(String value) {
            addCriterion("course18 >", value, "course18");
            return (Criteria) this;
        }

        public Criteria andCourse18GreaterThanOrEqualTo(String value) {
            addCriterion("course18 >=", value, "course18");
            return (Criteria) this;
        }

        public Criteria andCourse18LessThan(String value) {
            addCriterion("course18 <", value, "course18");
            return (Criteria) this;
        }

        public Criteria andCourse18LessThanOrEqualTo(String value) {
            addCriterion("course18 <=", value, "course18");
            return (Criteria) this;
        }

        public Criteria andCourse18Like(String value) {
            addCriterion("course18 like", value, "course18");
            return (Criteria) this;
        }

        public Criteria andCourse18NotLike(String value) {
            addCriterion("course18 not like", value, "course18");
            return (Criteria) this;
        }

        public Criteria andCourse18In(List<String> values) {
            addCriterion("course18 in", values, "course18");
            return (Criteria) this;
        }

        public Criteria andCourse18NotIn(List<String> values) {
            addCriterion("course18 not in", values, "course18");
            return (Criteria) this;
        }

        public Criteria andCourse18Between(String value1, String value2) {
            addCriterion("course18 between", value1, value2, "course18");
            return (Criteria) this;
        }

        public Criteria andCourse18NotBetween(String value1, String value2) {
            addCriterion("course18 not between", value1, value2, "course18");
            return (Criteria) this;
        }

        public Criteria andCourse19IsNull() {
            addCriterion("course19 is null");
            return (Criteria) this;
        }

        public Criteria andCourse19IsNotNull() {
            addCriterion("course19 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse19EqualTo(String value) {
            addCriterion("course19 =", value, "course19");
            return (Criteria) this;
        }

        public Criteria andCourse19NotEqualTo(String value) {
            addCriterion("course19 <>", value, "course19");
            return (Criteria) this;
        }

        public Criteria andCourse19GreaterThan(String value) {
            addCriterion("course19 >", value, "course19");
            return (Criteria) this;
        }

        public Criteria andCourse19GreaterThanOrEqualTo(String value) {
            addCriterion("course19 >=", value, "course19");
            return (Criteria) this;
        }

        public Criteria andCourse19LessThan(String value) {
            addCriterion("course19 <", value, "course19");
            return (Criteria) this;
        }

        public Criteria andCourse19LessThanOrEqualTo(String value) {
            addCriterion("course19 <=", value, "course19");
            return (Criteria) this;
        }

        public Criteria andCourse19Like(String value) {
            addCriterion("course19 like", value, "course19");
            return (Criteria) this;
        }

        public Criteria andCourse19NotLike(String value) {
            addCriterion("course19 not like", value, "course19");
            return (Criteria) this;
        }

        public Criteria andCourse19In(List<String> values) {
            addCriterion("course19 in", values, "course19");
            return (Criteria) this;
        }

        public Criteria andCourse19NotIn(List<String> values) {
            addCriterion("course19 not in", values, "course19");
            return (Criteria) this;
        }

        public Criteria andCourse19Between(String value1, String value2) {
            addCriterion("course19 between", value1, value2, "course19");
            return (Criteria) this;
        }

        public Criteria andCourse19NotBetween(String value1, String value2) {
            addCriterion("course19 not between", value1, value2, "course19");
            return (Criteria) this;
        }

        public Criteria andCourse20IsNull() {
            addCriterion("course20 is null");
            return (Criteria) this;
        }

        public Criteria andCourse20IsNotNull() {
            addCriterion("course20 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse20EqualTo(String value) {
            addCriterion("course20 =", value, "course20");
            return (Criteria) this;
        }

        public Criteria andCourse20NotEqualTo(String value) {
            addCriterion("course20 <>", value, "course20");
            return (Criteria) this;
        }

        public Criteria andCourse20GreaterThan(String value) {
            addCriterion("course20 >", value, "course20");
            return (Criteria) this;
        }

        public Criteria andCourse20GreaterThanOrEqualTo(String value) {
            addCriterion("course20 >=", value, "course20");
            return (Criteria) this;
        }

        public Criteria andCourse20LessThan(String value) {
            addCriterion("course20 <", value, "course20");
            return (Criteria) this;
        }

        public Criteria andCourse20LessThanOrEqualTo(String value) {
            addCriterion("course20 <=", value, "course20");
            return (Criteria) this;
        }

        public Criteria andCourse20Like(String value) {
            addCriterion("course20 like", value, "course20");
            return (Criteria) this;
        }

        public Criteria andCourse20NotLike(String value) {
            addCriterion("course20 not like", value, "course20");
            return (Criteria) this;
        }

        public Criteria andCourse20In(List<String> values) {
            addCriterion("course20 in", values, "course20");
            return (Criteria) this;
        }

        public Criteria andCourse20NotIn(List<String> values) {
            addCriterion("course20 not in", values, "course20");
            return (Criteria) this;
        }

        public Criteria andCourse20Between(String value1, String value2) {
            addCriterion("course20 between", value1, value2, "course20");
            return (Criteria) this;
        }

        public Criteria andCourse20NotBetween(String value1, String value2) {
            addCriterion("course20 not between", value1, value2, "course20");
            return (Criteria) this;
        }

        public Criteria andCourse21IsNull() {
            addCriterion("course21 is null");
            return (Criteria) this;
        }

        public Criteria andCourse21IsNotNull() {
            addCriterion("course21 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse21EqualTo(String value) {
            addCriterion("course21 =", value, "course21");
            return (Criteria) this;
        }

        public Criteria andCourse21NotEqualTo(String value) {
            addCriterion("course21 <>", value, "course21");
            return (Criteria) this;
        }

        public Criteria andCourse21GreaterThan(String value) {
            addCriterion("course21 >", value, "course21");
            return (Criteria) this;
        }

        public Criteria andCourse21GreaterThanOrEqualTo(String value) {
            addCriterion("course21 >=", value, "course21");
            return (Criteria) this;
        }

        public Criteria andCourse21LessThan(String value) {
            addCriterion("course21 <", value, "course21");
            return (Criteria) this;
        }

        public Criteria andCourse21LessThanOrEqualTo(String value) {
            addCriterion("course21 <=", value, "course21");
            return (Criteria) this;
        }

        public Criteria andCourse21Like(String value) {
            addCriterion("course21 like", value, "course21");
            return (Criteria) this;
        }

        public Criteria andCourse21NotLike(String value) {
            addCriterion("course21 not like", value, "course21");
            return (Criteria) this;
        }

        public Criteria andCourse21In(List<String> values) {
            addCriterion("course21 in", values, "course21");
            return (Criteria) this;
        }

        public Criteria andCourse21NotIn(List<String> values) {
            addCriterion("course21 not in", values, "course21");
            return (Criteria) this;
        }

        public Criteria andCourse21Between(String value1, String value2) {
            addCriterion("course21 between", value1, value2, "course21");
            return (Criteria) this;
        }

        public Criteria andCourse21NotBetween(String value1, String value2) {
            addCriterion("course21 not between", value1, value2, "course21");
            return (Criteria) this;
        }

        public Criteria andCourse22IsNull() {
            addCriterion("course22 is null");
            return (Criteria) this;
        }

        public Criteria andCourse22IsNotNull() {
            addCriterion("course22 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse22EqualTo(String value) {
            addCriterion("course22 =", value, "course22");
            return (Criteria) this;
        }

        public Criteria andCourse22NotEqualTo(String value) {
            addCriterion("course22 <>", value, "course22");
            return (Criteria) this;
        }

        public Criteria andCourse22GreaterThan(String value) {
            addCriterion("course22 >", value, "course22");
            return (Criteria) this;
        }

        public Criteria andCourse22GreaterThanOrEqualTo(String value) {
            addCriterion("course22 >=", value, "course22");
            return (Criteria) this;
        }

        public Criteria andCourse22LessThan(String value) {
            addCriterion("course22 <", value, "course22");
            return (Criteria) this;
        }

        public Criteria andCourse22LessThanOrEqualTo(String value) {
            addCriterion("course22 <=", value, "course22");
            return (Criteria) this;
        }

        public Criteria andCourse22Like(String value) {
            addCriterion("course22 like", value, "course22");
            return (Criteria) this;
        }

        public Criteria andCourse22NotLike(String value) {
            addCriterion("course22 not like", value, "course22");
            return (Criteria) this;
        }

        public Criteria andCourse22In(List<String> values) {
            addCriterion("course22 in", values, "course22");
            return (Criteria) this;
        }

        public Criteria andCourse22NotIn(List<String> values) {
            addCriterion("course22 not in", values, "course22");
            return (Criteria) this;
        }

        public Criteria andCourse22Between(String value1, String value2) {
            addCriterion("course22 between", value1, value2, "course22");
            return (Criteria) this;
        }

        public Criteria andCourse22NotBetween(String value1, String value2) {
            addCriterion("course22 not between", value1, value2, "course22");
            return (Criteria) this;
        }

        public Criteria andCourse23IsNull() {
            addCriterion("course23 is null");
            return (Criteria) this;
        }

        public Criteria andCourse23IsNotNull() {
            addCriterion("course23 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse23EqualTo(String value) {
            addCriterion("course23 =", value, "course23");
            return (Criteria) this;
        }

        public Criteria andCourse23NotEqualTo(String value) {
            addCriterion("course23 <>", value, "course23");
            return (Criteria) this;
        }

        public Criteria andCourse23GreaterThan(String value) {
            addCriterion("course23 >", value, "course23");
            return (Criteria) this;
        }

        public Criteria andCourse23GreaterThanOrEqualTo(String value) {
            addCriterion("course23 >=", value, "course23");
            return (Criteria) this;
        }

        public Criteria andCourse23LessThan(String value) {
            addCriterion("course23 <", value, "course23");
            return (Criteria) this;
        }

        public Criteria andCourse23LessThanOrEqualTo(String value) {
            addCriterion("course23 <=", value, "course23");
            return (Criteria) this;
        }

        public Criteria andCourse23Like(String value) {
            addCriterion("course23 like", value, "course23");
            return (Criteria) this;
        }

        public Criteria andCourse23NotLike(String value) {
            addCriterion("course23 not like", value, "course23");
            return (Criteria) this;
        }

        public Criteria andCourse23In(List<String> values) {
            addCriterion("course23 in", values, "course23");
            return (Criteria) this;
        }

        public Criteria andCourse23NotIn(List<String> values) {
            addCriterion("course23 not in", values, "course23");
            return (Criteria) this;
        }

        public Criteria andCourse23Between(String value1, String value2) {
            addCriterion("course23 between", value1, value2, "course23");
            return (Criteria) this;
        }

        public Criteria andCourse23NotBetween(String value1, String value2) {
            addCriterion("course23 not between", value1, value2, "course23");
            return (Criteria) this;
        }

        public Criteria andCourse24IsNull() {
            addCriterion("course24 is null");
            return (Criteria) this;
        }

        public Criteria andCourse24IsNotNull() {
            addCriterion("course24 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse24EqualTo(String value) {
            addCriterion("course24 =", value, "course24");
            return (Criteria) this;
        }

        public Criteria andCourse24NotEqualTo(String value) {
            addCriterion("course24 <>", value, "course24");
            return (Criteria) this;
        }

        public Criteria andCourse24GreaterThan(String value) {
            addCriterion("course24 >", value, "course24");
            return (Criteria) this;
        }

        public Criteria andCourse24GreaterThanOrEqualTo(String value) {
            addCriterion("course24 >=", value, "course24");
            return (Criteria) this;
        }

        public Criteria andCourse24LessThan(String value) {
            addCriterion("course24 <", value, "course24");
            return (Criteria) this;
        }

        public Criteria andCourse24LessThanOrEqualTo(String value) {
            addCriterion("course24 <=", value, "course24");
            return (Criteria) this;
        }

        public Criteria andCourse24Like(String value) {
            addCriterion("course24 like", value, "course24");
            return (Criteria) this;
        }

        public Criteria andCourse24NotLike(String value) {
            addCriterion("course24 not like", value, "course24");
            return (Criteria) this;
        }

        public Criteria andCourse24In(List<String> values) {
            addCriterion("course24 in", values, "course24");
            return (Criteria) this;
        }

        public Criteria andCourse24NotIn(List<String> values) {
            addCriterion("course24 not in", values, "course24");
            return (Criteria) this;
        }

        public Criteria andCourse24Between(String value1, String value2) {
            addCriterion("course24 between", value1, value2, "course24");
            return (Criteria) this;
        }

        public Criteria andCourse24NotBetween(String value1, String value2) {
            addCriterion("course24 not between", value1, value2, "course24");
            return (Criteria) this;
        }

        public Criteria andCourse25IsNull() {
            addCriterion("course25 is null");
            return (Criteria) this;
        }

        public Criteria andCourse25IsNotNull() {
            addCriterion("course25 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse25EqualTo(String value) {
            addCriterion("course25 =", value, "course25");
            return (Criteria) this;
        }

        public Criteria andCourse25NotEqualTo(String value) {
            addCriterion("course25 <>", value, "course25");
            return (Criteria) this;
        }

        public Criteria andCourse25GreaterThan(String value) {
            addCriterion("course25 >", value, "course25");
            return (Criteria) this;
        }

        public Criteria andCourse25GreaterThanOrEqualTo(String value) {
            addCriterion("course25 >=", value, "course25");
            return (Criteria) this;
        }

        public Criteria andCourse25LessThan(String value) {
            addCriterion("course25 <", value, "course25");
            return (Criteria) this;
        }

        public Criteria andCourse25LessThanOrEqualTo(String value) {
            addCriterion("course25 <=", value, "course25");
            return (Criteria) this;
        }

        public Criteria andCourse25Like(String value) {
            addCriterion("course25 like", value, "course25");
            return (Criteria) this;
        }

        public Criteria andCourse25NotLike(String value) {
            addCriterion("course25 not like", value, "course25");
            return (Criteria) this;
        }

        public Criteria andCourse25In(List<String> values) {
            addCriterion("course25 in", values, "course25");
            return (Criteria) this;
        }

        public Criteria andCourse25NotIn(List<String> values) {
            addCriterion("course25 not in", values, "course25");
            return (Criteria) this;
        }

        public Criteria andCourse25Between(String value1, String value2) {
            addCriterion("course25 between", value1, value2, "course25");
            return (Criteria) this;
        }

        public Criteria andCourse25NotBetween(String value1, String value2) {
            addCriterion("course25 not between", value1, value2, "course25");
            return (Criteria) this;
        }

        public Criteria andCourse26IsNull() {
            addCriterion("course26 is null");
            return (Criteria) this;
        }

        public Criteria andCourse26IsNotNull() {
            addCriterion("course26 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse26EqualTo(String value) {
            addCriterion("course26 =", value, "course26");
            return (Criteria) this;
        }

        public Criteria andCourse26NotEqualTo(String value) {
            addCriterion("course26 <>", value, "course26");
            return (Criteria) this;
        }

        public Criteria andCourse26GreaterThan(String value) {
            addCriterion("course26 >", value, "course26");
            return (Criteria) this;
        }

        public Criteria andCourse26GreaterThanOrEqualTo(String value) {
            addCriterion("course26 >=", value, "course26");
            return (Criteria) this;
        }

        public Criteria andCourse26LessThan(String value) {
            addCriterion("course26 <", value, "course26");
            return (Criteria) this;
        }

        public Criteria andCourse26LessThanOrEqualTo(String value) {
            addCriterion("course26 <=", value, "course26");
            return (Criteria) this;
        }

        public Criteria andCourse26Like(String value) {
            addCriterion("course26 like", value, "course26");
            return (Criteria) this;
        }

        public Criteria andCourse26NotLike(String value) {
            addCriterion("course26 not like", value, "course26");
            return (Criteria) this;
        }

        public Criteria andCourse26In(List<String> values) {
            addCriterion("course26 in", values, "course26");
            return (Criteria) this;
        }

        public Criteria andCourse26NotIn(List<String> values) {
            addCriterion("course26 not in", values, "course26");
            return (Criteria) this;
        }

        public Criteria andCourse26Between(String value1, String value2) {
            addCriterion("course26 between", value1, value2, "course26");
            return (Criteria) this;
        }

        public Criteria andCourse26NotBetween(String value1, String value2) {
            addCriterion("course26 not between", value1, value2, "course26");
            return (Criteria) this;
        }

        public Criteria andCourse27IsNull() {
            addCriterion("course27 is null");
            return (Criteria) this;
        }

        public Criteria andCourse27IsNotNull() {
            addCriterion("course27 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse27EqualTo(String value) {
            addCriterion("course27 =", value, "course27");
            return (Criteria) this;
        }

        public Criteria andCourse27NotEqualTo(String value) {
            addCriterion("course27 <>", value, "course27");
            return (Criteria) this;
        }

        public Criteria andCourse27GreaterThan(String value) {
            addCriterion("course27 >", value, "course27");
            return (Criteria) this;
        }

        public Criteria andCourse27GreaterThanOrEqualTo(String value) {
            addCriterion("course27 >=", value, "course27");
            return (Criteria) this;
        }

        public Criteria andCourse27LessThan(String value) {
            addCriterion("course27 <", value, "course27");
            return (Criteria) this;
        }

        public Criteria andCourse27LessThanOrEqualTo(String value) {
            addCriterion("course27 <=", value, "course27");
            return (Criteria) this;
        }

        public Criteria andCourse27Like(String value) {
            addCriterion("course27 like", value, "course27");
            return (Criteria) this;
        }

        public Criteria andCourse27NotLike(String value) {
            addCriterion("course27 not like", value, "course27");
            return (Criteria) this;
        }

        public Criteria andCourse27In(List<String> values) {
            addCriterion("course27 in", values, "course27");
            return (Criteria) this;
        }

        public Criteria andCourse27NotIn(List<String> values) {
            addCriterion("course27 not in", values, "course27");
            return (Criteria) this;
        }

        public Criteria andCourse27Between(String value1, String value2) {
            addCriterion("course27 between", value1, value2, "course27");
            return (Criteria) this;
        }

        public Criteria andCourse27NotBetween(String value1, String value2) {
            addCriterion("course27 not between", value1, value2, "course27");
            return (Criteria) this;
        }

        public Criteria andCourse28IsNull() {
            addCriterion("course28 is null");
            return (Criteria) this;
        }

        public Criteria andCourse28IsNotNull() {
            addCriterion("course28 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse28EqualTo(String value) {
            addCriterion("course28 =", value, "course28");
            return (Criteria) this;
        }

        public Criteria andCourse28NotEqualTo(String value) {
            addCriterion("course28 <>", value, "course28");
            return (Criteria) this;
        }

        public Criteria andCourse28GreaterThan(String value) {
            addCriterion("course28 >", value, "course28");
            return (Criteria) this;
        }

        public Criteria andCourse28GreaterThanOrEqualTo(String value) {
            addCriterion("course28 >=", value, "course28");
            return (Criteria) this;
        }

        public Criteria andCourse28LessThan(String value) {
            addCriterion("course28 <", value, "course28");
            return (Criteria) this;
        }

        public Criteria andCourse28LessThanOrEqualTo(String value) {
            addCriterion("course28 <=", value, "course28");
            return (Criteria) this;
        }

        public Criteria andCourse28Like(String value) {
            addCriterion("course28 like", value, "course28");
            return (Criteria) this;
        }

        public Criteria andCourse28NotLike(String value) {
            addCriterion("course28 not like", value, "course28");
            return (Criteria) this;
        }

        public Criteria andCourse28In(List<String> values) {
            addCriterion("course28 in", values, "course28");
            return (Criteria) this;
        }

        public Criteria andCourse28NotIn(List<String> values) {
            addCriterion("course28 not in", values, "course28");
            return (Criteria) this;
        }

        public Criteria andCourse28Between(String value1, String value2) {
            addCriterion("course28 between", value1, value2, "course28");
            return (Criteria) this;
        }

        public Criteria andCourse28NotBetween(String value1, String value2) {
            addCriterion("course28 not between", value1, value2, "course28");
            return (Criteria) this;
        }

        public Criteria andCourse29IsNull() {
            addCriterion("course29 is null");
            return (Criteria) this;
        }

        public Criteria andCourse29IsNotNull() {
            addCriterion("course29 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse29EqualTo(String value) {
            addCriterion("course29 =", value, "course29");
            return (Criteria) this;
        }

        public Criteria andCourse29NotEqualTo(String value) {
            addCriterion("course29 <>", value, "course29");
            return (Criteria) this;
        }

        public Criteria andCourse29GreaterThan(String value) {
            addCriterion("course29 >", value, "course29");
            return (Criteria) this;
        }

        public Criteria andCourse29GreaterThanOrEqualTo(String value) {
            addCriterion("course29 >=", value, "course29");
            return (Criteria) this;
        }

        public Criteria andCourse29LessThan(String value) {
            addCriterion("course29 <", value, "course29");
            return (Criteria) this;
        }

        public Criteria andCourse29LessThanOrEqualTo(String value) {
            addCriterion("course29 <=", value, "course29");
            return (Criteria) this;
        }

        public Criteria andCourse29Like(String value) {
            addCriterion("course29 like", value, "course29");
            return (Criteria) this;
        }

        public Criteria andCourse29NotLike(String value) {
            addCriterion("course29 not like", value, "course29");
            return (Criteria) this;
        }

        public Criteria andCourse29In(List<String> values) {
            addCriterion("course29 in", values, "course29");
            return (Criteria) this;
        }

        public Criteria andCourse29NotIn(List<String> values) {
            addCriterion("course29 not in", values, "course29");
            return (Criteria) this;
        }

        public Criteria andCourse29Between(String value1, String value2) {
            addCriterion("course29 between", value1, value2, "course29");
            return (Criteria) this;
        }

        public Criteria andCourse29NotBetween(String value1, String value2) {
            addCriterion("course29 not between", value1, value2, "course29");
            return (Criteria) this;
        }

        public Criteria andCourse30IsNull() {
            addCriterion("course30 is null");
            return (Criteria) this;
        }

        public Criteria andCourse30IsNotNull() {
            addCriterion("course30 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse30EqualTo(String value) {
            addCriterion("course30 =", value, "course30");
            return (Criteria) this;
        }

        public Criteria andCourse30NotEqualTo(String value) {
            addCriterion("course30 <>", value, "course30");
            return (Criteria) this;
        }

        public Criteria andCourse30GreaterThan(String value) {
            addCriterion("course30 >", value, "course30");
            return (Criteria) this;
        }

        public Criteria andCourse30GreaterThanOrEqualTo(String value) {
            addCriterion("course30 >=", value, "course30");
            return (Criteria) this;
        }

        public Criteria andCourse30LessThan(String value) {
            addCriterion("course30 <", value, "course30");
            return (Criteria) this;
        }

        public Criteria andCourse30LessThanOrEqualTo(String value) {
            addCriterion("course30 <=", value, "course30");
            return (Criteria) this;
        }

        public Criteria andCourse30Like(String value) {
            addCriterion("course30 like", value, "course30");
            return (Criteria) this;
        }

        public Criteria andCourse30NotLike(String value) {
            addCriterion("course30 not like", value, "course30");
            return (Criteria) this;
        }

        public Criteria andCourse30In(List<String> values) {
            addCriterion("course30 in", values, "course30");
            return (Criteria) this;
        }

        public Criteria andCourse30NotIn(List<String> values) {
            addCriterion("course30 not in", values, "course30");
            return (Criteria) this;
        }

        public Criteria andCourse30Between(String value1, String value2) {
            addCriterion("course30 between", value1, value2, "course30");
            return (Criteria) this;
        }

        public Criteria andCourse30NotBetween(String value1, String value2) {
            addCriterion("course30 not between", value1, value2, "course30");
            return (Criteria) this;
        }

        public Criteria andCourse31IsNull() {
            addCriterion("course31 is null");
            return (Criteria) this;
        }

        public Criteria andCourse31IsNotNull() {
            addCriterion("course31 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse31EqualTo(String value) {
            addCriterion("course31 =", value, "course31");
            return (Criteria) this;
        }

        public Criteria andCourse31NotEqualTo(String value) {
            addCriterion("course31 <>", value, "course31");
            return (Criteria) this;
        }

        public Criteria andCourse31GreaterThan(String value) {
            addCriterion("course31 >", value, "course31");
            return (Criteria) this;
        }

        public Criteria andCourse31GreaterThanOrEqualTo(String value) {
            addCriterion("course31 >=", value, "course31");
            return (Criteria) this;
        }

        public Criteria andCourse31LessThan(String value) {
            addCriterion("course31 <", value, "course31");
            return (Criteria) this;
        }

        public Criteria andCourse31LessThanOrEqualTo(String value) {
            addCriterion("course31 <=", value, "course31");
            return (Criteria) this;
        }

        public Criteria andCourse31Like(String value) {
            addCriterion("course31 like", value, "course31");
            return (Criteria) this;
        }

        public Criteria andCourse31NotLike(String value) {
            addCriterion("course31 not like", value, "course31");
            return (Criteria) this;
        }

        public Criteria andCourse31In(List<String> values) {
            addCriterion("course31 in", values, "course31");
            return (Criteria) this;
        }

        public Criteria andCourse31NotIn(List<String> values) {
            addCriterion("course31 not in", values, "course31");
            return (Criteria) this;
        }

        public Criteria andCourse31Between(String value1, String value2) {
            addCriterion("course31 between", value1, value2, "course31");
            return (Criteria) this;
        }

        public Criteria andCourse31NotBetween(String value1, String value2) {
            addCriterion("course31 not between", value1, value2, "course31");
            return (Criteria) this;
        }

        public Criteria andCourse32IsNull() {
            addCriterion("course32 is null");
            return (Criteria) this;
        }

        public Criteria andCourse32IsNotNull() {
            addCriterion("course32 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse32EqualTo(String value) {
            addCriterion("course32 =", value, "course32");
            return (Criteria) this;
        }

        public Criteria andCourse32NotEqualTo(String value) {
            addCriterion("course32 <>", value, "course32");
            return (Criteria) this;
        }

        public Criteria andCourse32GreaterThan(String value) {
            addCriterion("course32 >", value, "course32");
            return (Criteria) this;
        }

        public Criteria andCourse32GreaterThanOrEqualTo(String value) {
            addCriterion("course32 >=", value, "course32");
            return (Criteria) this;
        }

        public Criteria andCourse32LessThan(String value) {
            addCriterion("course32 <", value, "course32");
            return (Criteria) this;
        }

        public Criteria andCourse32LessThanOrEqualTo(String value) {
            addCriterion("course32 <=", value, "course32");
            return (Criteria) this;
        }

        public Criteria andCourse32Like(String value) {
            addCriterion("course32 like", value, "course32");
            return (Criteria) this;
        }

        public Criteria andCourse32NotLike(String value) {
            addCriterion("course32 not like", value, "course32");
            return (Criteria) this;
        }

        public Criteria andCourse32In(List<String> values) {
            addCriterion("course32 in", values, "course32");
            return (Criteria) this;
        }

        public Criteria andCourse32NotIn(List<String> values) {
            addCriterion("course32 not in", values, "course32");
            return (Criteria) this;
        }

        public Criteria andCourse32Between(String value1, String value2) {
            addCriterion("course32 between", value1, value2, "course32");
            return (Criteria) this;
        }

        public Criteria andCourse32NotBetween(String value1, String value2) {
            addCriterion("course32 not between", value1, value2, "course32");
            return (Criteria) this;
        }

        public Criteria andCourse33IsNull() {
            addCriterion("course33 is null");
            return (Criteria) this;
        }

        public Criteria andCourse33IsNotNull() {
            addCriterion("course33 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse33EqualTo(String value) {
            addCriterion("course33 =", value, "course33");
            return (Criteria) this;
        }

        public Criteria andCourse33NotEqualTo(String value) {
            addCriterion("course33 <>", value, "course33");
            return (Criteria) this;
        }

        public Criteria andCourse33GreaterThan(String value) {
            addCriterion("course33 >", value, "course33");
            return (Criteria) this;
        }

        public Criteria andCourse33GreaterThanOrEqualTo(String value) {
            addCriterion("course33 >=", value, "course33");
            return (Criteria) this;
        }

        public Criteria andCourse33LessThan(String value) {
            addCriterion("course33 <", value, "course33");
            return (Criteria) this;
        }

        public Criteria andCourse33LessThanOrEqualTo(String value) {
            addCriterion("course33 <=", value, "course33");
            return (Criteria) this;
        }

        public Criteria andCourse33Like(String value) {
            addCriterion("course33 like", value, "course33");
            return (Criteria) this;
        }

        public Criteria andCourse33NotLike(String value) {
            addCriterion("course33 not like", value, "course33");
            return (Criteria) this;
        }

        public Criteria andCourse33In(List<String> values) {
            addCriterion("course33 in", values, "course33");
            return (Criteria) this;
        }

        public Criteria andCourse33NotIn(List<String> values) {
            addCriterion("course33 not in", values, "course33");
            return (Criteria) this;
        }

        public Criteria andCourse33Between(String value1, String value2) {
            addCriterion("course33 between", value1, value2, "course33");
            return (Criteria) this;
        }

        public Criteria andCourse33NotBetween(String value1, String value2) {
            addCriterion("course33 not between", value1, value2, "course33");
            return (Criteria) this;
        }

        public Criteria andCourse34IsNull() {
            addCriterion("course34 is null");
            return (Criteria) this;
        }

        public Criteria andCourse34IsNotNull() {
            addCriterion("course34 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse34EqualTo(String value) {
            addCriterion("course34 =", value, "course34");
            return (Criteria) this;
        }

        public Criteria andCourse34NotEqualTo(String value) {
            addCriterion("course34 <>", value, "course34");
            return (Criteria) this;
        }

        public Criteria andCourse34GreaterThan(String value) {
            addCriterion("course34 >", value, "course34");
            return (Criteria) this;
        }

        public Criteria andCourse34GreaterThanOrEqualTo(String value) {
            addCriterion("course34 >=", value, "course34");
            return (Criteria) this;
        }

        public Criteria andCourse34LessThan(String value) {
            addCriterion("course34 <", value, "course34");
            return (Criteria) this;
        }

        public Criteria andCourse34LessThanOrEqualTo(String value) {
            addCriterion("course34 <=", value, "course34");
            return (Criteria) this;
        }

        public Criteria andCourse34Like(String value) {
            addCriterion("course34 like", value, "course34");
            return (Criteria) this;
        }

        public Criteria andCourse34NotLike(String value) {
            addCriterion("course34 not like", value, "course34");
            return (Criteria) this;
        }

        public Criteria andCourse34In(List<String> values) {
            addCriterion("course34 in", values, "course34");
            return (Criteria) this;
        }

        public Criteria andCourse34NotIn(List<String> values) {
            addCriterion("course34 not in", values, "course34");
            return (Criteria) this;
        }

        public Criteria andCourse34Between(String value1, String value2) {
            addCriterion("course34 between", value1, value2, "course34");
            return (Criteria) this;
        }

        public Criteria andCourse34NotBetween(String value1, String value2) {
            addCriterion("course34 not between", value1, value2, "course34");
            return (Criteria) this;
        }

        public Criteria andCourse35IsNull() {
            addCriterion("course35 is null");
            return (Criteria) this;
        }

        public Criteria andCourse35IsNotNull() {
            addCriterion("course35 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse35EqualTo(String value) {
            addCriterion("course35 =", value, "course35");
            return (Criteria) this;
        }

        public Criteria andCourse35NotEqualTo(String value) {
            addCriterion("course35 <>", value, "course35");
            return (Criteria) this;
        }

        public Criteria andCourse35GreaterThan(String value) {
            addCriterion("course35 >", value, "course35");
            return (Criteria) this;
        }

        public Criteria andCourse35GreaterThanOrEqualTo(String value) {
            addCriterion("course35 >=", value, "course35");
            return (Criteria) this;
        }

        public Criteria andCourse35LessThan(String value) {
            addCriterion("course35 <", value, "course35");
            return (Criteria) this;
        }

        public Criteria andCourse35LessThanOrEqualTo(String value) {
            addCriterion("course35 <=", value, "course35");
            return (Criteria) this;
        }

        public Criteria andCourse35Like(String value) {
            addCriterion("course35 like", value, "course35");
            return (Criteria) this;
        }

        public Criteria andCourse35NotLike(String value) {
            addCriterion("course35 not like", value, "course35");
            return (Criteria) this;
        }

        public Criteria andCourse35In(List<String> values) {
            addCriterion("course35 in", values, "course35");
            return (Criteria) this;
        }

        public Criteria andCourse35NotIn(List<String> values) {
            addCriterion("course35 not in", values, "course35");
            return (Criteria) this;
        }

        public Criteria andCourse35Between(String value1, String value2) {
            addCriterion("course35 between", value1, value2, "course35");
            return (Criteria) this;
        }

        public Criteria andCourse35NotBetween(String value1, String value2) {
            addCriterion("course35 not between", value1, value2, "course35");
            return (Criteria) this;
        }

        public Criteria andCourse36IsNull() {
            addCriterion("course36 is null");
            return (Criteria) this;
        }

        public Criteria andCourse36IsNotNull() {
            addCriterion("course36 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse36EqualTo(String value) {
            addCriterion("course36 =", value, "course36");
            return (Criteria) this;
        }

        public Criteria andCourse36NotEqualTo(String value) {
            addCriterion("course36 <>", value, "course36");
            return (Criteria) this;
        }

        public Criteria andCourse36GreaterThan(String value) {
            addCriterion("course36 >", value, "course36");
            return (Criteria) this;
        }

        public Criteria andCourse36GreaterThanOrEqualTo(String value) {
            addCriterion("course36 >=", value, "course36");
            return (Criteria) this;
        }

        public Criteria andCourse36LessThan(String value) {
            addCriterion("course36 <", value, "course36");
            return (Criteria) this;
        }

        public Criteria andCourse36LessThanOrEqualTo(String value) {
            addCriterion("course36 <=", value, "course36");
            return (Criteria) this;
        }

        public Criteria andCourse36Like(String value) {
            addCriterion("course36 like", value, "course36");
            return (Criteria) this;
        }

        public Criteria andCourse36NotLike(String value) {
            addCriterion("course36 not like", value, "course36");
            return (Criteria) this;
        }

        public Criteria andCourse36In(List<String> values) {
            addCriterion("course36 in", values, "course36");
            return (Criteria) this;
        }

        public Criteria andCourse36NotIn(List<String> values) {
            addCriterion("course36 not in", values, "course36");
            return (Criteria) this;
        }

        public Criteria andCourse36Between(String value1, String value2) {
            addCriterion("course36 between", value1, value2, "course36");
            return (Criteria) this;
        }

        public Criteria andCourse36NotBetween(String value1, String value2) {
            addCriterion("course36 not between", value1, value2, "course36");
            return (Criteria) this;
        }

        public Criteria andCourse37IsNull() {
            addCriterion("course37 is null");
            return (Criteria) this;
        }

        public Criteria andCourse37IsNotNull() {
            addCriterion("course37 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse37EqualTo(String value) {
            addCriterion("course37 =", value, "course37");
            return (Criteria) this;
        }

        public Criteria andCourse37NotEqualTo(String value) {
            addCriterion("course37 <>", value, "course37");
            return (Criteria) this;
        }

        public Criteria andCourse37GreaterThan(String value) {
            addCriterion("course37 >", value, "course37");
            return (Criteria) this;
        }

        public Criteria andCourse37GreaterThanOrEqualTo(String value) {
            addCriterion("course37 >=", value, "course37");
            return (Criteria) this;
        }

        public Criteria andCourse37LessThan(String value) {
            addCriterion("course37 <", value, "course37");
            return (Criteria) this;
        }

        public Criteria andCourse37LessThanOrEqualTo(String value) {
            addCriterion("course37 <=", value, "course37");
            return (Criteria) this;
        }

        public Criteria andCourse37Like(String value) {
            addCriterion("course37 like", value, "course37");
            return (Criteria) this;
        }

        public Criteria andCourse37NotLike(String value) {
            addCriterion("course37 not like", value, "course37");
            return (Criteria) this;
        }

        public Criteria andCourse37In(List<String> values) {
            addCriterion("course37 in", values, "course37");
            return (Criteria) this;
        }

        public Criteria andCourse37NotIn(List<String> values) {
            addCriterion("course37 not in", values, "course37");
            return (Criteria) this;
        }

        public Criteria andCourse37Between(String value1, String value2) {
            addCriterion("course37 between", value1, value2, "course37");
            return (Criteria) this;
        }

        public Criteria andCourse37NotBetween(String value1, String value2) {
            addCriterion("course37 not between", value1, value2, "course37");
            return (Criteria) this;
        }

        public Criteria andCourse38IsNull() {
            addCriterion("course38 is null");
            return (Criteria) this;
        }

        public Criteria andCourse38IsNotNull() {
            addCriterion("course38 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse38EqualTo(String value) {
            addCriterion("course38 =", value, "course38");
            return (Criteria) this;
        }

        public Criteria andCourse38NotEqualTo(String value) {
            addCriterion("course38 <>", value, "course38");
            return (Criteria) this;
        }

        public Criteria andCourse38GreaterThan(String value) {
            addCriterion("course38 >", value, "course38");
            return (Criteria) this;
        }

        public Criteria andCourse38GreaterThanOrEqualTo(String value) {
            addCriterion("course38 >=", value, "course38");
            return (Criteria) this;
        }

        public Criteria andCourse38LessThan(String value) {
            addCriterion("course38 <", value, "course38");
            return (Criteria) this;
        }

        public Criteria andCourse38LessThanOrEqualTo(String value) {
            addCriterion("course38 <=", value, "course38");
            return (Criteria) this;
        }

        public Criteria andCourse38Like(String value) {
            addCriterion("course38 like", value, "course38");
            return (Criteria) this;
        }

        public Criteria andCourse38NotLike(String value) {
            addCriterion("course38 not like", value, "course38");
            return (Criteria) this;
        }

        public Criteria andCourse38In(List<String> values) {
            addCriterion("course38 in", values, "course38");
            return (Criteria) this;
        }

        public Criteria andCourse38NotIn(List<String> values) {
            addCriterion("course38 not in", values, "course38");
            return (Criteria) this;
        }

        public Criteria andCourse38Between(String value1, String value2) {
            addCriterion("course38 between", value1, value2, "course38");
            return (Criteria) this;
        }

        public Criteria andCourse38NotBetween(String value1, String value2) {
            addCriterion("course38 not between", value1, value2, "course38");
            return (Criteria) this;
        }

        public Criteria andCourse39IsNull() {
            addCriterion("course39 is null");
            return (Criteria) this;
        }

        public Criteria andCourse39IsNotNull() {
            addCriterion("course39 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse39EqualTo(String value) {
            addCriterion("course39 =", value, "course39");
            return (Criteria) this;
        }

        public Criteria andCourse39NotEqualTo(String value) {
            addCriterion("course39 <>", value, "course39");
            return (Criteria) this;
        }

        public Criteria andCourse39GreaterThan(String value) {
            addCriterion("course39 >", value, "course39");
            return (Criteria) this;
        }

        public Criteria andCourse39GreaterThanOrEqualTo(String value) {
            addCriterion("course39 >=", value, "course39");
            return (Criteria) this;
        }

        public Criteria andCourse39LessThan(String value) {
            addCriterion("course39 <", value, "course39");
            return (Criteria) this;
        }

        public Criteria andCourse39LessThanOrEqualTo(String value) {
            addCriterion("course39 <=", value, "course39");
            return (Criteria) this;
        }

        public Criteria andCourse39Like(String value) {
            addCriterion("course39 like", value, "course39");
            return (Criteria) this;
        }

        public Criteria andCourse39NotLike(String value) {
            addCriterion("course39 not like", value, "course39");
            return (Criteria) this;
        }

        public Criteria andCourse39In(List<String> values) {
            addCriterion("course39 in", values, "course39");
            return (Criteria) this;
        }

        public Criteria andCourse39NotIn(List<String> values) {
            addCriterion("course39 not in", values, "course39");
            return (Criteria) this;
        }

        public Criteria andCourse39Between(String value1, String value2) {
            addCriterion("course39 between", value1, value2, "course39");
            return (Criteria) this;
        }

        public Criteria andCourse39NotBetween(String value1, String value2) {
            addCriterion("course39 not between", value1, value2, "course39");
            return (Criteria) this;
        }

        public Criteria andCourse40IsNull() {
            addCriterion("course40 is null");
            return (Criteria) this;
        }

        public Criteria andCourse40IsNotNull() {
            addCriterion("course40 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse40EqualTo(String value) {
            addCriterion("course40 =", value, "course40");
            return (Criteria) this;
        }

        public Criteria andCourse40NotEqualTo(String value) {
            addCriterion("course40 <>", value, "course40");
            return (Criteria) this;
        }

        public Criteria andCourse40GreaterThan(String value) {
            addCriterion("course40 >", value, "course40");
            return (Criteria) this;
        }

        public Criteria andCourse40GreaterThanOrEqualTo(String value) {
            addCriterion("course40 >=", value, "course40");
            return (Criteria) this;
        }

        public Criteria andCourse40LessThan(String value) {
            addCriterion("course40 <", value, "course40");
            return (Criteria) this;
        }

        public Criteria andCourse40LessThanOrEqualTo(String value) {
            addCriterion("course40 <=", value, "course40");
            return (Criteria) this;
        }

        public Criteria andCourse40Like(String value) {
            addCriterion("course40 like", value, "course40");
            return (Criteria) this;
        }

        public Criteria andCourse40NotLike(String value) {
            addCriterion("course40 not like", value, "course40");
            return (Criteria) this;
        }

        public Criteria andCourse40In(List<String> values) {
            addCriterion("course40 in", values, "course40");
            return (Criteria) this;
        }

        public Criteria andCourse40NotIn(List<String> values) {
            addCriterion("course40 not in", values, "course40");
            return (Criteria) this;
        }

        public Criteria andCourse40Between(String value1, String value2) {
            addCriterion("course40 between", value1, value2, "course40");
            return (Criteria) this;
        }

        public Criteria andCourse40NotBetween(String value1, String value2) {
            addCriterion("course40 not between", value1, value2, "course40");
            return (Criteria) this;
        }

        public Criteria andCourse41IsNull() {
            addCriterion("course41 is null");
            return (Criteria) this;
        }

        public Criteria andCourse41IsNotNull() {
            addCriterion("course41 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse41EqualTo(String value) {
            addCriterion("course41 =", value, "course41");
            return (Criteria) this;
        }

        public Criteria andCourse41NotEqualTo(String value) {
            addCriterion("course41 <>", value, "course41");
            return (Criteria) this;
        }

        public Criteria andCourse41GreaterThan(String value) {
            addCriterion("course41 >", value, "course41");
            return (Criteria) this;
        }

        public Criteria andCourse41GreaterThanOrEqualTo(String value) {
            addCriterion("course41 >=", value, "course41");
            return (Criteria) this;
        }

        public Criteria andCourse41LessThan(String value) {
            addCriterion("course41 <", value, "course41");
            return (Criteria) this;
        }

        public Criteria andCourse41LessThanOrEqualTo(String value) {
            addCriterion("course41 <=", value, "course41");
            return (Criteria) this;
        }

        public Criteria andCourse41Like(String value) {
            addCriterion("course41 like", value, "course41");
            return (Criteria) this;
        }

        public Criteria andCourse41NotLike(String value) {
            addCriterion("course41 not like", value, "course41");
            return (Criteria) this;
        }

        public Criteria andCourse41In(List<String> values) {
            addCriterion("course41 in", values, "course41");
            return (Criteria) this;
        }

        public Criteria andCourse41NotIn(List<String> values) {
            addCriterion("course41 not in", values, "course41");
            return (Criteria) this;
        }

        public Criteria andCourse41Between(String value1, String value2) {
            addCriterion("course41 between", value1, value2, "course41");
            return (Criteria) this;
        }

        public Criteria andCourse41NotBetween(String value1, String value2) {
            addCriterion("course41 not between", value1, value2, "course41");
            return (Criteria) this;
        }

        public Criteria andCourse42IsNull() {
            addCriterion("course42 is null");
            return (Criteria) this;
        }

        public Criteria andCourse42IsNotNull() {
            addCriterion("course42 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse42EqualTo(String value) {
            addCriterion("course42 =", value, "course42");
            return (Criteria) this;
        }

        public Criteria andCourse42NotEqualTo(String value) {
            addCriterion("course42 <>", value, "course42");
            return (Criteria) this;
        }

        public Criteria andCourse42GreaterThan(String value) {
            addCriterion("course42 >", value, "course42");
            return (Criteria) this;
        }

        public Criteria andCourse42GreaterThanOrEqualTo(String value) {
            addCriterion("course42 >=", value, "course42");
            return (Criteria) this;
        }

        public Criteria andCourse42LessThan(String value) {
            addCriterion("course42 <", value, "course42");
            return (Criteria) this;
        }

        public Criteria andCourse42LessThanOrEqualTo(String value) {
            addCriterion("course42 <=", value, "course42");
            return (Criteria) this;
        }

        public Criteria andCourse42Like(String value) {
            addCriterion("course42 like", value, "course42");
            return (Criteria) this;
        }

        public Criteria andCourse42NotLike(String value) {
            addCriterion("course42 not like", value, "course42");
            return (Criteria) this;
        }

        public Criteria andCourse42In(List<String> values) {
            addCriterion("course42 in", values, "course42");
            return (Criteria) this;
        }

        public Criteria andCourse42NotIn(List<String> values) {
            addCriterion("course42 not in", values, "course42");
            return (Criteria) this;
        }

        public Criteria andCourse42Between(String value1, String value2) {
            addCriterion("course42 between", value1, value2, "course42");
            return (Criteria) this;
        }

        public Criteria andCourse42NotBetween(String value1, String value2) {
            addCriterion("course42 not between", value1, value2, "course42");
            return (Criteria) this;
        }

        public Criteria andCourse43IsNull() {
            addCriterion("course43 is null");
            return (Criteria) this;
        }

        public Criteria andCourse43IsNotNull() {
            addCriterion("course43 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse43EqualTo(String value) {
            addCriterion("course43 =", value, "course43");
            return (Criteria) this;
        }

        public Criteria andCourse43NotEqualTo(String value) {
            addCriterion("course43 <>", value, "course43");
            return (Criteria) this;
        }

        public Criteria andCourse43GreaterThan(String value) {
            addCriterion("course43 >", value, "course43");
            return (Criteria) this;
        }

        public Criteria andCourse43GreaterThanOrEqualTo(String value) {
            addCriterion("course43 >=", value, "course43");
            return (Criteria) this;
        }

        public Criteria andCourse43LessThan(String value) {
            addCriterion("course43 <", value, "course43");
            return (Criteria) this;
        }

        public Criteria andCourse43LessThanOrEqualTo(String value) {
            addCriterion("course43 <=", value, "course43");
            return (Criteria) this;
        }

        public Criteria andCourse43Like(String value) {
            addCriterion("course43 like", value, "course43");
            return (Criteria) this;
        }

        public Criteria andCourse43NotLike(String value) {
            addCriterion("course43 not like", value, "course43");
            return (Criteria) this;
        }

        public Criteria andCourse43In(List<String> values) {
            addCriterion("course43 in", values, "course43");
            return (Criteria) this;
        }

        public Criteria andCourse43NotIn(List<String> values) {
            addCriterion("course43 not in", values, "course43");
            return (Criteria) this;
        }

        public Criteria andCourse43Between(String value1, String value2) {
            addCriterion("course43 between", value1, value2, "course43");
            return (Criteria) this;
        }

        public Criteria andCourse43NotBetween(String value1, String value2) {
            addCriterion("course43 not between", value1, value2, "course43");
            return (Criteria) this;
        }

        public Criteria andCourse44IsNull() {
            addCriterion("course44 is null");
            return (Criteria) this;
        }

        public Criteria andCourse44IsNotNull() {
            addCriterion("course44 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse44EqualTo(String value) {
            addCriterion("course44 =", value, "course44");
            return (Criteria) this;
        }

        public Criteria andCourse44NotEqualTo(String value) {
            addCriterion("course44 <>", value, "course44");
            return (Criteria) this;
        }

        public Criteria andCourse44GreaterThan(String value) {
            addCriterion("course44 >", value, "course44");
            return (Criteria) this;
        }

        public Criteria andCourse44GreaterThanOrEqualTo(String value) {
            addCriterion("course44 >=", value, "course44");
            return (Criteria) this;
        }

        public Criteria andCourse44LessThan(String value) {
            addCriterion("course44 <", value, "course44");
            return (Criteria) this;
        }

        public Criteria andCourse44LessThanOrEqualTo(String value) {
            addCriterion("course44 <=", value, "course44");
            return (Criteria) this;
        }

        public Criteria andCourse44Like(String value) {
            addCriterion("course44 like", value, "course44");
            return (Criteria) this;
        }

        public Criteria andCourse44NotLike(String value) {
            addCriterion("course44 not like", value, "course44");
            return (Criteria) this;
        }

        public Criteria andCourse44In(List<String> values) {
            addCriterion("course44 in", values, "course44");
            return (Criteria) this;
        }

        public Criteria andCourse44NotIn(List<String> values) {
            addCriterion("course44 not in", values, "course44");
            return (Criteria) this;
        }

        public Criteria andCourse44Between(String value1, String value2) {
            addCriterion("course44 between", value1, value2, "course44");
            return (Criteria) this;
        }

        public Criteria andCourse44NotBetween(String value1, String value2) {
            addCriterion("course44 not between", value1, value2, "course44");
            return (Criteria) this;
        }

        public Criteria andCourse45IsNull() {
            addCriterion("course45 is null");
            return (Criteria) this;
        }

        public Criteria andCourse45IsNotNull() {
            addCriterion("course45 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse45EqualTo(String value) {
            addCriterion("course45 =", value, "course45");
            return (Criteria) this;
        }

        public Criteria andCourse45NotEqualTo(String value) {
            addCriterion("course45 <>", value, "course45");
            return (Criteria) this;
        }

        public Criteria andCourse45GreaterThan(String value) {
            addCriterion("course45 >", value, "course45");
            return (Criteria) this;
        }

        public Criteria andCourse45GreaterThanOrEqualTo(String value) {
            addCriterion("course45 >=", value, "course45");
            return (Criteria) this;
        }

        public Criteria andCourse45LessThan(String value) {
            addCriterion("course45 <", value, "course45");
            return (Criteria) this;
        }

        public Criteria andCourse45LessThanOrEqualTo(String value) {
            addCriterion("course45 <=", value, "course45");
            return (Criteria) this;
        }

        public Criteria andCourse45Like(String value) {
            addCriterion("course45 like", value, "course45");
            return (Criteria) this;
        }

        public Criteria andCourse45NotLike(String value) {
            addCriterion("course45 not like", value, "course45");
            return (Criteria) this;
        }

        public Criteria andCourse45In(List<String> values) {
            addCriterion("course45 in", values, "course45");
            return (Criteria) this;
        }

        public Criteria andCourse45NotIn(List<String> values) {
            addCriterion("course45 not in", values, "course45");
            return (Criteria) this;
        }

        public Criteria andCourse45Between(String value1, String value2) {
            addCriterion("course45 between", value1, value2, "course45");
            return (Criteria) this;
        }

        public Criteria andCourse45NotBetween(String value1, String value2) {
            addCriterion("course45 not between", value1, value2, "course45");
            return (Criteria) this;
        }

        public Criteria andCourse46IsNull() {
            addCriterion("course46 is null");
            return (Criteria) this;
        }

        public Criteria andCourse46IsNotNull() {
            addCriterion("course46 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse46EqualTo(String value) {
            addCriterion("course46 =", value, "course46");
            return (Criteria) this;
        }

        public Criteria andCourse46NotEqualTo(String value) {
            addCriterion("course46 <>", value, "course46");
            return (Criteria) this;
        }

        public Criteria andCourse46GreaterThan(String value) {
            addCriterion("course46 >", value, "course46");
            return (Criteria) this;
        }

        public Criteria andCourse46GreaterThanOrEqualTo(String value) {
            addCriterion("course46 >=", value, "course46");
            return (Criteria) this;
        }

        public Criteria andCourse46LessThan(String value) {
            addCriterion("course46 <", value, "course46");
            return (Criteria) this;
        }

        public Criteria andCourse46LessThanOrEqualTo(String value) {
            addCriterion("course46 <=", value, "course46");
            return (Criteria) this;
        }

        public Criteria andCourse46Like(String value) {
            addCriterion("course46 like", value, "course46");
            return (Criteria) this;
        }

        public Criteria andCourse46NotLike(String value) {
            addCriterion("course46 not like", value, "course46");
            return (Criteria) this;
        }

        public Criteria andCourse46In(List<String> values) {
            addCriterion("course46 in", values, "course46");
            return (Criteria) this;
        }

        public Criteria andCourse46NotIn(List<String> values) {
            addCriterion("course46 not in", values, "course46");
            return (Criteria) this;
        }

        public Criteria andCourse46Between(String value1, String value2) {
            addCriterion("course46 between", value1, value2, "course46");
            return (Criteria) this;
        }

        public Criteria andCourse46NotBetween(String value1, String value2) {
            addCriterion("course46 not between", value1, value2, "course46");
            return (Criteria) this;
        }

        public Criteria andCourse47IsNull() {
            addCriterion("course47 is null");
            return (Criteria) this;
        }

        public Criteria andCourse47IsNotNull() {
            addCriterion("course47 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse47EqualTo(String value) {
            addCriterion("course47 =", value, "course47");
            return (Criteria) this;
        }

        public Criteria andCourse47NotEqualTo(String value) {
            addCriterion("course47 <>", value, "course47");
            return (Criteria) this;
        }

        public Criteria andCourse47GreaterThan(String value) {
            addCriterion("course47 >", value, "course47");
            return (Criteria) this;
        }

        public Criteria andCourse47GreaterThanOrEqualTo(String value) {
            addCriterion("course47 >=", value, "course47");
            return (Criteria) this;
        }

        public Criteria andCourse47LessThan(String value) {
            addCriterion("course47 <", value, "course47");
            return (Criteria) this;
        }

        public Criteria andCourse47LessThanOrEqualTo(String value) {
            addCriterion("course47 <=", value, "course47");
            return (Criteria) this;
        }

        public Criteria andCourse47Like(String value) {
            addCriterion("course47 like", value, "course47");
            return (Criteria) this;
        }

        public Criteria andCourse47NotLike(String value) {
            addCriterion("course47 not like", value, "course47");
            return (Criteria) this;
        }

        public Criteria andCourse47In(List<String> values) {
            addCriterion("course47 in", values, "course47");
            return (Criteria) this;
        }

        public Criteria andCourse47NotIn(List<String> values) {
            addCriterion("course47 not in", values, "course47");
            return (Criteria) this;
        }

        public Criteria andCourse47Between(String value1, String value2) {
            addCriterion("course47 between", value1, value2, "course47");
            return (Criteria) this;
        }

        public Criteria andCourse47NotBetween(String value1, String value2) {
            addCriterion("course47 not between", value1, value2, "course47");
            return (Criteria) this;
        }

        public Criteria andCourse48IsNull() {
            addCriterion("course48 is null");
            return (Criteria) this;
        }

        public Criteria andCourse48IsNotNull() {
            addCriterion("course48 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse48EqualTo(String value) {
            addCriterion("course48 =", value, "course48");
            return (Criteria) this;
        }

        public Criteria andCourse48NotEqualTo(String value) {
            addCriterion("course48 <>", value, "course48");
            return (Criteria) this;
        }

        public Criteria andCourse48GreaterThan(String value) {
            addCriterion("course48 >", value, "course48");
            return (Criteria) this;
        }

        public Criteria andCourse48GreaterThanOrEqualTo(String value) {
            addCriterion("course48 >=", value, "course48");
            return (Criteria) this;
        }

        public Criteria andCourse48LessThan(String value) {
            addCriterion("course48 <", value, "course48");
            return (Criteria) this;
        }

        public Criteria andCourse48LessThanOrEqualTo(String value) {
            addCriterion("course48 <=", value, "course48");
            return (Criteria) this;
        }

        public Criteria andCourse48Like(String value) {
            addCriterion("course48 like", value, "course48");
            return (Criteria) this;
        }

        public Criteria andCourse48NotLike(String value) {
            addCriterion("course48 not like", value, "course48");
            return (Criteria) this;
        }

        public Criteria andCourse48In(List<String> values) {
            addCriterion("course48 in", values, "course48");
            return (Criteria) this;
        }

        public Criteria andCourse48NotIn(List<String> values) {
            addCriterion("course48 not in", values, "course48");
            return (Criteria) this;
        }

        public Criteria andCourse48Between(String value1, String value2) {
            addCriterion("course48 between", value1, value2, "course48");
            return (Criteria) this;
        }

        public Criteria andCourse48NotBetween(String value1, String value2) {
            addCriterion("course48 not between", value1, value2, "course48");
            return (Criteria) this;
        }

        public Criteria andCourse49IsNull() {
            addCriterion("course49 is null");
            return (Criteria) this;
        }

        public Criteria andCourse49IsNotNull() {
            addCriterion("course49 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse49EqualTo(String value) {
            addCriterion("course49 =", value, "course49");
            return (Criteria) this;
        }

        public Criteria andCourse49NotEqualTo(String value) {
            addCriterion("course49 <>", value, "course49");
            return (Criteria) this;
        }

        public Criteria andCourse49GreaterThan(String value) {
            addCriterion("course49 >", value, "course49");
            return (Criteria) this;
        }

        public Criteria andCourse49GreaterThanOrEqualTo(String value) {
            addCriterion("course49 >=", value, "course49");
            return (Criteria) this;
        }

        public Criteria andCourse49LessThan(String value) {
            addCriterion("course49 <", value, "course49");
            return (Criteria) this;
        }

        public Criteria andCourse49LessThanOrEqualTo(String value) {
            addCriterion("course49 <=", value, "course49");
            return (Criteria) this;
        }

        public Criteria andCourse49Like(String value) {
            addCriterion("course49 like", value, "course49");
            return (Criteria) this;
        }

        public Criteria andCourse49NotLike(String value) {
            addCriterion("course49 not like", value, "course49");
            return (Criteria) this;
        }

        public Criteria andCourse49In(List<String> values) {
            addCriterion("course49 in", values, "course49");
            return (Criteria) this;
        }

        public Criteria andCourse49NotIn(List<String> values) {
            addCriterion("course49 not in", values, "course49");
            return (Criteria) this;
        }

        public Criteria andCourse49Between(String value1, String value2) {
            addCriterion("course49 between", value1, value2, "course49");
            return (Criteria) this;
        }

        public Criteria andCourse49NotBetween(String value1, String value2) {
            addCriterion("course49 not between", value1, value2, "course49");
            return (Criteria) this;
        }

        public Criteria andCourse50IsNull() {
            addCriterion("course50 is null");
            return (Criteria) this;
        }

        public Criteria andCourse50IsNotNull() {
            addCriterion("course50 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse50EqualTo(String value) {
            addCriterion("course50 =", value, "course50");
            return (Criteria) this;
        }

        public Criteria andCourse50NotEqualTo(String value) {
            addCriterion("course50 <>", value, "course50");
            return (Criteria) this;
        }

        public Criteria andCourse50GreaterThan(String value) {
            addCriterion("course50 >", value, "course50");
            return (Criteria) this;
        }

        public Criteria andCourse50GreaterThanOrEqualTo(String value) {
            addCriterion("course50 >=", value, "course50");
            return (Criteria) this;
        }

        public Criteria andCourse50LessThan(String value) {
            addCriterion("course50 <", value, "course50");
            return (Criteria) this;
        }

        public Criteria andCourse50LessThanOrEqualTo(String value) {
            addCriterion("course50 <=", value, "course50");
            return (Criteria) this;
        }

        public Criteria andCourse50Like(String value) {
            addCriterion("course50 like", value, "course50");
            return (Criteria) this;
        }

        public Criteria andCourse50NotLike(String value) {
            addCriterion("course50 not like", value, "course50");
            return (Criteria) this;
        }

        public Criteria andCourse50In(List<String> values) {
            addCriterion("course50 in", values, "course50");
            return (Criteria) this;
        }

        public Criteria andCourse50NotIn(List<String> values) {
            addCriterion("course50 not in", values, "course50");
            return (Criteria) this;
        }

        public Criteria andCourse50Between(String value1, String value2) {
            addCriterion("course50 between", value1, value2, "course50");
            return (Criteria) this;
        }

        public Criteria andCourse50NotBetween(String value1, String value2) {
            addCriterion("course50 not between", value1, value2, "course50");
            return (Criteria) this;
        }

        public Criteria andCourse51IsNull() {
            addCriterion("course51 is null");
            return (Criteria) this;
        }

        public Criteria andCourse51IsNotNull() {
            addCriterion("course51 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse51EqualTo(String value) {
            addCriterion("course51 =", value, "course51");
            return (Criteria) this;
        }

        public Criteria andCourse51NotEqualTo(String value) {
            addCriterion("course51 <>", value, "course51");
            return (Criteria) this;
        }

        public Criteria andCourse51GreaterThan(String value) {
            addCriterion("course51 >", value, "course51");
            return (Criteria) this;
        }

        public Criteria andCourse51GreaterThanOrEqualTo(String value) {
            addCriterion("course51 >=", value, "course51");
            return (Criteria) this;
        }

        public Criteria andCourse51LessThan(String value) {
            addCriterion("course51 <", value, "course51");
            return (Criteria) this;
        }

        public Criteria andCourse51LessThanOrEqualTo(String value) {
            addCriterion("course51 <=", value, "course51");
            return (Criteria) this;
        }

        public Criteria andCourse51Like(String value) {
            addCriterion("course51 like", value, "course51");
            return (Criteria) this;
        }

        public Criteria andCourse51NotLike(String value) {
            addCriterion("course51 not like", value, "course51");
            return (Criteria) this;
        }

        public Criteria andCourse51In(List<String> values) {
            addCriterion("course51 in", values, "course51");
            return (Criteria) this;
        }

        public Criteria andCourse51NotIn(List<String> values) {
            addCriterion("course51 not in", values, "course51");
            return (Criteria) this;
        }

        public Criteria andCourse51Between(String value1, String value2) {
            addCriterion("course51 between", value1, value2, "course51");
            return (Criteria) this;
        }

        public Criteria andCourse51NotBetween(String value1, String value2) {
            addCriterion("course51 not between", value1, value2, "course51");
            return (Criteria) this;
        }

        public Criteria andCourse52IsNull() {
            addCriterion("course52 is null");
            return (Criteria) this;
        }

        public Criteria andCourse52IsNotNull() {
            addCriterion("course52 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse52EqualTo(String value) {
            addCriterion("course52 =", value, "course52");
            return (Criteria) this;
        }

        public Criteria andCourse52NotEqualTo(String value) {
            addCriterion("course52 <>", value, "course52");
            return (Criteria) this;
        }

        public Criteria andCourse52GreaterThan(String value) {
            addCriterion("course52 >", value, "course52");
            return (Criteria) this;
        }

        public Criteria andCourse52GreaterThanOrEqualTo(String value) {
            addCriterion("course52 >=", value, "course52");
            return (Criteria) this;
        }

        public Criteria andCourse52LessThan(String value) {
            addCriterion("course52 <", value, "course52");
            return (Criteria) this;
        }

        public Criteria andCourse52LessThanOrEqualTo(String value) {
            addCriterion("course52 <=", value, "course52");
            return (Criteria) this;
        }

        public Criteria andCourse52Like(String value) {
            addCriterion("course52 like", value, "course52");
            return (Criteria) this;
        }

        public Criteria andCourse52NotLike(String value) {
            addCriterion("course52 not like", value, "course52");
            return (Criteria) this;
        }

        public Criteria andCourse52In(List<String> values) {
            addCriterion("course52 in", values, "course52");
            return (Criteria) this;
        }

        public Criteria andCourse52NotIn(List<String> values) {
            addCriterion("course52 not in", values, "course52");
            return (Criteria) this;
        }

        public Criteria andCourse52Between(String value1, String value2) {
            addCriterion("course52 between", value1, value2, "course52");
            return (Criteria) this;
        }

        public Criteria andCourse52NotBetween(String value1, String value2) {
            addCriterion("course52 not between", value1, value2, "course52");
            return (Criteria) this;
        }

        public Criteria andCourse53IsNull() {
            addCriterion("course53 is null");
            return (Criteria) this;
        }

        public Criteria andCourse53IsNotNull() {
            addCriterion("course53 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse53EqualTo(String value) {
            addCriterion("course53 =", value, "course53");
            return (Criteria) this;
        }

        public Criteria andCourse53NotEqualTo(String value) {
            addCriterion("course53 <>", value, "course53");
            return (Criteria) this;
        }

        public Criteria andCourse53GreaterThan(String value) {
            addCriterion("course53 >", value, "course53");
            return (Criteria) this;
        }

        public Criteria andCourse53GreaterThanOrEqualTo(String value) {
            addCriterion("course53 >=", value, "course53");
            return (Criteria) this;
        }

        public Criteria andCourse53LessThan(String value) {
            addCriterion("course53 <", value, "course53");
            return (Criteria) this;
        }

        public Criteria andCourse53LessThanOrEqualTo(String value) {
            addCriterion("course53 <=", value, "course53");
            return (Criteria) this;
        }

        public Criteria andCourse53Like(String value) {
            addCriterion("course53 like", value, "course53");
            return (Criteria) this;
        }

        public Criteria andCourse53NotLike(String value) {
            addCriterion("course53 not like", value, "course53");
            return (Criteria) this;
        }

        public Criteria andCourse53In(List<String> values) {
            addCriterion("course53 in", values, "course53");
            return (Criteria) this;
        }

        public Criteria andCourse53NotIn(List<String> values) {
            addCriterion("course53 not in", values, "course53");
            return (Criteria) this;
        }

        public Criteria andCourse53Between(String value1, String value2) {
            addCriterion("course53 between", value1, value2, "course53");
            return (Criteria) this;
        }

        public Criteria andCourse53NotBetween(String value1, String value2) {
            addCriterion("course53 not between", value1, value2, "course53");
            return (Criteria) this;
        }

        public Criteria andCourse54IsNull() {
            addCriterion("course54 is null");
            return (Criteria) this;
        }

        public Criteria andCourse54IsNotNull() {
            addCriterion("course54 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse54EqualTo(String value) {
            addCriterion("course54 =", value, "course54");
            return (Criteria) this;
        }

        public Criteria andCourse54NotEqualTo(String value) {
            addCriterion("course54 <>", value, "course54");
            return (Criteria) this;
        }

        public Criteria andCourse54GreaterThan(String value) {
            addCriterion("course54 >", value, "course54");
            return (Criteria) this;
        }

        public Criteria andCourse54GreaterThanOrEqualTo(String value) {
            addCriterion("course54 >=", value, "course54");
            return (Criteria) this;
        }

        public Criteria andCourse54LessThan(String value) {
            addCriterion("course54 <", value, "course54");
            return (Criteria) this;
        }

        public Criteria andCourse54LessThanOrEqualTo(String value) {
            addCriterion("course54 <=", value, "course54");
            return (Criteria) this;
        }

        public Criteria andCourse54Like(String value) {
            addCriterion("course54 like", value, "course54");
            return (Criteria) this;
        }

        public Criteria andCourse54NotLike(String value) {
            addCriterion("course54 not like", value, "course54");
            return (Criteria) this;
        }

        public Criteria andCourse54In(List<String> values) {
            addCriterion("course54 in", values, "course54");
            return (Criteria) this;
        }

        public Criteria andCourse54NotIn(List<String> values) {
            addCriterion("course54 not in", values, "course54");
            return (Criteria) this;
        }

        public Criteria andCourse54Between(String value1, String value2) {
            addCriterion("course54 between", value1, value2, "course54");
            return (Criteria) this;
        }

        public Criteria andCourse54NotBetween(String value1, String value2) {
            addCriterion("course54 not between", value1, value2, "course54");
            return (Criteria) this;
        }

        public Criteria andCourse55IsNull() {
            addCriterion("course55 is null");
            return (Criteria) this;
        }

        public Criteria andCourse55IsNotNull() {
            addCriterion("course55 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse55EqualTo(String value) {
            addCriterion("course55 =", value, "course55");
            return (Criteria) this;
        }

        public Criteria andCourse55NotEqualTo(String value) {
            addCriterion("course55 <>", value, "course55");
            return (Criteria) this;
        }

        public Criteria andCourse55GreaterThan(String value) {
            addCriterion("course55 >", value, "course55");
            return (Criteria) this;
        }

        public Criteria andCourse55GreaterThanOrEqualTo(String value) {
            addCriterion("course55 >=", value, "course55");
            return (Criteria) this;
        }

        public Criteria andCourse55LessThan(String value) {
            addCriterion("course55 <", value, "course55");
            return (Criteria) this;
        }

        public Criteria andCourse55LessThanOrEqualTo(String value) {
            addCriterion("course55 <=", value, "course55");
            return (Criteria) this;
        }

        public Criteria andCourse55Like(String value) {
            addCriterion("course55 like", value, "course55");
            return (Criteria) this;
        }

        public Criteria andCourse55NotLike(String value) {
            addCriterion("course55 not like", value, "course55");
            return (Criteria) this;
        }

        public Criteria andCourse55In(List<String> values) {
            addCriterion("course55 in", values, "course55");
            return (Criteria) this;
        }

        public Criteria andCourse55NotIn(List<String> values) {
            addCriterion("course55 not in", values, "course55");
            return (Criteria) this;
        }

        public Criteria andCourse55Between(String value1, String value2) {
            addCriterion("course55 between", value1, value2, "course55");
            return (Criteria) this;
        }

        public Criteria andCourse55NotBetween(String value1, String value2) {
            addCriterion("course55 not between", value1, value2, "course55");
            return (Criteria) this;
        }

        public Criteria andCourse56IsNull() {
            addCriterion("course56 is null");
            return (Criteria) this;
        }

        public Criteria andCourse56IsNotNull() {
            addCriterion("course56 is not null");
            return (Criteria) this;
        }

        public Criteria andCourse56EqualTo(String value) {
            addCriterion("course56 =", value, "course56");
            return (Criteria) this;
        }

        public Criteria andCourse56NotEqualTo(String value) {
            addCriterion("course56 <>", value, "course56");
            return (Criteria) this;
        }

        public Criteria andCourse56GreaterThan(String value) {
            addCriterion("course56 >", value, "course56");
            return (Criteria) this;
        }

        public Criteria andCourse56GreaterThanOrEqualTo(String value) {
            addCriterion("course56 >=", value, "course56");
            return (Criteria) this;
        }

        public Criteria andCourse56LessThan(String value) {
            addCriterion("course56 <", value, "course56");
            return (Criteria) this;
        }

        public Criteria andCourse56LessThanOrEqualTo(String value) {
            addCriterion("course56 <=", value, "course56");
            return (Criteria) this;
        }

        public Criteria andCourse56Like(String value) {
            addCriterion("course56 like", value, "course56");
            return (Criteria) this;
        }

        public Criteria andCourse56NotLike(String value) {
            addCriterion("course56 not like", value, "course56");
            return (Criteria) this;
        }

        public Criteria andCourse56In(List<String> values) {
            addCriterion("course56 in", values, "course56");
            return (Criteria) this;
        }

        public Criteria andCourse56NotIn(List<String> values) {
            addCriterion("course56 not in", values, "course56");
            return (Criteria) this;
        }

        public Criteria andCourse56Between(String value1, String value2) {
            addCriterion("course56 between", value1, value2, "course56");
            return (Criteria) this;
        }

        public Criteria andCourse56NotBetween(String value1, String value2) {
            addCriterion("course56 not between", value1, value2, "course56");
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