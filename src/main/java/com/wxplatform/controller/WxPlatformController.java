package com.wxplatform.controller;
import com.alibaba.fastjson.JSONObject;
import com.wxplatform.pojo.DateTrip;
import com.wxplatform.pojo.GroupMember;
import com.wxplatform.service.*;
import common.beans.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static common.utils.otherUtils.GetTimeUtils.getWeekTime;


@RestController
@RequestMapping("/txplatform")
public class WxPlatformController {

    @Autowired
    WxGetOpenIdService wxGetOpenIdService;
    @Autowired
    WxMemberInfoService wxMemberInfoService;
    @Autowired
    WxDateTripService wxDateTripService;
    @Autowired
    WxDutyService wxDutyService;
    @Autowired
    WxCourseService wxCourseService;

    /**
     * @ClassName:getOpenId
     * @Description: 获取用户的code
     * @Author: zhijie
     * @CreateDate: 2018/11/24 14:59
     * @RequestMethod:post
     * @Param [code]
     */

    @PostMapping(value = "getopenid")
    public ResultBean<JSONObject> getOpenId(@RequestParam("code") String code) {
        return new ResultBean<JSONObject>(wxGetOpenIdService.getOpenId(code), "获取openid成功", String.valueOf(getWeekTime()));
    }

    /**
     * @Description:在登录小程序之后，添加个人信息的方法 0：待审核，1 已审核
     * @Param: [groupMember]
     * @return: common.beans.ResultBean<java.lang.Long>
     * @Author: zhijie
     * @Date: 2019/2/11
     */
    @PostMapping(value = "addtxmemberinfo")
    public ResultBean<Long> addTxMember(GroupMember groupMember) {
        return new ResultBean<Long>(wxMemberInfoService.addMemberInfo(groupMember), "添加成功，等待审核");
    }

    /**
     * @Description: 小程序端获取个人的信息, 并以map的形式返回
     * @Author: zhijie
     * @CreateDate: 2018/11/24 15:10
     * @RequestMethod:POST
     * @Param [openid]
     * @Return [groupMember]
     * @Exception [code :11000]
     */
    @PostMapping(value = "gettxmemberinfo")
    public ResultBean getTxMemberInfo(@RequestParam("openid") String openid) {
        return new ResultBean(wxMemberInfoService.getTxMemberInfo(openid), "查询成功");
    }


//    @PostMapping(value = "getcourse")
//    public ResultBean getCourse(@RequestParam("username") String username,
//                                @RequestParam("password") String password,
//                                @RequestParam(value = "schoolyear") String schoolyear,
//                                @RequestParam("semester") String semester) {
//        return new ResultBean(wxMemberInfoService.getCourse(username, password, schoolyear, semester), "查找课表成功");
//    }
//
//    @PostMapping(value = "getnocourse")
//    public ResultBean getNoCourse(@RequestParam("username") String username,
//                                  @RequestParam("password") String password,
//                                  @RequestParam("schoolyear") String schoolyear,
//                                  @RequestParam("semester") String semester) {
//        return new ResultBean(wxMemberInfoService.getNoCourse(username, password, schoolyear, semester), "查找无课表成功");
//    }

    /**
     * @Description: 通过分页查找本周的已经审核通过的所有的周程，用在小程序前端
     * @Param: [week, currentPage]
     * @return: common.beans.ResultBean<com.github.pagehelper.PageInfo<com.wxplatform.pojo.DateTrip>>
     * @Author: zhijie
     * @Date: 2018/12/25
     */
    @GetMapping(value = "selectdatetripwithpagethisweek")
    public ResultBean selectDateTripWithPageThisWeek(@RequestParam("thisweek") int week,
                                                     @RequestParam(value = "page") int currentPage) {
        return new ResultBean(wxDateTripService.selectDateTripByPassWithPageThisWeek(week, currentPage), "查找成功");
    }

    /**
     * @Description: 查找某个星期的周程内容, 小程序端
     * @Param: [week, xqday]
     * @return: common.beans.ResultBean<java.util.concurrent.ConcurrentSkipListMap>
     * @Author: zhijie
     * @Date: 2018/12/30
     */
    @GetMapping(value = "selectdatetripbyxqday")
    public ResultBean selectDateTripByXqday(@RequestParam("xqday") String xqday) {

        return new ResultBean(wxDateTripService.selectDateTripByXqday(xqday), "查找成功");
    }

    /**
     * @Description: 查看周程的详细内容
     * @Param: [dateTripId]
     * @return: common.beans.ResultBean<java.util.concurrent.ConcurrentSkipListMap>
     * @Author: zhijie
     * @Date: 2018/12/30
     */
    @GetMapping(value = "selectdatetripdetail")
    public ResultBean<DateTrip> selectDateTripDetail(@RequestParam("datetripid") String dateTripId) {
        return new ResultBean<DateTrip>(wxDateTripService.selectDateTripDetail(dateTripId), "查找成功");
    }



    @GetMapping(value = "getdutylist")
    public ResultBean getDutyList(@RequestParam("dutyweek")int week, @RequestParam("dutyxqday") String dutyxqday) {
        return new ResultBean(wxDutyService.getDutyListByXqday(week, dutyxqday), "查询成功");
    }

    @PostMapping(value = "insertnocourse")
    public ResultBean insertAllCourses(@RequestParam("username") String username,
                                        @RequestParam("password") String password
    ) {
        return new ResultBean(wxCourseService.insertAllCourses(username, password), "插入成功");
    }
    @GetMapping(value = "getnocoursebydepart")
    public ResultBean genocoursebydepart(@RequestParam("department") int department) {
        return new ResultBean(wxCourseService.getAllMembersCourses(department), "查找成功");
    }

    @GetMapping(value = "getmembernocoursecount")
    public ResultBean getNoCourseMemberCount(@RequestParam("memberid") String memberid) {
        return new ResultBean(wxCourseService.selectCountbymemberId(memberid), "已录入课程信息");
    }

}
