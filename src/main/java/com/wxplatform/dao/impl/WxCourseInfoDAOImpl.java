package com.wxplatform.dao.impl;

import com.wxplatform.dao.WxCourseInfoDAO;
import com.wxplatform.dao.WxMemberDAO;
import com.wxplatform.mapper.GroupMemberMapper;
import com.wxplatform.mapper.NoCourseInfoMapper;
import com.wxplatform.pojo.GroupMember;
import com.wxplatform.pojo.NoCourseInfo;
import common.getlogin.GetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: wxpaltform-master
 * @description:
 * @author: zhijie
 * @create: 2019-04-13 15:02
 **/
@Repository
public class WxCourseInfoDAOImpl implements WxCourseInfoDAO {

    @Autowired
    NoCourseInfoMapper noCourseInfoMapper;

    @Autowired
    GroupMemberMapper groupMemberMapper;

    @Override
    public int selectCountbymemberId(String memberid) {
        return noCourseInfoMapper.selectCountbymemberId(memberid);
    }

    @Override
    public int selectCountbydepartment(int department) {
        return noCourseInfoMapper.selectCountbydepartment(department);
    }

    @Override
    public List<NoCourseInfo> selectAllCourseInfo(int department) {
        return noCourseInfoMapper.selectAllCourseInfo(department);
    }

    /*
        * @Description:  插入获取的无课表至数据库
        *       setCourse1-setCourse8 周一 一天课程
        *       setCourse9-setCourse16 周二
        *       setCourse17-setCourse24 周三
        *       setCourse25-setCourse32 周四
        *       setCourse33-setCourse40周五
        *       setCourse41-setCourse48周六
        *       setCourse49setCourse56周日
        * @Param: [MemberId, password, schoolyear, semester]
        * @return: int
        * @Author:  zhijie
        * @Date: 2019/4/13
        */
    @Override
    public int insertAllCourseInfo(String MemberId, String password,String schoolyear,String semester) {
        NoCourseInfo noCourseInfo = new NoCourseInfo();
       GroupMember groupMember =  groupMemberMapper.getNameAndDepartById(MemberId);
        List courseList = GetSource.getNoCourseList(MemberId, password,
                schoolyear, semester);
        noCourseInfo.setMemberid(groupMember.getMemberid());
        noCourseInfo.setMembername(groupMember.getMembername());
        noCourseInfo.setDepartmentid(groupMember.getDepartment());
        noCourseInfo.setCourse1((String) courseList.get(0));
        noCourseInfo.setCourse2((String) courseList.get(1));
        noCourseInfo.setCourse3((String) courseList.get(2));
        noCourseInfo.setCourse4((String) courseList.get(3));
        noCourseInfo.setCourse5((String) courseList.get(4));
        noCourseInfo.setCourse6((String) courseList.get(5));
        noCourseInfo.setCourse7((String) courseList.get(6));
        noCourseInfo.setCourse8((String) courseList.get(7));
        noCourseInfo.setCourse9((String) courseList.get(8));
        noCourseInfo.setCourse10((String) courseList.get(9));
        noCourseInfo.setCourse11((String) courseList.get(10));
        noCourseInfo.setCourse12((String) courseList.get(11));
        noCourseInfo.setCourse13((String) courseList.get(12));
        noCourseInfo.setCourse14((String) courseList.get(13));
        noCourseInfo.setCourse15((String) courseList.get(14));
        noCourseInfo.setCourse16((String) courseList.get(15));
        noCourseInfo.setCourse17((String) courseList.get(16));
        noCourseInfo.setCourse18((String) courseList.get(17));
        noCourseInfo.setCourse19((String) courseList.get(18));
        noCourseInfo.setCourse20((String) courseList.get(19));
        noCourseInfo.setCourse21((String) courseList.get(20));
        noCourseInfo.setCourse22((String) courseList.get(21));
        noCourseInfo.setCourse23((String) courseList.get(22));
        noCourseInfo.setCourse24((String) courseList.get(23));
        noCourseInfo.setCourse25((String) courseList.get(24));
        noCourseInfo.setCourse26((String) courseList.get(25));
        noCourseInfo.setCourse27((String) courseList.get(26));
        noCourseInfo.setCourse28((String) courseList.get(27));
        noCourseInfo.setCourse29((String) courseList.get(28));
        noCourseInfo.setCourse30((String) courseList.get(29));
        noCourseInfo.setCourse31((String) courseList.get(30));
        noCourseInfo.setCourse32((String) courseList.get(31));
        noCourseInfo.setCourse33((String) courseList.get(32));
        noCourseInfo.setCourse34((String) courseList.get(33));
        noCourseInfo.setCourse35((String) courseList.get(34));
        noCourseInfo.setCourse36((String) courseList.get(35));
        noCourseInfo.setCourse37((String) courseList.get(36));
        noCourseInfo.setCourse38((String) courseList.get(37));
        noCourseInfo.setCourse39((String) courseList.get(38));
        noCourseInfo.setCourse40((String) courseList.get(39));
        noCourseInfo.setCourse41((String) courseList.get(40));
        noCourseInfo.setCourse42((String) courseList.get(41));
        noCourseInfo.setCourse43((String) courseList.get(42));
        noCourseInfo.setCourse44((String) courseList.get(43));
        noCourseInfo.setCourse45((String) courseList.get(44));
        noCourseInfo.setCourse46((String) courseList.get(45));
        noCourseInfo.setCourse47((String) courseList.get(46));
        noCourseInfo.setCourse48((String) courseList.get(47));
        noCourseInfo.setCourse49((String) courseList.get(48));
        noCourseInfo.setCourse50((String) courseList.get(49));
        noCourseInfo.setCourse51((String) courseList.get(50));
        noCourseInfo.setCourse52((String) courseList.get(51));
        noCourseInfo.setCourse53((String) courseList.get(52));
        noCourseInfo.setCourse54((String) courseList.get(53));
        noCourseInfo.setCourse55((String) courseList.get(54));
        noCourseInfo.setCourse56((String) courseList.get(55));
        return noCourseInfoMapper.insertAllCourseInfo(noCourseInfo);
    }

    public int deleteByMemberid(String memberid) {
        return noCourseInfoMapper.deleteByMemberid(memberid);
    }
}
