package com.wxplatform.mapper;

import com.wxplatform.pojo.GroupMember;
import com.wxplatform.pojo.GroupMemberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupMemberMapper {
    int deleteByOpenId(String openid);

    int insert(GroupMember record);

    List<GroupMember> selectByExample(GroupMemberExample example);

    GroupMember selectByPrimaryKey(String openid);

    GroupMember selectmemberinfo(String openid);

    GroupMember login(String memberId);

    int selectCount(String openid);  //查看数据是否存在

    int selectCountByDepart(Integer department);

    int selectCountbymemberId(String memberid);

    int selectCountByStatus(String memberStatus);

    List<GroupMember> selectMemberListWithPage(String memberStatus);   //获取分页


    //获取分页
    List<GroupMember> selectMemberByDepartment(Integer department); //部长查看自家小干的信息

    int updateByPrimaryKeySelective(GroupMember record);

    int updateByPrimaryKey(GroupMember record);

    int updatePwdByMemberId(String memberId, String memberpassword);

    List<GroupMember> selectDutyList(@Param("week") int week, @Param("dutyxqday") String xqday);

    List<GroupMember> selectDutys();

    GroupMember getNameAndDepartById(String memberid);
}