package com.wxplatform.mapper;

import com.wxplatform.pojo.NoCourseInfo;
import com.wxplatform.pojo.NoCourseInfoExample;

import javax.swing.*;
import java.util.List;

public interface NoCourseInfoMapper {
    List<NoCourseInfo> selectAllCourseInfo(int department);

    int insertAllCourseInfo(NoCourseInfo record);

    int insertSelective(NoCourseInfo record);

    int selectCountbymemberId(String memberid);

    int selectCountbydepartment(int department);

    int deleteByMemberid(String memberid);



    List<NoCourseInfo> selectByExample(NoCourseInfoExample example);
}