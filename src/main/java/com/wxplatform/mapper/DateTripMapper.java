package com.wxplatform.mapper;

import com.wxplatform.pojo.DateTrip;
import com.wxplatform.pojo.DateTripExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DateTripMapper {
    int deleteByPrimaryKey(String datetripid);

    int deleteByeditor(String editor);

    int insert(DateTrip record);

    int insertSelective(DateTrip record);

    List<DateTrip> selectByExample(DateTripExample example);

    DateTrip selectByPrimaryKey(String datetripid);

    int updateByPrimaryKeySelective(DateTrip record);

    int updateByPrimaryKey(DateTrip record);

    int selectCount(DateTripExample example);

    int selectDateTripMemberCount(String memberid);


    //如果含有多个参数，需要加@Param，否则无法识别
    int selectPassCount(@Param("week") Integer week, @Param("tripstatus") String tripstatus);
}