package com.wxplatform.dao.impl;

import com.wxplatform.dao.WxDutyInfoDAO;
import com.wxplatform.mapper.DutyInfoMapper;
import com.wxplatform.pojo.DutyInfo;
import common.redis.JedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: Wxplatform
 * @description:
 * @author: zhijie
 * @create: 2019-03-31 22:02
 **/
@Repository
public class WxDutyInfoDAOImpl implements WxDutyInfoDAO {

    @Autowired
    DutyInfoMapper dutyInfoMapper;
    @Autowired
    JedisTemplate jedisTemplate;

    /*
     * @Description: 批量插入，随机生成dutyid, 同时将时间转时间戳
     * @Param: [dutyInfoList]
     * @return: int
     * @Author:  zhijie
     * @Date: 2019/4/1
     */
    @Override
    public int insertDutyInfo(List<DutyInfo> dutyInfoList) {

        return dutyInfoMapper.insertDutyInfo(dutyInfoList);
    }

    public int delDutyMember(String dutyid) {
        return dutyInfoMapper.deleteByPrimaryKey(dutyid);
    }

    public int deleteByMemberid(String memberid) {
        return dutyInfoMapper.deleteByMemberid(memberid);
    }

    @Override
    public int selectDuttyCount(int week, String xqday) {
        return dutyInfoMapper.selectDuttyCount(week, xqday);
    }

    @Override
    public int selectDuttyMemberCount(String memberid) {
        return dutyInfoMapper.selectDuttyMemberCount(memberid);
    }

    @Override
    public int selectDuttyListCount() {
        return dutyInfoMapper.selectDuttyListCount();
    }

    @Override
    public DutyInfo selectByPrimaryKey(String dutyid) {
        return dutyInfoMapper.selectByPrimaryKey(dutyid);
    }

}
