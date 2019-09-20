package com.wxplatform.dao.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wxplatform.dao.WxMemberDAO;
import com.wxplatform.mapper.DutyInfoMapper;
import com.wxplatform.mapper.GroupMemberMapper;
import com.wxplatform.mapper.NoCourseInfoMapper;
import com.wxplatform.pojo.GroupMember;
import com.wxplatform.pojo.GroupMemberExample;
import com.wxplatform.pojo.NoCourseInfo;
import common.getlogin.GetSource;
import common.redis.JedisTemplate;
import common.utils.otherUtils.RedisPageHelper;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@Repository
public class WxMemberDAOImpl implements WxMemberDAO {

    private static final Logger log = LoggerFactory.getLogger(WxMemberDAOImpl.class);
    @Autowired
    GroupMemberMapper groupMemberMapper;
    @Autowired
    DutyInfoMapper dutyInfoMapper;

    @Autowired
    NoCourseInfoMapper noCourseInfoMapper;

    @Autowired
    JedisTemplate jedisTemplate;

    @Autowired
    RedisPageHelper redisPageHelper;
    JSON json = new JSONObject();

    @PostConstruct
    public void init() {
    }
////插入课表
//    public int insert() {
//        NoCourseInfo noCourseInfo = new NoCourseInfo();
//        List a = GetSource.getNoCourseList("1640129234", "16440114102138",
//                "2018", "2");
//        noCourseInfo.setMemberid("1640129234");
//        noCourseInfo.setCourse1((String) a.get(0));
//        noCourseInfo.setCourse2((String) a.get(1));
//        noCourseInfo.setCourse3((String) a.get(2));
//        noCourseInfo.setCourse4((String) a.get(3));
//        noCourseInfo.setCourse5((String) a.get(4));
//        noCourseInfo.setCourse6((String) a.get(5));
//        noCourseInfo.setCourse7((String) a.get(6));
//        noCourseInfo.setCourse8((String) a.get(7));
//        noCourseInfo.setCourse9((String) a.get(8));
//        noCourseInfo.setCourse10((String) a.get(9));
//        noCourseInfo.setCourse11((String) a.get(10));
//        noCourseInfo.setCourse12((String) a.get(11));
//        noCourseInfo.setCourse13((String) a.get(12));
//        noCourseInfo.setCourse14((String) a.get(13));
//        noCourseInfo.setCourse15((String) a.get(14));
//        noCourseInfo.setCourse16((String) a.get(15));
//        noCourseInfo.setCourse17((String) a.get(16));
//        noCourseInfo.setCourse18((String) a.get(17));
//        noCourseInfo.setCourse19((String) a.get(18));
//        noCourseInfo.setCourse20((String) a.get(19));
//        noCourseInfo.setCourse21((String) a.get(20));
//        noCourseInfo.setCourse22((String) a.get(21));
//        noCourseInfo.setCourse23((String) a.get(22));
//        noCourseInfo.setCourse24((String) a.get(23));
//        noCourseInfo.setCourse25((String) a.get(24));
//        noCourseInfo.setCourse26((String) a.get(25));
//        noCourseInfo.setCourse27((String) a.get(26));
//        noCourseInfo.setCourse28((String) a.get(27));
//        noCourseInfo.setCourse29((String) a.get(28));
//        noCourseInfo.setCourse30((String) a.get(29));
//        noCourseInfo.setCourse31((String) a.get(30));
//        noCourseInfo.setCourse32((String) a.get(31));
//        noCourseInfo.setCourse33((String) a.get(32));
//        noCourseInfo.setCourse34((String) a.get(33));
//        noCourseInfo.setCourse35((String) a.get(34));
//        noCourseInfo.setCourse36((String) a.get(35));
//        noCourseInfo.setCourse37((String) a.get(36));
//        noCourseInfo.setCourse38((String) a.get(37));
//        noCourseInfo.setCourse39((String) a.get(38));
//        noCourseInfo.setCourse40((String) a.get(39));
//        noCourseInfo.setCourse41((String) a.get(40));
//        noCourseInfo.setCourse42((String) a.get(41));
//        noCourseInfo.setCourse43((String) a.get(42));
//        noCourseInfo.setCourse44((String) a.get(43));
//        noCourseInfo.setCourse45((String) a.get(44));
//        noCourseInfo.setCourse46((String) a.get(45));
//        noCourseInfo.setCourse47((String) a.get(46));
//        noCourseInfo.setCourse48((String) a.get(47));
//        noCourseInfo.setCourse49((String) a.get(48));
//        noCourseInfo.setCourse50((String) a.get(49));
//        noCourseInfo.setCourse51((String) a.get(50));
//        noCourseInfo.setCourse52((String) a.get(51));
//        noCourseInfo.setCourse53((String) a.get(52));
//        noCourseInfo.setCourse54((String) a.get(53));
//        noCourseInfo.setCourse55((String) a.get(54));
//        noCourseInfo.setCourse56((String) a.get(55));
//        return noCourseInfoMapper.insertCourse(noCourseInfo);
//    }

//    //查找所有人的无课表
//    public List<NoCourseInfo> getAllMembersCourse() {
//        return noCourseInfoMapper.selectAllCourse();
//    }

    /*
     * @Description:  通过memberid 获取 姓名和所属部门，传入到nocourse表中
     * @Param: [memberid]
     * @return: com.wxplatform.pojo.GroupMember
     * @Author:  zhijie
     * @Date: 2019/4/13
     */
    public GroupMember getNameAndDepartById(String memberid) {
      return groupMemberMapper.getNameAndDepartById(memberid);
    }

    public int selectCountByStatus(String memberStatus) {
        return groupMemberMapper.selectCountByStatus(memberStatus);
    }

    public int selectCountByDepart(int department) {

        return groupMemberMapper.selectCountByDepart(department);
    }

    public int getMemberCount(String openid)
    {
        return groupMemberMapper.selectCount(openid);
    }

    /**
     * @Description: 只有mybatis内置sql语句查找所有成员
     * @Param: [example]
     * @return: java.util.List<com.wxplatform.pojo.GroupMember>
     * @Author: zhijie
     * @Date: 2019/4/1
     */
    public List<GroupMember> selectAllMember(GroupMemberExample example) {
        GroupMemberExample groupMemberExample = new GroupMemberExample();
        return groupMemberMapper.selectByExample(groupMemberExample);
    }

    /**
     * @Description: 获取所有学生的信息以及状态
     * 判断从数据库查询的总数是否和redis中的 字符member_list一致
     * 如果不一致，则从数据库中查找并返回队列 同时使用hmset将所有的数据存入到redis中，key 为member_list
     * 否则直接从缓存中获取
     * 使用hmgetall key 能获取所有值
     * @Param: []
     * @return: java.util.List<com.wxplatform.pojo.GroupMember>
     * @Author: zhijie
     * @Date: 2019/3/25
     */
    @Override
    public List<GroupMember> selectMemberListWithPage() {
        List<GroupMember> groupMemberList;
        HashMap<String, String> listMap = new HashMap<String, String>();
        int count = getMemberCount(null);
        if (count != jedisTemplate.hlen("member_list:")) {
            groupMemberList = groupMemberMapper.selectMemberListWithPage(null);
            for (GroupMember groupMember : groupMemberList) {
                listMap.put(groupMember.getOpenid(), json.toJSONString(groupMember));
            }
            jedisTemplate.hmset("member_list:", listMap);
            return groupMemberList;
        } else {
            return json.parseArray(jedisTemplate.hvals("member_list:").toString(), GroupMember.class);
        }
    }

    /**
     * @Description: 分页查看信息通过审核/没通过审核的成员信息,只将审核通过的存入缓存
     * @Param: [memberstatus]
     * @return: java.util.List<com.wxplatform.pojo.GroupMember>
     * @Author: zhijie
     * @Date: 2019/2/15
     */
    @Override
    public List<GroupMember> selectMemberListWithPagePass(String memberstatus, int currentpage) {
        return groupMemberMapper.selectMemberListWithPage(memberstatus);

    }

    @Override
    public List<GroupMember> selectMemberListWithPageNoPass(String memberstatus) {
        return groupMemberMapper.selectMemberListWithPage(memberstatus);

    }


    /**
     * @Description:部长获取自己小干的个人信息，如果redis的数目与数据库中的不符合 则从数据库中查找并重新写入到reids中
     * @Param: [department]
     * @return: java.util.List<com.wxplatform.pojo.GroupMember>
     * @Author: zhijie
     * @Date: 2018/12/6
     */
    @Override
    public List<GroupMember> selectMemberByDepartment(Integer department) {
        return groupMemberMapper.selectMemberByDepartment(department);
    }


    /**
     * @Description: 获取自己的个人信息，先从缓存中获取，如果没有就从数据库中获取
     * @Param: [openid]
     * @return: com.wxplatform.pojo.GroupMember
     * @Author: zhijie
     * @Date: 2018/12/6
     */
    @Override
    public GroupMember wxGetTxMemberInfo(String openid) {
        GroupMember groupMemberInfo;
           groupMemberInfo = groupMemberMapper.selectmemberinfo(openid);
           return groupMemberInfo;
    }


    /**
     * @Description: 登录
     * @Param: [memberId]
     * @return: com.wxplatform.pojo.GroupMember
     * @Author: zhijie
     * @Date: 2019/2/8
     */
    @Override
    public GroupMember login(String memberId) {
        return groupMemberMapper.login(memberId);
    }

    /**
     * @Description：创建新用户 默认状态为待审核（0） 并创建默认密码0 进行MD5加密
     * @Param: [groupMember]
     * @return: long
     * @Author: zhijie
     * @Date: 2019/2/11
     */
    public long wxMemberInsert(GroupMember groupMember) {
        groupMember.setMemberstatus("0");
        // Md5Hash sourse:默认密码 salt:账号 加密次数：31次
        Md5Hash md5Hash = new Md5Hash("1000", groupMember.getMemberid(), 31);
        groupMember.setmemberpassword(md5Hash.toString());
        return groupMemberMapper.insert(groupMember);
    }

    /**
     * @Description:更新账号密码
     * @Param: [memberpassword, memberId]
     * @return: int
     * @Author: zhijie
     * @Date: 2019/4/1
     */
    public int updatePwdByMemberId(String memberpassword, String memberId) {
        Md5Hash md5Hash = new Md5Hash(memberpassword, memberId, 31);
        return groupMemberMapper.updatePwdByMemberId(md5Hash.toString(), memberId);
    }

    /**
     * @Description: 后台更新个人信息 未审核--->已审核，
     * 同时将个人信息存放到缓存中String和SET类型中
     * @Param: [groupMember, openid]
     * @return: int
     * @Author: zhijie
     * @Date: 2019/2/22
     */
    public int updateMemberStatus(GroupMember groupMember, String openid) {
        groupMember.setOpenid(openid);
        groupMember.setMemberstatus("1");
        int updateStatus = groupMemberMapper.updateByPrimaryKeySelective(groupMember);
        return updateStatus;
    }

    public GroupMember selectMemberInfo(String openid) {
        return groupMemberMapper.selectmemberinfo(openid);
    }

    /**
     * @Description: 删除个人信息
     * @Param: [openid]
     * @return: int
     * @Author: zhijie
     * @Date: 2019/4/1
     */
    public int deleteMemberInfo(String openid) {
        //需要先找到memberid 在根据memberid删除
        return groupMemberMapper.deleteByOpenId(openid);
    }

    /**
     * @Description:通过id查改改用户是否存在
     * @Param: [memberid]
     * @return: int
     * @Author: zhijie
     * @Date: 2019/4/1
     */
    @Override
    public int selectCountByMemberid(String memberid) {
        return groupMemberMapper.selectCountbymemberId(memberid);
    }

    /**
     * @Description:获取每天值班的同学
     * @Param: [dutyxqday]
     * @return: java.util.List<com.wxplatform.pojo.GroupMember>
     * @Author: zhijie
     * @Date: 2019/4/1
     */
    @Override
    public List<GroupMember> selectDutyList(int week, String dutyxqday) {
        List<GroupMember> groupMemberList = groupMemberMapper.selectDutyList(week, dutyxqday);
        return groupMemberList;
    }

    @Override
    public List<GroupMember> selectDutys() {
        return groupMemberMapper.selectDutys();
    }


}
