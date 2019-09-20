package com.wxplatform.controller;

import com.github.pagehelper.PageInfo;
import com.wxplatform.dao.WxDateTripDAO;
import com.wxplatform.pojo.DateTrip;
import com.wxplatform.service.WxDateTripService;
import common.beans.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @program: Wxplatform
 * @description: 关于周程的控制器
 * @author: zhijies
 * @create: 2018-12-17 17:40
 **/
@RestController
@RequestMapping("/txbackstagedatetrip")
public class WxBackstageDateTripsController {

    @Autowired
    WxDateTripService wxDateTripService;

    /*
      * @Description:  部长添加周程至周程列表
      * @Param: [dateTrip]
      * @return: common.beans.ResultBean<java.lang.Long>
      * @Author:  zhijie
      * @Date: 2018/12/20
      */
    @PostMapping(value = "adddatetrip")
    public ResultBean<Long> addDateTrip( DateTrip dateTrip) {
        return new ResultBean<Long>(wxDateTripService.addDateTrip(dateTrip),"添加成功，等待审核");

    }

    /*
            * @Description:  修改周程状态
            * @Param: [dateTrip, dateTripId]
            * @return: common.beans.ResultBean<java.lang.Integer>
            * @Author:  zhijie
            * @Date: 2018/12/24
            */
    @PostMapping(value = "updatedatetrip")
    public ResultBean<Integer> updateStatus(DateTrip dateTrip, @RequestParam("datetripid") String dateTripId) {
        return new ResultBean<Integer>(wxDateTripService.updateDateTripStatus(dateTrip, dateTripId),"确认成功");
    }

    /*
* @Description:  通过分页查找审核通过的周程
* @Param: [week, currentPage]
* @return: common.beans.ResultBean<com.github.pagehelper.PageInfo<com.wxplatform.pojo.DateTrip>>
* @Author:  zhijie
* @Date: 2018/12/25
*/
    @GetMapping(value = "selectdatetrippasswithpage")
    public ResultBean<Map> selectDateTripPassWithPage(@RequestParam("week") int week,
                                                      @RequestParam("currentpage") Integer currentPage) {


        return new ResultBean<Map>(wxDateTripService.selectDateTripByPassWithPageThisWeek(week, currentPage),"查找成功");
    }




    /*
     * @Description: 查找未通过的周程接口
     * @Param: [week, currentPage]
     * @return: common.beans.ResultBean<com.github.pagehelper.PageInfo<com.wxplatform.pojo.DateTrip>>
     * @Author:  zhijie
     * @Date: 2018/12/25
     */
    @GetMapping(value = "selectdatetripnopasswithpage")
    public ResultBean selectDateTripNoPassWithPage(@RequestParam("week") int week,
                                                   @RequestParam(value = "currentpage") int page) {
        return new ResultBean(wxDateTripService.selectDateTripNoPassWithPageNextWeek(page, week),"查找成功");
    }
    /*
      * @Description:  删除接口
      * @Param: [datetripId]
      * @return: common.beans.ResultBean<java.lang.Integer>
      * @Author:  zhijie
      * @Date: 2018/12/26
      */
    @PostMapping(value = "deletedatetrip")
    public ResultBean<Integer> deleteDateTrip(@RequestParam("datetripid") String datetripId) {
        return new ResultBean<Integer>(wxDateTripService.deleteDateTrip(datetripId),"删除成功");
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

}
