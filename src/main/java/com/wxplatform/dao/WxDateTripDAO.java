package com.wxplatform.dao;

import com.wxplatform.pojo.DateTrip;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: Wxplatform
 * @description: 周程数据库操作的相关接口
 * @author: zhijie
 * @create: 2018-12-06 22:00
 **/
@Repository
public interface WxDateTripDAO {
    long insertDataTrip(DateTrip dateTrip);

    int updateDateTripStatus(DateTrip dateTrip, String dateTripId);

     int selectCount(int week);

     int memberInDateTripIsExist(String memberid);

    int selectCountByWeekAndXqday(int week, String xqday);

//    List<DateTrip> selectDateTripWithPage(int week);    //分页获取所有周程的信息（包括通过和为通过）

    int deleteDateTrip(String dateTripId);

    List<DateTrip> selectDateTripPassWithPageThisWeek(int week);   //查看本周的周程（通过）

    List<DateTrip> selectDateTripNoPass(int week);  //后台查看待审核的周程

    List<DateTrip> selectDateTripPassByXqday(int week, String xqday);    //查看某个星期的周程

    DateTrip selectDateTripDetail(String datetripId);//（查看详情）

    DateTrip selectByPrimaryKey(String datetripId);

    int deleteByeditor(String editor);


}
