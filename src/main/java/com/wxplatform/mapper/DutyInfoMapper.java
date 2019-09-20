package com.wxplatform.mapper;

import com.wxplatform.pojo.DutyInfo;
import com.wxplatform.pojo.DutyInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DutyInfoMapper {
    int deleteByPrimaryKey(String dutyid);

    int deleteByMemberid(String memberid);

    int insert(DutyInfo record);

    int insertSelective(DutyInfo record);

    List<DutyInfo> selectByExample(DutyInfoExample example);

    int selectDuttyCount(@Param("week") int week, @Param("dutyxqday") String xqday);

    int selectDuttyListCount();

    int selectDuttyMemberCount(String memberid);

    DutyInfo selectByPrimaryKey(String dutyid);

    int updateByPrimaryKeySelective(DutyInfo record);

    int updateByPrimaryKey(DutyInfo record);

    int insertDutyInfo(@Param("dutyInfoList") List<DutyInfo> dutyInfoList);
}