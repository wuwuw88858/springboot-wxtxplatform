

import com.alibaba.fastjson.JSONObject;
import com.wxplatform.dao.WxMemberDAO;
import com.wxplatform.mapper.GroupMemberMapper;
import com.wxplatform.pojo.DepartmentInfo;
import com.wxplatform.pojo.GroupMember;
import com.wxplatform.pojo.GroupMemberExample;
import com.wxplatform.service.WxCourseService;
import com.wxplatform.service.WxGetOpenIdService;
import com.wxplatform.service.WxMemberInfoService;
import common.beans.ResultBean;
import common.exceptions.NullException;
import common.getlogin.GetSource;
import common.utils.NotNullCheckUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.subject.support.SubjectThreadState;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {
//        "file:src/main/resources/xml/applicationContext.xml",
//        "file:src/main/resources/xml/springMVC.xml" })
//@WebAppConfiguration
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class wxLoginTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("xml/springMVC.xml");
        System.out.println(context.getMessage("message", new Object[]{"lgh"}, Locale.SIMPLIFIED_CHINESE));
        System.out.println(context.getMessage("message", new Object[]{"lgh"}, Locale.US));
    }

    @Autowired
    WxMemberDAO wxMemberDAO;
    @Test
    public void testCourse() {
        String str = "Dsoft";

        Random r = new Random();
        for(int i = 0;i < 5;i++){
            str += r.nextInt(10);
        }
        System.out.println(str);
    }

    @Autowired
    WxCourseService wxCourseService;
    @Test
    public void testC() {
        System.out.println(wxCourseService.getAllMembersCourses(1));
    }
}
