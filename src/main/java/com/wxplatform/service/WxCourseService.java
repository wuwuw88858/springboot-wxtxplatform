package com.wxplatform.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import com.wxplatform.dao.WxCourseInfoDAO;
import com.wxplatform.dao.WxMemberDAO;
import com.wxplatform.pojo.NoCourseInfo;
import common.exceptions.FailException;
import common.redis.JedisTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

import static common.utils.NotNullCheckUtils.NotNullInt;

/**
 * @program: wxpaltform-master
 * @description: 课程服务层
 * @author: zhijie
 * @create: 2019-04-13 15:21
 **/
@Service
public class WxCourseService {

    @Value("${schoolyear}")
    private String schoolyear;
    @Value("${semester}")
    private String semester;
    private static final String MON = "星期1";
    private static final String TUES = "星期2";
    private static final String WED = "星期3";
    private static final String THURS = "星期4";
    private static final String FRI = "星期5";
    private static final String SAT = "星期6";
    private static final String SUN = "星期7";
    //    private static final String FIRSTCOURSE = "1 - 2 节09:00 - 10:20";
//    private static final String SECONDCOURSE = "3 - 4 节10:40 - 12:00";
//    private static final String THIRDCOURSE = "5 - 6 节12:30 - 13:50";
//    private static final String FORTHCOURSE = "7 - 8 节14:00 - 15:20";
//    private static final String FIFTHCOURSE = "9 - 10 节15:30 - 16:50";
//    private static final String SIXTHCOURSE = "11 - 12 节17:00 - 18:20";
//    private static final String SEVENTHCOURSE = "13 - 14 节19:00 - 20:20";
//    private static final String EIGHTCOURSE = "15 - 16 节20:30 - 21:50";
    private static final String FIRSTCOURSE = "1 - 2 节09:00 - 10:20";
    private static final String SECONDCOURSE = "3 - 4 节10:40 - 12:00";
    private static final String THIRDCOURSE = "5 - 6 节12:30 - 13:50";
    private static final String FORTHCOURSE = "7 - 8 节14:00 - 15:20";
    private static final String FIFTHCOURSE = "9 - 10 节15:30 - 16:50";
    private static final String SIXTHCOURSE = "11 - 12 节17:00 - 18:20";
    private static final String SEVENTHCOURSE = "13 - 14 节19:00 - 20:20";
    private static final String EIGHTCOURSE = "15 - 16 节20:30 - 21:50";
    @Autowired
    private WxCourseInfoDAO wxCourseInfoDAO;

    @Autowired
    private JedisTemplate jedisTemplate;


    JSON json = new JSONObject();

    private static final Logger logger =
            LoggerFactory.getLogger(WxCourseInfoDAO.class);

    @Autowired
    ConcurrentSkipListMap<String, Object> concurrentSkipListMap;

    @Transactional
    public int insertAllCourses(String username, String password) {
        memberidIsExist(username, schoolyear, semester);
        return wxCourseInfoDAO.insertAllCourseInfo(username, password, schoolyear, semester);
    }

    @Transactional(readOnly = true)
    public List<Map> getAllMembersCourses(int department) {
        List<NoCourseInfo> getCourses = wxCourseInfoDAO.selectAllCourseInfo(department);
        courseListIsExist(department);
        String index1 = null;
        String index2 = null;
        String index3 = null;
        String index4 = null;
        String index5 = null;
//        String index6 = null;
//        String index7 = null;
        String index8 = null;
        String index9 = null;
        String index10 = null;
        String index11 = null;
        String index12 = null;
//        String index13 = null;
//        String index14 = null;
//        String index15 = null;
//        String index16 = null;
//        String index17 = null;
//        String index18 = null;
//        String index19 = null;
//        String index20 = null;
//        String index21 = null;
        String index22 = null;
        String index23 = null;
        String index24 = null;
        String index25 = null;
        String index26 = null;
//        String index27 = null;
//        String index28 = null;
        String index29 = null;
        String index30 = null;
        String index31 = null;
        String index32 = null;
        String index33 = null;
//        String index34 = null;
//        String index35 = null;
        String index36 = null;
        String index37 = null;
        String index38 = null;
        String index39 = null;
        String index40 = null;
//        String index41 = null;
//        String index42 = null;
        String index43 = null;
        String index44 = null;
        String index45 = null;
        String index46 = null;
        String index47 = null;
//        String index48 = null;
//        String index49 = null;
        String index50 = null;
        String index51 = null;
        String index52 = null;
        String index53 = null;
        String index54 = null;
//        String index55 = null;
//        String index56 = null;


        List<Map> list = new ArrayList<>();
        String[] skjc = new String[]{FIRSTCOURSE, SECONDCOURSE, FORTHCOURSE, FIFTHCOURSE, SIXTHCOURSE, SEVENTHCOURSE, EIGHTCOURSE};
        String[] xqj = new String[]{MON, TUES, WED, THURS, FRI};
        for (int i = 0; i < getCourses.size(); i++) {
           if (i == 0) {
            index1 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse1();

            index2 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse2();

            index3 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse3();

            index4 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse4();

            index5 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse5();

//                index6 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse6();
//                index7 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse7();
            index8 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse8();

            index9 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse9();

            index10 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse10();

            index11 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse11();

            index12 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse12();

            index22 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse22();

            index23 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse23();

            index24 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse24();

            index25 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse25();

            index26 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse26();

            index29 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse29();

            index30 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse30();

            index31 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse31();

            index32 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse32();

            index33 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse33();

            index36 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse36();

            index37 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse37();

            index38 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse38();

            index39 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse39();

            index40 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse40();

            index43 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse43();

            index44 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse44();

            index45 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse45();

            index46 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse46();

            index47 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse47();

            index50 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse50();

            index51 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse51();

            index52 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse52();

            index53 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse53();

            index54 = getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse54();

                continue;
            }
            index1 = index1.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse1());
            index2 = index2.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse2());
            index3 = index3.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse3());
            index4 = index4.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse4());
            index5 = index5.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse5());
//            index6 = index6.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse6());
//            index7 = index7.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse7());
            index8 = index8.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse8());
            index9 = index9.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse9());
            index10 = index10.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse10());
            index11 = index11.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse11());
            index12 = index12.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse12());
//            index13 = index13.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse13());
//            index14 = index14.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse14());
          //  index15 = index15.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse15());
         //   index16 = index16.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse16());
          //  index17 = index17.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse17());
         //   index18 = index18.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse18());
         //   index19 = index19.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse19());
//            index20 = index20.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse20());
//            index21 = index21.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse21());
            index22 = index22.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse22());
            index23 = index23.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse23());
            index24 = index24.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse24());
            index25 = index25.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse25());
            index26 = index26.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse26());
//            index27 = index27.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse27());
//            index28 = index28.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse28());
            index29 = index29.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse29());
            index30 = index30.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse30());
            index31 = index31.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse31());
            index32 = index32.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse32());
            index33 = index33.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse33());
//            index34 = index34.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse34());
//            index35 = index35.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse35());
            index36 = index36.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse36());
            index37 = index37.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse37());
            index38 = index38.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse38());
            index39 = index39.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse39());
            index40 = index40.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse40());
//            index41 = index41.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse41());
//            index42 = index42.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse42());
            index43 = index43.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse43());
            index44 = index44.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse44());
            index45 = index45.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse45());
            index46 = index46.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse46());
            index47 = index47.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse47());
//            index48 = index48.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse48());
//            index49 = index49.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse49());
            index50 = index50.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse50());
            index51 = index51.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse51());
            index52 = index52.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse52());
            index53 = index53.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse53());
            index54 = index54.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse54());
//            index55 = index55.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse55());
//            index56 = index56.concat(", " + getCourses.get(i).getMembername() + ":" + getCourses.get(i).getCourse56());
        }


        String[] course = new  String[]{index1, index2, index3, index4, index5,
                index8, index9, index10, index11, index12,
                index22, index23, index24, index25, index26,
                index29, index30, index31, index32, index33,
                index36, index37, index38, index39, index40,
                index43, index44, index45, index46, index47,
                index50, index51, index52, index53, index54};
        int z = 0;
        for (int i = 0; i < skjc.length; i++) {
            for (int j = 0; j < xqj.length; j++) {
                Map<String, Object> mondayfirstcourseMap = new HashMap<>();
                mondayfirstcourseMap.put("xqj", xqj[j]);
                mondayfirstcourseMap.put("skjc", skjc[i]);
                mondayfirstcourseMap.put("kcmc", course[z]);
                z += 1;
                list.add(mondayfirstcourseMap);
            }
        }
        return list;
    }

    /*
        * @Description:  查找该学号的信息是否有录入到数据库中
        * @Param: [memberid]
        * @return: int
        * @Author:  zhijie
        * @Date: 2019/4/17
*/
    public int selectCountbymemberId(String memberid) {
        int count = wxCourseInfoDAO.selectCountbymemberId(memberid);
        NotNullInt(count, "membercour.is.null");
        return count;
    }

    private boolean memberidIsExist(String memberid, String schoolyear, String semester) {
        int memberList = wxCourseInfoDAO.selectCountbymemberId(memberid);
        if (memberList != 0) {
            throw new FailException("您的" + schoolyear + "学年第" + semester + "学期的无课表已经录入！");
        } else {
            return true;
        }
    }

    private boolean courseListIsExist(int department) {
        int memberList = wxCourseInfoDAO.selectCountbydepartment(department);
        if (memberList == 0) {
            throw new FailException("该部门暂未录入课表或部门所有人都有课！");
        } else {
            return true;
        }
    }
}
