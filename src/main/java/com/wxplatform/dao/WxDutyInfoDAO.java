package com.wxplatform.dao;

import com.wxplatform.pojo.DutyInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: Wxplatform
 * @description:
 * @author: zhijie
 * @create: 2019-03-31 22:01
 **/
@Repository
public interface WxDutyInfoDAO {

    int insertDutyInfo(List<DutyInfo> dutyInfoList);

    int delDutyMember(String dutyid);

    int deleteByMemberid(String memberid);

    int selectDuttyCount(int week, String xqday);

    int selectDuttyMemberCount(String memberid);

    int selectDuttyListCount();

    DutyInfo selectByPrimaryKey(String dutyid);
}
