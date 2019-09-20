package com.wxplatform.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxplatform.dao.WxDateTripDAO;
import com.wxplatform.dao.WxMemberDAO;
import com.wxplatform.pojo.DateTrip;
import com.wxplatform.pojo.GroupMember;
import common.exceptions.FailException;
import common.exceptions.ForbidException;
import common.redis.JedisTemplate;
import common.utils.otherUtils.RedisPageHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static common.utils.FailCheckUtils.isTimeEqual;
import static common.utils.NotNullCheckUtils.ListNotExist;
import static common.utils.NotNullCheckUtils.NotNull;
import static common.utils.NotNullCheckUtils.NotNullInt;
import static common.utils.otherUtils.GetTimeUtils.*;


/**
 * @program: Wxplatform
 * @description: 周程的业务逻辑层
 * @author: zhijie
 * @create: 2018-12-07 10:08
 **/
@Service
public class WxDateTripService {

    @Autowired
    private WxDateTripDAO wxDateTrip;
    @Autowired
    WxMemberDAO wxMemberDAO;

    @Autowired
    JedisTemplate jedisTemplate;

    @Autowired
    RedisPageHelper redisPageHelper;

    JSON json = new JSONObject();
    @Autowired
    ConcurrentSkipListMap<String, Object> concurrentSkipListMap;

    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    /*
       * @Description:  部长添加周程，每一次只能同时添加一次周程。
        * 注意的是：周程内的主办部门和编写者都是由cookie获取到隐藏表单之内，
        * 因此不必判断是否为空或者不存在。
        * 除了小干之外都能添加周程
       * @Param: [dateTrip]
       * @return: long
       * @Author:  zhijie
       * @Date: 2018/12/17
       */
    @Transactional
    public long addDateTrip(DateTrip dateTrip) {
        if(!getWeek()){
            throw new ForbidException("现在现在无法操作");
        }
        Subject subject = SecurityUtils.getSubject();
        GroupMember loginMember = wxMemberDAO.login(String.valueOf(subject.getPrincipal()));
        int loginMemberPosititon = loginMember.getDepartmentposition();
        NotNull(dateTrip.getDate(), "dateTrip.date.is.null");   //活动开始日期规格：yyyymmdd
        NotNull(dateTrip.getTime(), "dateTrip.time.is.null");    //活动开始时间:hhmmss
        NotNullInt(dateTrip.getWeek(), "dateTrip.week.is.null");    //活动周数
        NotNull(dateTrip.getXqday(), "dateTrip.xqday.is.null");  //活动星期
        NotNull(dateTrip.getDatetripcontent(), "dateTrip.content.is.null"); //活动内容
        NotNull(dateTrip.getParticipants(), "dateTrip.participants.is.null");   //活动参加人员
        NotNull(dateTrip.getPlace(), "dateTrip.place.is.null");  //活动地点
        NotNullInt(dateTrip.getDatetriptype(), "dateTrip.week.is.null");
        isTimeEqual(dateTrip.getDate(), "dateTrip.date.is.equal");

        if (loginMemberPosititon != 7) {
            long datetrip = wxDateTrip.insertDataTrip(dateTrip);
            return datetrip;
        } else {
            throw new FailException("您无法添加周程");
        }

    }

    /*
            * @Description:  修改周程状态，只有管理层可以操作
            * @Param: [dateTrip, dateTripId]
            * @return: int
            * @Author:  zhijie
            * @Date: 2018/12/24
            */
    @Transactional
    public int updateDateTripStatus(DateTrip dateTrip, String dateTripId) {
        if(!getWeek()){
            throw new ForbidException("现在现在无法操作");
        }
        Subject subject = SecurityUtils.getSubject();
        GroupMember loginMember = wxMemberDAO.login(String.valueOf(subject.getPrincipal()));
        int loginMemberPosititon = loginMember.getDepartmentposition();
        Lock writeLock = reentrantReadWriteLock.writeLock();
        if (loginMemberPosititon == 1 || loginMemberPosititon == 2 || loginMemberPosititon == 3 || loginMemberPosititon == 4) {
            try {
                writeLock.lock();
                int updateStatus = wxDateTrip.updateDateTripStatus(dateTrip, dateTripId);
                dateTrip = wxDateTrip.selectByPrimaryKey(dateTripId);
                jedisTemplate.set(dateTrip.getDatetripid(), json.toJSONString(dateTrip));
                return updateStatus;
            } finally {
                writeLock.unlock();
            }

        } else {
            throw new FailException("请联系管理层审核周程");
        }

    }

    /*
       * @Description:查找所有的周程包括审核，未审核
       * @Param: [nextweek, currentPage]
       * @return: com.github.pagehelper.PageInfo<java.util.Map>
       * @Author:  zhijie
       * @Date: 2019/2/28
       */
//    @Transactional(readOnly = true)
//    public ConcurrentSkipListMap selectDateTripPassWithPage(int nextweek, Integer currentPage) {
//        PageHelper.startPage(currentPage, 5);
//        List<DateTrip> dateTripList = wxDateTrip.selectDateTripWithPage(nextweek);
//        ListNotExist(dateTripList, "dateTrip.list.is.null");
//        List<Map> list = list(dateTripList);
//        PageInfo<Map> dateTripPageInfo = new PageInfo<Map>(list);
//        concurrentSkipListMap.put("result", dateTripList);
//        return concurrentSkipListMap;
//    }


    /*
       * @Description: 查找已经通过审核的周程内容，同时缓存设置过期时间12小时
       * @Param: [nextweek, currentPage]
       * @return: com.github.pagehelper.PageInfo<com.wxplatform.pojo.DateTrip>
       * @Author:  zhijie
       * @Date: 2018/12/26
       */
    @Transactional(readOnly = true)
    public Map selectDateTripByPassWithPageThisWeek(int week, int currentPage) {
        int count = wxDateTrip.selectCount(week);
        NotNullInt(count, "dateTrip.list.is.null");
        HashMap<String, Double> listmap = new HashMap<String, Double>();
        if (jedisTemplate.zcard("datetrip_list_pass:" + week) != count) {
            List<DateTrip> dateTripList = wxDateTrip.selectDateTripPassWithPageThisWeek(week);
            for (DateTrip dateTrip : dateTripList) {
                dateTrip.setTime(changTimeStampToTime(dateTrip.getTime()));
                dateTrip.setDate(changDateStampToDate(dateTrip.getDate()));
                listmap.put(json.toJSONString(dateTrip), Double.valueOf(dateTrip.getDatetripid()));
            }
            jedisTemplate.zadd("datetrip_list_pass:" + week, listmap);
            jedisTemplate.expire("datetrip_list_pass:" + week, 432000);
            return redisPageHelper.findRedisDateByPage("datetrip_list_pass:" + week, 10L, currentPage, DateTrip.class);
        } else {
            return redisPageHelper.findRedisDateByPage("datetrip_list_pass:" + week, 10L, currentPage, DateTrip.class);
        }
    }
    /*
    * @Description: 查找未通过审核的周程内容
    * @Param: [nextweek, currentPage]
    * @return: com.github.pagehelper.PageInfo<com.wxplatform.pojo.DateTrip>
    * @Author:  zhijie
    * @Date: 2018/12/26
    */
    @Transactional(readOnly = true)
    public ConcurrentSkipListMap<String, Object> selectDateTripNoPassWithPageNextWeek(int currentPage, int week) {
        PageHelper.startPage(currentPage, 5);
        List<DateTrip> dateTripList = wxDateTrip.selectDateTripNoPass(week);
        ListNotExist(dateTripList, "dateTrip.list.is.null");
        for (DateTrip dateTrip : dateTripList) {
            dateTrip.setTime(changTimeStampToTime(dateTrip.getTime()));
            dateTrip.setDate(changDateStampToDate(dateTrip.getDate()));
        }
        PageInfo<DateTrip> pageInfo = new PageInfo<DateTrip>(dateTripList);
        concurrentSkipListMap.put("pageNum", pageInfo.getPageNum());
        concurrentSkipListMap.put("pageSize", pageInfo.getPageSize());
        concurrentSkipListMap.put("pageTotal", pageInfo.getPages());
        concurrentSkipListMap.put("dataTotal", pageInfo.getTotal());
        concurrentSkipListMap.put("list", pageInfo.getList());
        concurrentSkipListMap.put("hasNextPage", pageInfo.isHasNextPage());
        concurrentSkipListMap.put("hasPrePage", pageInfo.isHasPreviousPage());
        concurrentSkipListMap.put("isFirstPage", pageInfo.isIsFirstPage());
        concurrentSkipListMap.put("isLastPage", pageInfo.isIsLastPage());
        concurrentSkipListMap.put("firstpage", pageInfo.getFirstPage());
        concurrentSkipListMap.put("lastpage", pageInfo.getLastPage());
        return concurrentSkipListMap;

    }


    /*
     * @Description:  查看某个星期的所有周程
     * @Param: [week, xqday]
     * @return: java.util.concurrent.ConcurrentSkipListMap
     * @Author:  zhijie
     * @Date: 2018/12/30
     */
    @Transactional(readOnly = true)
    public List<DateTrip> selectDateTripByXqday(String xqday) {
        int week = getWeekTime();
        int count = wxDateTrip.selectCountByWeekAndXqday(week, xqday);
        NotNullInt(count, "dateTrip.list.is.null");
        HashMap<String, String> listmap = new HashMap<String, String>();
        if (count != jedisTemplate.hlen("datetrip_list_week:" + week + ":xqday" + xqday)) {
            List<DateTrip> dateTripList = wxDateTrip.selectDateTripPassByXqday(week, xqday);
            for (DateTrip dateTrip : dateTripList) {
                dateTrip.setTime(changTimeStampToTime(dateTrip.getTime()));
                dateTrip.setDate(changDateStampToDate(dateTrip.getDate()));
                listmap.put(dateTrip.getDatetripid(), json.toJSONString(dateTrip));
            }
            jedisTemplate.hmset("datetrip_list_week:" + week + ":xqday:" + xqday, listmap);
            jedisTemplate.expire("datetrip_list_week:" + week + ":xqday:" + xqday, 864000); //设置十天的过期时间
            return json.parseArray(jedisTemplate.hvals("datetrip_list_week:" + week + ":xqday:" + xqday).toString(), DateTrip.class);
        } else {
            return json.parseArray(jedisTemplate.hvals("datetrip_list_week:" + week + ":xqday:" + xqday).toString(), DateTrip.class);
        }

    }

    /*
        * @Description:  查看周程的详细内容
        * @Param: [dateTripId]
        * @return: com.wxplatform.pojo.DateTrip
        * @Author:  zhijie
        * @Date: 2018/12/30
        */
    @Transactional(readOnly = true)
    public DateTrip selectDateTripDetail(String dateTripId) {
        if (jedisTemplate.get(dateTripId) == null || jedisTemplate.get(dateTripId).isEmpty()) {
            DateTrip dateTrip = wxDateTrip.selectDateTripDetail(dateTripId);
            jedisTemplate.set(dateTrip.getDatetripid(), json.toJSONString(dateTrip));
            jedisTemplate.expire(dateTrip.getDatetripid(), 864000);
            return json.parseObject(jedisTemplate.get(dateTripId), DateTrip.class);

        } else {
            return json.parseObject(jedisTemplate.get(dateTripId), DateTrip.class);
        }
    }


    /*
        * @Description:  删除周程，只有管理层可以操作
        * @Param: [dateTripId]
        * @return: int
        * @Author:  zhijie
        * @Date: 2018/12/26
        */
    @Transactional
    public int deleteDateTrip(String dateTripId) {
        if(!getWeek()){
            throw new ForbidException("现在现在无法操作");
        }
        Subject subject = SecurityUtils.getSubject();
        GroupMember loginMember = wxMemberDAO.login(String.valueOf(subject.getPrincipal()));
        int loginMemberPosititon = loginMember.getDepartmentposition();
        Lock writeLock = reentrantReadWriteLock.writeLock();
        if (loginMemberPosititon == 1 || loginMemberPosititon == 2 || loginMemberPosititon == 3 || loginMemberPosititon == 4) {
         try {
             writeLock.lock();
             DateTrip dateTrip = wxDateTrip.selectByPrimaryKey(dateTripId);
             jedisTemplate.del(dateTripId);
             jedisTemplate.zremrangeByRank("datetrip_list_pass:" + dateTrip.getWeek(), 0, -1);
             if (jedisTemplate.hexists("datetrip_list_week:" + dateTrip.getWeek() + ":xqday" + dateTrip.getXqday(), dateTripId)) {
                 jedisTemplate.hdel("datetrip_list_week:" + dateTrip.getWeek() + ":xqday" + dateTrip.getXqday(), dateTripId);
             }
             int deleteDateTrip = wxDateTrip.deleteDateTrip(dateTripId);
             return deleteDateTrip;
         } finally {
             writeLock.unlock();
         }

        } else {
            throw new FailException("请联系管理层删除周程");
        }

    }


    /*
     * @Description:  封装List信息
     * @Param: [dateTripList]
     * @return: java.util.List<java.util.Map>
     * @Author:  zhijie
     * @Date: 2019/1/11
     */
    public List<Map> list(List<DateTrip> dateTripList) {
        List<Map> list = new ArrayList<Map>();
        for (DateTrip dateTrip : dateTripList) {
            Map datetripMap = new HashMap();
            datetripMap.put("datetripid", dateTrip.getDatetripid());//id
            datetripMap.put("datetripdate", changDateStampToDate(dateTrip.getDate()));//日期
            datetripMap.put("datetriptime", changTimeStampToTime(dateTrip.getTime()));//时间
            datetripMap.put("week", dateTrip.getWeek());//周数
            datetripMap.put("xqday", dateTrip.getXqday());//星期
            datetripMap.put("datetriptype", dateTrip.getDatetriptype()); //活动类型
            datetripMap.put("datetripcontent", dateTrip.getDatetripcontent());//内容
            datetripMap.put("participants", dateTrip.getParticipants()); //参加人员
            datetripMap.put("department", dateTrip.getHostdepartment());//部门
            datetripMap.put("place", dateTrip.getPlace());//地点
            datetripMap.put("editor", dateTrip.getEditor());
            datetripMap.put("tripstatus", dateTrip.getTripstatus());
            datetripMap.put("datetriptype", dateTrip.getDatetripName());

            list.add(datetripMap);
        }
        return list;
    }
}