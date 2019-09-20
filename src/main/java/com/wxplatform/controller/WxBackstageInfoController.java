package com.wxplatform.controller;

import com.wxplatform.pojo.DutyInfo;
import com.wxplatform.pojo.GroupMember;
import com.wxplatform.service.WxDutyService;
import com.wxplatform.service.WxMemberInfoService;
import common.beans.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static common.utils.otherUtils.GetTimeUtils.getWeekTime;


/*后台控制器*/

@RestController
@RequestMapping("/txbackstage")
public class WxBackstageInfoController {

    @Autowired
    WxMemberInfoService wxMemberInfoService;
    @Autowired
    WxDutyService wxDutyService;

    /*
     * @Description:  在访问网页后台时候，都要进行登录，初始密码为1000
     *                如果登录的对象的审核还未通过，账号输入正确，密码输入错误，都会显示审核未通过
     *                只有在审核通过之后，登录的时候才会进行账号密码的校验
     * @Param: [memberid, password]
     * @return: common.beans.ResultBean
     * @Author:  zhijie
     * @Date: 2019/3/23
     */
    @PostMapping(value = "login")
    public ResultBean login(@RequestParam("username") String memberid, @RequestParam("password") String password) {
        return new ResultBean(wxMemberInfoService.login(memberid, password), "登录成功",String.valueOf(getWeekTime()));
    }

    /*
      * @Description:  登出操作，Shiro框架会自动获取当前的登录对象，做退出操作
      * @Param: []
      * @return: common.beans.ResultBean
      * @Author:  zhijie
      * @Date: 2019/3/23
      */
    @GetMapping(value = "logout")
    public ResultBean logout() {
        return new ResultBean(wxMemberInfoService.logout(), "退出成功");
    }


    @PostMapping(value = "updatepassword")
    public ResultBean updatePwd(@RequestParam("memberpassword") String memberpassword, @RequestParam("memberid") String memberId) {
        return new ResultBean(wxMemberInfoService.updateMemberPassword(memberpassword, memberId), "修改密码成功");
    }

    /*
     * @Description:  遍历所有干部的身份信息，每一页的总数是10个
     * @Param: [currentPage]
     * @return: common.beans.ResultBean
     * @Author:  zhijie
     * @Date: 2019/3/23
     */
    @GetMapping(value = "getmemberlist")
    public ResultBean GetMemberList(@RequestParam("currentpage") Integer currentPage) {
        return new ResultBean(wxMemberInfoService.getMemberList(currentPage), "查询成功");
    }

    /*
   * @Description:  通过审核的状态查询学生的信息 0代表未审核，1代表审核通过
   * @Param: [currentPage, memberstatus]
   * @return: common.beans.ResultBean
   * @Author:  zhijie
   * @Date: 2019/3/25
   */
    @GetMapping(value = "getmemberlistpass")
    public ResultBean getMemberListPass(@RequestParam("currentpage") Integer currentPage) {

        return new ResultBean(wxMemberInfoService.getMemberListPass(currentPage), "查询成功");
    }

    /*
     * @Description:  通过审核的状态查询学生的信息 0代表未审核，1代表审核通过
     * @Param: [currentPage, memberstatus]
     * @return: common.beans.ResultBean
     * @Author:  zhijie
     * @Date: 2019/3/25
     */
    @GetMapping(value = "getmemberlistnopass")
    public ResultBean getMemberListNoPass(@RequestParam("currentpage") Integer currentPage) {
        return new ResultBean(wxMemberInfoService.getMemberListNoPass(currentPage), "查询成功");
    }

    /*
      * @Description:通过部门查找
      * @Param: [department]
      * @return: common.beans.ResultBean
      * @Author:  zhijie
      * @Date: 2019/3/25
      */
    @GetMapping(value = "getmemberlistbydepartment")
    public ResultBean getMemberListByDepartment(@RequestParam("department") Integer department) {
        return new ResultBean(wxMemberInfoService.getMemberListByDepartment(department), "查询成功");
    }

    /**
     * @ClassName:updateMemberStatus
     * @Description: 若审核通过，则改变用户的状态
     * @Author: zhijie
     * @CreateDate: 2018/11/24 15:3
     * @RequestMethod:post
     * @Param [openid]
     * @Return [code]
     */
    @PostMapping(value = "updatamemberstatus")
    public ResultBean<Integer> updateMemberStatus(GroupMember groupMember, @RequestParam("openid") String openid) {
        return new ResultBean<Integer>(wxMemberInfoService.updataMemberInfoByPrimaryKey(groupMember, openid), "确认成功");
    }

    /**
     * @ClassName:deleteMemberInfo
     * @Description: 删除用户个人信息
     * @Author: zhijie
     * @CreateDate: 2018/11/24 15:15
     * @RequestMethod:post
     * @Param [openid]
     * @Return [code]
     */
    @PostMapping(value = "deletememberinfo")
    public ResultBean<Integer> deleteMemberInfo(@RequestParam("openid") String openid) {
        return new ResultBean<Integer>(wxMemberInfoService.deleteMemberInfo(openid), "删除成功");
    }

    /*
* @Description:批量添加值班人员
* @Param: [dutyInfoList]
* @return: common.beans.ResultBean
* @Author:  zhijie
* @Date: 2019/4/2
*/
    @PostMapping(value = "adddutymemberinfo")
    public ResultBean insertDutyInfo(@RequestBody List<DutyInfo> dutyInfoList) {

        return new ResultBean(wxDutyService.insertDutyInfoList(dutyInfoList), "添加成功");
    }

    @GetMapping(value = "getdutylist")
    public ResultBean getDutyList() {
        return new ResultBean(wxDutyService.getDutyList(), "查询成功");
    }

    @PostMapping(value = "deletedutyid")
    public ResultBean delDuty(@RequestParam("dutyid") String dutyId) {
        return new ResultBean(wxDutyService.delDutyInfo(dutyId), "删除成功");
    }
}
