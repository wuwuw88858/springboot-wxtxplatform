package com.wxplatform.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wxplatform.dao.WxDutyInfoDAO;
import com.wxplatform.dao.WxMemberDAO;
import com.wxplatform.pojo.DutyInfo;
import com.wxplatform.pojo.GroupMember;
import common.exceptions.FailException;
import common.redis.JedisTemplate;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListMap;

import static common.utils.NotNullCheckUtils.NotNull;
import static common.utils.NotNullCheckUtils.NotNullInt;
import static common.utils.otherUtils.GetTimeUtils.changTimeStampToTime;
import static common.utils.otherUtils.GetTimeUtils.changTimeToTimeStamp;


/**
 * @program: Wxplatform
 * @description:
 * @author: zhijie
 * @create: 2019-03-31 22:06
 **/
@Service
public class WxDutyService {

    @Autowired
    WxDutyInfoDAO dutyInfoDAO;

    @Autowired
    WxMemberDAO wxMemberDAO;

    @Autowired
    JedisTemplate jedisTemplate;

    JSON json = new JSONObject();
    @Autowired
    ConcurrentSkipListMap<String, Object> concurrentSkipListMap;

    private static final Logger log = LoggerFactory.getLogger(WxDateTripService.class);

    /*
       * @Description:  批量添加值班人员，管理层操作
       * @Param: [dutyInfoList]
       * @return: int
       * @Author:  zhijie
       * @Date: 2019/4/13
       */
    @Transactional
    public int insertDutyInfoList(List<DutyInfo> dutyInfoList) {
        Subject subject = SecurityUtils.getSubject();
        GroupMember loginMember = wxMemberDAO.login(String.valueOf(subject.getPrincipal()));
        int loginMemberDepartment = loginMember.getDepartment();
        if (loginMemberDepartment == 7 || loginMemberDepartment == 15) {
            for (DutyInfo dutyInfo : dutyInfoList) {
                NotNull(dutyInfo.getMemberid(), "memberId.is.null");
                NotNull(dutyInfo.getDutybegintime(), "duty.begintime.is.null");
                NotNull(dutyInfo.getDutyendtime(), "duty.endtime.is.null");
                NotNull(dutyInfo.getDutyxqday(), "duty.xqday.is.null");
                NotNullInt(dutyInfo.getWeek(), "duty.week.is.null");
                int beginTimeStamp = Integer.valueOf(changTimeToTimeStamp(dutyInfo.getDutybegintime()));
                int endTimeStamp = Integer.valueOf(changTimeToTimeStamp(dutyInfo.getDutyendtime()));
                if (beginTimeStamp > endTimeStamp) {
                    throw new FailException("值班开始时间不能大于结束时间");
                }
                memberidIsExist(dutyInfo.getMemberid());
                dutyInfo.setDutyid(UUID.randomUUID().toString());
                dutyInfo.setDutybegintime(changTimeToTimeStamp(dutyInfo.getDutybegintime()));
                dutyInfo.setDutyendtime(changTimeToTimeStamp(dutyInfo.getDutyendtime()));
            }
            return dutyInfoDAO.insertDutyInfo(dutyInfoList);
        } else {
            throw new FailException("您无法添加值班人员");
        }

    }


    /*
       * @Description:  按周程和星期分类
       * @Param: [week, dutyxqday]
       * @return: java.util.List<com.wxplatform.pojo.GroupMember>
       * @Author:  zhijie
       * @Date: 2019/4/27
       */
    @Transactional(readOnly = true)
    public List<GroupMember> getDutyListByXqday(int week, String dutyxqday) {
        int dutyCount = dutyInfoDAO.selectDuttyCount(week, dutyxqday);
        NotNullInt(dutyCount, "duty.list.is.null");
        HashMap<String, String> listMap = new HashMap<String, String>();
        if (jedisTemplate.hlen("duty_list:" + week + ":" + dutyxqday) != dutyCount) {
            List<GroupMember> dutyMemberList = wxMemberDAO.selectDutyList(week, dutyxqday);
            for (GroupMember duttyMember : dutyMemberList) {
                duttyMember.setDutybegintime(changTimeStampToTime(duttyMember.getDutybegintime()));
                duttyMember.setDutyendtime(changTimeStampToTime(duttyMember.getDutyendtime()));
                listMap.put(duttyMember.getDutyid(), json.toJSONString(duttyMember));
            }
            jedisTemplate.hmset("duty_list:" + week + ":" + dutyxqday, listMap);
            return json.parseArray(jedisTemplate.hvals("duty_list:" + week + ":" + dutyxqday).toString(), GroupMember.class);
        }
        return json.parseArray(jedisTemplate.hvals("duty_list:" + week + ":" + dutyxqday).toString(), GroupMember.class);
    }

    /*
   * @Description:  后台获取所有值班的人员
   * @Param: []
   * @return: java.util.List<com.wxplatform.pojo.GroupMember>
   * @Author:  zhijie
   * @Date: 2019/4/23
   */
    public List<GroupMember> getDutyList() {
        int dutyCount = dutyInfoDAO.selectDuttyListCount();
        HashMap<String, String> listMap = new HashMap<String, String>();
        if (jedisTemplate.hlen("duty_list") != dutyCount) {
            List<GroupMember> dutyMemberList = wxMemberDAO.selectDutys();
            for (GroupMember duttyMember : dutyMemberList) {
                duttyMember.setDutybegintime(changTimeStampToTime(duttyMember.getDutybegintime()));
                duttyMember.setDutyendtime(changTimeStampToTime(duttyMember.getDutyendtime()));
                listMap.put(duttyMember.getDutyid(), json.toJSONString(duttyMember));
            }
            jedisTemplate.hmset("duty_list", listMap);
            return json.parseArray(jedisTemplate.hvals("duty_list").toString(), GroupMember.class);
        }
        return json.parseArray(jedisTemplate.hvals("duty_list").toString(), GroupMember.class);

    }

    /*
     * @Description:  值班人员信息删除，管理层操作
     * @Param: [dutyid]
     * @return: int
     * @Author:  zhijie
     * @Date: 2019-5-10
     */
    @Transactional
    public int delDutyInfo(String dutyid) {
  Subject subject = SecurityUtils.getSubject();
        GroupMember loginMember = wxMemberDAO.login(String.valueOf(subject.getPrincipal()));
        int loginMemberDepartment = loginMember.getDepartment();
        if (loginMemberDepartment == 7 || loginMemberDepartment == 15) {
            DutyInfo dutyInfo = dutyInfoDAO.selectByPrimaryKey(dutyid);
            if (jedisTemplate.hexists("duty_list:" + dutyInfo.getWeek() + ":" + dutyInfo.getDutyxqday(), dutyInfo.getDutyid())) {
                jedisTemplate.hdel("duty_list:" + dutyInfo.getWeek() + ":" + dutyInfo.getDutyxqday(), dutyInfo.getDutyid());
            }
            if (jedisTemplate.hexists("duty_list", dutyInfo.getDutyid())) {
                jedisTemplate.hdel("duty_list", dutyInfo.getDutyid());
            }
            return dutyInfoDAO.delDutyMember(dutyid);
        } else  {
            throw new FailException("您无法删除值班人员");
        }
    }


    public boolean memberidIsExist(String memberid) {
        int memberList = wxMemberDAO.selectCountByMemberid(memberid);
        if (memberList == 0) {
            throw new FailException("学号" + memberid + "还未注册！");
        } else {
            return true;
        }
    }
}
