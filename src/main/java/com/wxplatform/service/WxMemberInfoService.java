package com.wxplatform.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.wxplatform.dao.WxCourseInfoDAO;
import com.wxplatform.dao.WxDateTripDAO;
import com.wxplatform.dao.WxDutyInfoDAO;
import com.wxplatform.dao.WxMemberDAO;
import com.wxplatform.pojo.GroupMember;
import common.exceptions.FailException;
import common.exceptions.ForbidException;
import common.exceptions.NullException;

import common.getlogin.GetSource;
import common.redis.JedisTemplate;
import common.utils.otherUtils.RedisPageHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jca.context.SpringContextResourceAdapter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static common.utils.FailCheckUtils.*;
import static common.utils.NotNullCheckUtils.ListNotExist;
import static common.utils.NotNullCheckUtils.NotNull;
import static common.utils.NotNullCheckUtils.NotNullInt;


@Service
public class WxMemberInfoService {

    @Autowired
    private WxMemberDAO wxMemberDAO;
    @Autowired
    private WxDateTripDAO dateTripDAO;
    @Autowired
    private WxDutyInfoDAO dutyInfoDAO;
    @Autowired
    private WxCourseInfoDAO wxCourseInfoDAO;

    @Autowired
    private JedisTemplate jedisTemplate;

    @Autowired
    private RedisPageHelper redisPageHelper;

    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();


    JSON json = new JSONObject();


    @Autowired
    ConcurrentSkipListMap<String, Object> concurrentSkipListMap;

    @Value("${loginrediret.url}")
    String loginUrl;

    /*
       * @Description: 进行授权登录的认证
       * 判断是否已经授权， 使用UserNamePasswordToken将用户名和密码进行分装，进行login的执行
       * 由shiro框架帮我们完成密码的配对 在自定义realm中进行 并返回SimpleAuthenticationInfo 对象
       * @Param: [memberid, password]
       * @return: java.util.concurrent.ConcurrentSkipListMap
       * @Author:  zhijie
       * @Date: 2019/2/10
       */
    public Map login(String memberid, String password) {
        Map map = new HashMap();
        //创建当前访问路径的主体
        Subject subject = SecurityUtils.getSubject();
        //判断是否已经进行认证
        // if (subject.isAuthenticated() == false) {}
        //将用户名和密码封装成UserNamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(memberid, password);
        subject.login(token);
        String sessionId = (String) subject.getSession().getId();
//        //保存用户ID， 访问的sessionId
//        jedisTemplate.hset("kickoutlogin", sessionId, memberid);
//        //保存请求的sessionId， 设置为true
//        jedisTemplate.hset("kickoutSessionId", sessionId, "true");
//        //设置过期时间
//        jedisTemplate.expire("kickoutlogin", 30 * 60);
//        jedisTemplate.expire("kickoutSessionId", 30 * 60);
//
//        //获取redis中所有保存用户的ID和sessionId
//        Map<String, String> jedisMap = jedisTemplate.hgetAll("kickoutlogin");
//        //如果大于1，代表有二次登陆
//        if (jedisMap.size() > 1) {
//            for (Map.Entry<String, String> entry : jedisMap.entrySet()) {
//                String jsessionId = entry.getKey(); //获取到key sessionId
//                String jmemberId = entry.getValue();//获取到value  memberId
//                String kickoutSessionIdStatus = jedisTemplate.hget("kickoutSessionId", jsessionId);   //获取请求表示 jessionId的value
//                logger.info(kickoutSessionIdStatus);
//                if(!kickoutSessionIdStatus.equals("false")) {
//                    //登陆获取的sessionid和缓存中sessionId不同
//                    // 登陆获取的memberid和缓存中memberid相同
//                    if(!sessionId.equals(jsessionId) && memberid.equals(jmemberId)) {
//                        //一个账号在不同的地方登陆，需要提出
//                        jedisTemplate.hset("kickoutSessionId", jsessionId, "false");
//                        jedisTemplate.set(memberid + ":ks", jsessionId);
//                    }
//                }
//            }
//        }
        GroupMember memberInfo = wxMemberDAO.login(memberid);
        map.put("memberid", memberInfo.getMemberid());
        map.put("membername", memberInfo.getMembername());
        map.put("politicalstatusname", memberInfo.getPoliticalstatusname());
        map.put("tissusname", memberInfo.getTissusname());
        map.put("departmentname", memberInfo.getDepartmentname());
        map.put("departpositionname", memberInfo.getDepartmentpositionname());
        map.put("membername", memberInfo.getMembername());
        map.put("telnumber", memberInfo.getTelnumber());
        return map;
    }

    /*
            * @Description:  分页浏览所有信息
            * @Param: [currentPage]
            * @return: com.github.pagehelper.PageInfo<com.wxplatform.pojo.GroupMember>
            * @Author:  zhijie
            * @Date: 2019/2/8
            */
    @Transactional(readOnly = true)
    public Map<String, Object> getMemberList(Integer currentPage) {
        Map map = new HashMap();
        PageHelper.startPage(currentPage, 10);
        List<GroupMember> memberinfo = wxMemberDAO.selectMemberListWithPage();
        ListNotExist(memberinfo, "memberlist.is.null");
        PageInfo<GroupMember> groupMemberPageInfo = new PageInfo<GroupMember>(memberinfo);
        map.put("pageNum", groupMemberPageInfo.getPageNum());
        map.put("pageSize", groupMemberPageInfo.getPageSize());
        map.put("pageTotal", groupMemberPageInfo.getPages());
        map.put("dataTotal", groupMemberPageInfo.getTotal());
        map.put("list", groupMemberPageInfo.getList());
        map.put("hasNextPage", groupMemberPageInfo.isHasNextPage());
        map.put("hasPrePage", groupMemberPageInfo.isHasPreviousPage());
        map.put("isFirstPage", groupMemberPageInfo.isIsFirstPage());
        map.put("isLastPage", groupMemberPageInfo.isIsLastPage());
        map.put("firstpage", groupMemberPageInfo.getFirstPage());
        map.put("lastpage", groupMemberPageInfo.getLastPage());
        return map;
    }

    /*
          * @Description: 分别查找通过和未通过的成员信息
          * @Param: [currentPage, memberstatus]
          * @return: com.github.pagehelper.PageInfo<com.wxplatform.pojo.GroupMember>
          * @Author:  zhijie
          * @Date: 2019/2/15
          */
    @Transactional(readOnly = true)
    public Map getMemberListPass(int currentPage) {
        Map map = new HashMap();
        List<GroupMember> groupMemberList;
        HashMap<String, Double> listMap = new HashMap<String, Double>();
        int count = wxMemberDAO.selectCountByStatus("1");
        NotNullInt(count, "memberlist.is.null");
        if (jedisTemplate.zcard("member_list_pass:") != count) {
            groupMemberList = wxMemberDAO.selectMemberListWithPagePass("1", currentPage);
            for (GroupMember groupMember : groupMemberList) {
                listMap.put(json.toJSONString(groupMember), Double.valueOf(groupMember.getMemberid()));
            }

            jedisTemplate.zadd("member_list_pass:", listMap);
            return redisPageHelper.findRedisDateByPage("member_list_pass:", 10L, currentPage, GroupMember.class);
        } else {
            return redisPageHelper.findRedisDateByPage("member_list_pass:", 10L, currentPage, GroupMember.class);
        }

    }

    /*
            * @Description: 分别查找通过和未通过的成员信息
            * @Param: [currentPage, memberstatus]
            * @return: com.github.pagehelper.PageInfo<com.wxplatform.pojo.GroupMember>
            * @Author:  zhijie
            * @Date: 2019/2/15
            */
    @Transactional(readOnly = true)
    public Map getMemberListNoPass(Integer currentPage) {
        Map map = new HashMap();
        PageHelper.startPage(currentPage, 10);
        List<GroupMember> memberinfo = wxMemberDAO.selectMemberListWithPageNoPass("0");
        ListNotExist(memberinfo, "memberlist.is.null");
        PageInfo<GroupMember> groupMemberPageInfo = new PageInfo<GroupMember>(memberinfo);
        map.put("pageNum", groupMemberPageInfo.getPageNum());
        map.put("pageSize", groupMemberPageInfo.getPageSize());
        map.put("pageTotal", groupMemberPageInfo.getPages());
        map.put("dataTotal", groupMemberPageInfo.getTotal());
        map.put("list", groupMemberPageInfo.getList());
        map.put("hasNextPage", groupMemberPageInfo.isHasNextPage());
        map.put("hasPrePage", groupMemberPageInfo.isHasPreviousPage());
        map.put("isFirstPage", groupMemberPageInfo.isIsFirstPage());
        map.put("isLastPage", groupMemberPageInfo.isIsLastPage());
        map.put("firstpage", groupMemberPageInfo.getFirstPage());
        map.put("lastpage", groupMemberPageInfo.getLastPage());
        return map;
    }

    /*
    * @Description: 按部门分类查看的信息
    * @Param: [department]
    * @return: java.util.concurrent.ConcurrentSkipListMap
    * @Author:  zhijie
    * @Date: 2018/12/6
    */
    @Transactional(readOnly = true)
    public List<GroupMember> getMemberListByDepartment(Integer department) {
        List<GroupMember> groupMemberList;
        int countbydb = wxMemberDAO.selectCountByDepart(department);
        NotNullInt(countbydb, "memberlist.is.null");
        HashMap<String, String> listMap = new HashMap<String, String>();
        if (jedisTemplate.hlen("member_list_depart:" + String.valueOf(department)) != countbydb) {
            groupMemberList = wxMemberDAO.selectMemberByDepartment(department);
            for (GroupMember groupMember : groupMemberList) {
                listMap.put(groupMember.getOpenid(), json.toJSONString(groupMember));
            }
            jedisTemplate.hmset("member_list_depart:" + String.valueOf(department), listMap);
            return json.parseArray(jedisTemplate.hvals("member_list_depart:" + String.valueOf(department)).toString(), GroupMember.class);
        }
        return json.parseArray(jedisTemplate.hvals("member_list_depart:" + String.valueOf(department)).toString(), GroupMember.class);

    }

    /**
     * @Description: 微信小程序端登录后个人信息的注册，开启声明式事务，注解形式
     * @Param: [groupMember]
     * @return: long
     * @Author: zhijie
     * @Date: 2019/3/23
     */
    @Transactional
    public long addMemberInfo(GroupMember groupMember) {
        //检查
        NotNull(groupMember.getOpenid(), "openId.is.null");
        NotNull(groupMember.getMemberid(), "memberId.is.null");
        NotNull(groupMember.getMembername(), "memberName.is.null");
        NotNullInt(groupMember.getPoliticalstatus(), "politicalStatus.is.null");
        NotNullInt(groupMember.getTissus(), "tissus.is.null");
        NotNullInt(groupMember.getDepartment(), "department.is.null");
        NotNull(groupMember.getTelnumber(), "telnumber.is.null");
        NotNullInt(groupMember.getDepartmentposition(), "position.is.notexist");
        memberIdIsTrue(groupMember.getMemberid(), "memberId.is.unstandardize");
        memberNameIsTrue(groupMember.getMembername(), "memberName.is.unstandarize");
        telNumberIsTrue(groupMember.getTelnumber(), "telnumber.is.unstandarize");
        politicalstatusNotExist(groupMember.getPoliticalstatus(), "political.is.null");
        openIdIsExist(groupMember.getOpenid());
        memberidIsExist(groupMember.getMemberid());
        long addMemberInfo = wxMemberDAO.wxMemberInsert(groupMember);
        return addMemberInfo;

    }

    /**
     * @Description: 修改自己的密码，然后自动退出
     * @Param: [memberpassword, memberId]
     * @return: int
     * @Author: zhijie
     * @Date: 2019/4/1
     */
    @Transactional
    public int updateMemberPassword(String memberpassword, String memberId) {
        int newPassword = wxMemberDAO.updatePwdByMemberId(memberpassword, memberId);
        logout();
        return newPassword;
    }

    /**
     * @Description: 显示用户的个人信息, 以只读的形式存在
     * 2种状态
     * 1、未审核状态。（memberstatus = 0）
     * 2、已审核状态。（memberstatus = 1）
     * @Param: [openid]
     * @return: java.util.concurrent.ConcurrentSkipListMap
     * @Author: zhijie
     * @Date: 2018/12/18
     */
    @Transactional(readOnly = true)
    public Map getTxMemberInfo(String openid) {
        Map map = new HashMap();
        GroupMember groupMemberInfo;
        isExist(openid);
        groupMemberInfo = wxMemberDAO.selectMemberInfo(openid);
        isAccess(groupMemberInfo.getMemberstatus(), "status.is.0");
        map.put("openid", groupMemberInfo.getOpenid());
        map.put("memberid", groupMemberInfo.getMemberid());
        map.put("membername", groupMemberInfo.getMembername());
        map.put("politicalstatus", groupMemberInfo.getPoliticalstatus());
        map.put("tissus", groupMemberInfo.getTissus());
        map.put("department", groupMemberInfo.getDepartment());
        map.put("departmentposition", groupMemberInfo.getDepartmentposition());
        map.put("telnumber", groupMemberInfo.getTelnumber());
        map.put("memberstatuss", groupMemberInfo.getMemberstatus());
        map.put("politicalstatusname", groupMemberInfo.getPoliticalstatusname());
        map.put("departmentname", groupMemberInfo.getDepartmentname());
        map.put("departmentpositionname", groupMemberInfo.getDepartmentpositionname());
        map.put("tissusname", groupMemberInfo.getTissusname());
        return map;
    }


    /**
     * @Description: 审核个人信息，使用读写锁，进行并发编程，防止线程不安全
     * @Param: [groupMember, openid]
     * @return: int
     * @Author: zhijie
     * @Date: 2019/3/26
     */
    @Transactional
    public int updataMemberInfoByPrimaryKey(GroupMember groupMember, String openid) {
        Subject subject = SecurityUtils.getSubject();
        GroupMember loginMember = wxMemberDAO.login(String.valueOf(subject.getPrincipal()));
        int loginMemberPosititon = loginMember.getDepartmentposition();
        Lock writeLock = reentrantReadWriteLock.writeLock();
        if (loginMemberPosititon == 1 || loginMemberPosititon == 2 || loginMemberPosititon == 3 || loginMemberPosititon == 4) {

            try {
                writeLock.lock();
                int updateAfterMemberInfo = wxMemberDAO.updateMemberStatus(groupMember, openid);
                groupMember = wxMemberDAO.selectMemberInfo(openid);
                jedisTemplate.set(groupMember.getOpenid(), json.toJSONString(groupMember));
                jedisTemplate.hset("member_list_depart:" + groupMember.getDepartment(), groupMember.getOpenid(), json.toJSONString(groupMember));
                return updateAfterMemberInfo;
            } finally {
                writeLock.unlock();
            }

        } else if (loginMemberPosititon == 5 || loginMemberPosititon == 6) {
            GroupMember memberdepart = wxMemberDAO.wxGetTxMemberInfo(openid); //待审核的人员信息
            int depart = memberdepart.getDepartment();
            if (loginMember.getDepartment() != depart) {
                throw new ForbidException("您无法对" + memberdepart.getDepartmentname() + "的小干或部长进行审核");
            } else {
                try {
                    writeLock.lock();
                    int updateAfterMemberInfo = wxMemberDAO.updateMemberStatus(groupMember, openid);
                    groupMember = wxMemberDAO.selectMemberInfo(openid);
                    jedisTemplate.set(groupMember.getOpenid(), json.toJSONString(groupMember));
                    jedisTemplate.hset("member_list_depart:" + groupMember.getDepartment(), groupMember.getOpenid(), json.toJSONString(groupMember));
                    return updateAfterMemberInfo;
                } finally {
                    writeLock.unlock();
                }
            }
        } else {
            throw new ForbidException("您无法进行审核");
        }

    }

    public Object logout() {

        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return null;
    }

    /*
     * @Description:  只有管理层可以删除个人信息
     * @Param: [openid]
     * @return: int
     * @Author:  zhijie
     * @Date: 2019-5-13
     */
    @Transactional
    public int deleteMemberInfo(String openid) {
        Subject subject = SecurityUtils.getSubject();

    GroupMember loginMember = wxMemberDAO.login(String.valueOf(subject.getPrincipal()));
        int loginMemberPosititon = loginMember.getDepartmentposition();
        GroupMember groupMember = wxMemberDAO.selectMemberInfo(openid); //获取到个人的信息
        Lock writeLock = reentrantReadWriteLock.writeLock();
        if (subject.getPrincipal().equals(groupMember.getMemberid())) {
            throw new ForbidException(("无法对自己操作"));
        }
        if (loginMemberPosititon == 1 || loginMemberPosititon == 2 || loginMemberPosititon == 3 || loginMemberPosititon == 4) {
            //判断周程是否存在
            memberInDateTripIsExist(groupMember.getMemberid());
            //判断值班列表是否存在
            memberInDutyIsExist(groupMember.getMemberid());
            //删除课表
            try {
                writeLock.lock();
                wxCourseInfoDAO.deleteByMemberid(groupMember.getMemberid());
                jedisTemplate.zremrangeByRank("member_list_pass:", 0, -1);
                if (jedisTemplate.hexists("member_list_depart:" + groupMember.getDepartment(), openid)) {   //缓存中删除部门列表里的数据
                    jedisTemplate.hdel("member_list_depart:" + groupMember.getDepartment(), openid);
                }
                return wxMemberDAO.deleteMemberInfo(openid);
            } finally {
                writeLock.unlock();
            }

        } else {
            throw new ForbidException("您无法进行删除操作");
        }

    }


    /*
      * @Description: 查看数据是否存在
      * @Param: [openid]
      * @return: boolean
      * @Author:  zhijie
      * @Date: 2019/4/13
      */
    public boolean isExist(String openid) {
        int memberList = wxMemberDAO.getMemberCount(openid);
        if (memberList == 0) {
            throw new NullException("检测到未进行个人信息的注册");
        } else {
            return true;
        }
    }

    public boolean memberidIsExist(String memberid) {
        int memberList = wxMemberDAO.selectCountByMemberid(memberid);
        if (memberList != 0) {
            throw new FailException("该学号已被注册！");
        } else {
            return true;
        }
    }

    public boolean openIdIsExist(String openid) {
        int memberList = wxMemberDAO.getMemberCount(openid);
        if (memberList != 0) {
            throw new FailException("无法重复注册！");
        } else {
            return true;
        }
    }

    public boolean memberInDutyIsExist(String memberid) {
        int memberList = dutyInfoDAO.selectDuttyMemberCount(memberid);
        if (memberList != 0) {
            throw new FailException("该成员存在于值班列表中，请先删除该成员相关的值班列表！");
        } else {
            return true;
        }
    }

    public boolean memberInDateTripIsExist(String memberid) {
        int memberList = dateTripDAO.memberInDateTripIsExist(memberid);
        if (memberList != 0) {
            throw new FailException("该成员存在于周程列表中，请先与该成员相关的周程列表！");
        } else {
            return true;
        }
    }

}