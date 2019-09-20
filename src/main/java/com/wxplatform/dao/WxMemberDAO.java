package com.wxplatform.dao;

import com.wxplatform.pojo.GroupMember;
import com.wxplatform.pojo.GroupMemberExample;
import com.wxplatform.pojo.NoCourseInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
* 用户登录信息设置接口
*
* */
@Repository
public interface WxMemberDAO {
    int getMemberCount(String openid);

    GroupMember wxGetTxMemberInfo(String openid);

    GroupMember selectMemberInfo(String openid);

    GroupMember login(String memberId);

    List<GroupMember> selectAllMember(GroupMemberExample example);

    List<GroupMember> selectMemberListWithPage();   //获取分页

    List<GroupMember> selectMemberListWithPagePass(String memberstatus, int currentpage);

    List<GroupMember> selectMemberListWithPageNoPass(String memberstatus);

    List<GroupMember> selectMemberByDepartment(Integer department);    //部长查看自驾小干的信息

    long wxMemberInsert(GroupMember groupMember);

    int updateMemberStatus(GroupMember groupMember, String openid);

    int updatePwdByMemberId(String memberpassword, String memberId);

    int deleteMemberInfo(String openid);

    int selectCountByMemberid(String memberid);

    int selectCountByStatus(String memberStauts);

    int selectCountByDepart(int department);

    List<GroupMember> selectDutyList(int week, String dutyxqday);

    List<GroupMember> selectDutys();

    GroupMember getNameAndDepartById(String memberId);


}
