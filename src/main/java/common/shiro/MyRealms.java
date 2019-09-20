package common.shiro;

import com.wxplatform.dao.WxMemberDAO;
import com.wxplatform.pojo.GroupMember;
import lombok.Setter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;

import org.apache.shiro.subject.PrincipalCollection;

import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @program: Wxplatform
 * @description: 自定义realm
 * @author: zhijie
 * @create: 2019-02-06 22:35
 **/
@Component
public class MyRealms extends AuthorizingRealm {

    //注入DAO ,同时在spring-shiro的自定义Realm进行配置
    @Setter
    public WxMemberDAO wxMemberDAO;



    private Log log = LogFactory.getLog(MyRealms.class);

    public String getName() {
        return "StudentRealm";
    }

    /*
    * @Description: 授权器，验证角色身份权限的API
    * @Param:  principalCollection
    * @return:  org.apache.shiro.authc.AuthenticationInfo
    *     返回封装获取的所有用户的角色AuthorizationInfo（<Set>String)
    * @Author:  zhijie
    * @Date: 2019/2/6
    */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


    /*
    * @Description:验证器，判断用户的登录  用户输入的账号密码封装成UserNamePasswordToken
    * SimpleAuthenticationInfo封装查询之后的结果
    * @Param: [authenticationToken]
    * @return: org.apache.shiro.authc.AuthenticationInfo
    * @Author:  zhijie
    * @Date: 2019/2/6
    */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //通过 token获取用户名，查询数据库返回用户信息
        String memberId = (String) authenticationToken.getPrincipal();
        GroupMember groupMember = wxMemberDAO.login(memberId);
        if (groupMember == null) {
            throw new AuthenticationException("账号不存在");
        }
         if(groupMember.getMemberstatus().equals("0")) {
            throw new AuthenticationException("该账号的信息未审核，无法登陆");
        }
        //参数：账号，密码，盐，Realm的名称
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(memberId, groupMember.getmemberpassword(), ByteSource.Util.bytes(memberId), getName());
        return simpleAuthenticationInfo;
    }

    //清空缓存
    public void clearEncache() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
