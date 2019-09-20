package com.wxplatform.dao;

import com.wxplatform.pojo.NoCourseInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: wxpaltform-master
 * @description: 微信导入无课表以及获取无课表
 * @author: zhijie
 * @create: 2019-04-13 15:00
 **/
@Repository
public interface WxCourseInfoDAO {

    int selectCountbymemberId(String memberid);

    int selectCountbydepartment(int department);

    int deleteByMemberid(String memberid);

    List<NoCourseInfo> selectAllCourseInfo(int department);

    int insertAllCourseInfo(String studentName, String password, String schoolyear, String semester);
}
