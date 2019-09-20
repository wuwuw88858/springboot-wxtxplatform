package com.wxplatform.dao.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wxplatform.dao.WxDateTripDAO;
import com.wxplatform.mapper.DateTripMapper;
import com.wxplatform.pojo.DateTrip;
import com.wxplatform.pojo.DateTripExample;
import common.redis.JedisTemplate;
import common.utils.otherUtils.GetTimeUtils;
import common.utils.otherUtils.RedisPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


import static common.utils.otherUtils.GetTimeUtils.changDateStampToDate;
import static common.utils.otherUtils.GetTimeUtils.changTimeStampToTime;
import static common.utils.otherUtils.GetTimeUtils.setSthIdByCurrentTime;

/**
 * @program: Wxplatform
 * @description: 周程模块于数据库交互的模块
 * @author: zhijie
 * @create: 2018-12-06 22:01
 **/

@Repository
public class WxDateTripDAOImpl implements WxDateTripDAO {

    @Autowired
    DateTripMapper dateTripMapper;

    @Autowired
    JedisTemplate jedisTemplate;

    @Autowired
    RedisPageHelper redisPageHelper;
    JSON json = new JSONObject();

    /**
     * @Description: 添加周程的模块，部长能对周程进行添加，尚未确定管理层是否能加。
     * 注意：周程的编号由系统精确到毫秒组成
     * @Param: [dateTrip]
     * @return: int
     * @Author: zhijie
     * @Date: 2018/12/6
     */
    @Override
    public long insertDataTrip(DateTrip dateTrip) {
        dateTrip.setDatetripid(setSthIdByCurrentTime()); //获取当前周程的Id编号
        dateTrip.setTripstatus("0");  //设置当前周程状态为待审核
        dateTrip.setDate(GetTimeUtils.changDateToTimeStamp(dateTrip.getDate()));
        dateTrip.setTime(GetTimeUtils.changTimeToTimeStamp(dateTrip.getTime()));
        return dateTripMapper.insert(dateTrip);
    }

    public int selectCount(int week) {
        DateTripExample dateTripExample = new DateTripExample();
        DateTripExample.Criteria criteria = dateTripExample.createCriteria();
        criteria.andWeekEqualTo(week);
        criteria.andTripstatusEqualTo("1");
        return dateTripMapper.selectCount(dateTripExample);
    }

    public int memberInDateTripIsExist(String memberid) {
        return dateTripMapper.selectDateTripMemberCount(memberid);
    }
    /**
     * @Description: 改变部长上传的周程的状态 0：等待审核 1：审核通过
     * @Param: [dateTrip, dateTripId]
     * @return: int
     * @Author: zhijie
     * @Date: 2018/12/24
     */
    @Override
    public int updateDateTripStatus(DateTrip dateTrip, String dateTripId) {
        dateTrip.setDatetripid(dateTripId);
        dateTrip.setTripstatus("1");
        int updatestatus = dateTripMapper.updateByPrimaryKeySelective(dateTrip);
        return updatestatus;
    }

    public DateTrip selectByPrimaryKey(String datetripid) {
        return dateTripMapper.selectByPrimaryKey(datetripid);
    }
//    /**
//     * @Description: 获取下一周所有待审核的周程包括了审核/未审核
//     * @Param: [week]
//     * @return: java.util.List<com.wxplatform.pojo.DateTrip>
//     * @Author: zhijie
//     * @Date: 2018/12/25
//     */
//    @Override
//    public List<DateTrip> selectDateTripWithPage(int week) {
//        DateTripExample dateTripExample = new DateTripExample();
//        DateTripExample.Criteria criteria = dateTripExample.createCriteria();
//        criteria.andWeekEqualTo(week);
//        int count = dateTripMapper.selectCount(dateTripExample);
//
//        HashMap<String, String> listmap = new HashMap<String, String>();
//        if (jedisTemplate.hlen("datetrip_list:" + week) != count) {
//            criteria.andWeekEqualTo(week);
//            List<DateTrip> dateTripList = dateTripMapper.selectByExample(dateTripExample);
//            for (DateTrip dateTrip : dateTripList) {
//                listmap.put(dateTrip.getDatetripid(), json.toJSONString(dateTrip));
//            }
//            jedisTemplate.hmset("datetrip_list:" + week, listmap);
//            jedisTemplate.expire("datetrip_list:" + week, 864000);
//            return dateTripList;
//        } else {
//            return json.parseArray(jedisTemplate.hvals("datetrip_list:" + week).toString(), DateTrip.class);
//        }
//    }

    /**
     * @Description: 用在小程序所看到的周程的信息
     * @Param: [week]
     * @return: java.util.List<com.wxplatform.pojo.DateTrip>
     * @Author: zhijie
     * @Date: 2018/12/26
     */
    @Override
    public List<DateTrip> selectDateTripPassWithPageThisWeek(int week) {

        DateTripExample dateTripExample = new DateTripExample();
        DateTripExample.Criteria criteria = dateTripExample.createCriteria();
        criteria.andWeekEqualTo(week);
        criteria.andTripstatusEqualTo("1");
        return dateTripMapper.selectByExample(dateTripExample);
    }

    /**
     * @Description: 查找未通过的的周程
     * @Param: [week]
     * @return: java.util.List<com.wxplatform.pojo.DateTrip>
     * @Author: zhijie
     * @Date: 2018/12/26
     */
    @Override
    public List<DateTrip> selectDateTripNoPass(int week) {
        DateTripExample dateTripExample = new DateTripExample();
        DateTripExample.Criteria criteria = dateTripExample.createCriteria();   //构造自定义的查询条件
        criteria.andWeekEqualTo(week);
        criteria.andTripstatusEqualTo("0");
        return dateTripMapper.selectByExample(dateTripExample);
    }

    /**
     * @Description: 查看某一星期的周程内容，不分页
     * @Param: [week, xqday]
     * @return: java.util.List<com.wxplatform.pojo.DateTrip>
     * @Author: zhijie
     * @Date: 2018/12/30
     */
    @Override
    public List<DateTrip> selectDateTripPassByXqday(int week, String xqday) {
        DateTripExample dateTripExample = new DateTripExample();
        DateTripExample.Criteria criteria = dateTripExample.createCriteria();
        criteria.andWeekEqualTo(week);
        criteria.andXqdayEqualTo(xqday);
        criteria.andTripstatusEqualTo("1");
        return dateTripMapper.selectByExample(dateTripExample);

    }

    public int selectCountByWeekAndXqday(int week, String xqday) {
    DateTripExample dateTripExample = new DateTripExample();
    DateTripExample.Criteria criteria = dateTripExample.createCriteria();
        criteria.andWeekEqualTo(week);
        criteria.andXqdayEqualTo(xqday);
        criteria.andTripstatusEqualTo("1");
        return dateTripMapper.selectCount(dateTripExample);
}
    /**
     * @Description: 查看周程的详细内容，小程序端
     * @Param: [dateTripId]
     * @return: com.wxplatform.pojo.DateTrip
     * @Author: zhijie
     * @Date: 2019/2/25
     */
    @Override
    public DateTrip selectDateTripDetail(String dateTripId) {

            DateTrip dateTrip =  dateTripMapper.selectByPrimaryKey(dateTripId);
            dateTrip.setTime(changTimeStampToTime(dateTrip.getTime()));
            dateTrip.setDate(changDateStampToDate(dateTrip.getDate()));
            return dateTrip;
    }

    /**
     * @Description: 手动删除周程
     * @Param: [dateTripId]
     * @return: int
     * @Author: zhijie
     * @Date: 2019/4/1
     */
    @Override
    public int deleteDateTrip(String dateTripId) {

        return dateTripMapper.deleteByPrimaryKey(dateTripId);
    }

    public int deleteByeditor(String editor) {
        return dateTripMapper.deleteByeditor(editor);
    }
}
