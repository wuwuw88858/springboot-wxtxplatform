package common.getlogin;

import common.exceptions.NullException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.shiro.authc.IncorrectCredentialsException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static common.getlogin.GetHiddenValue.getHiddenName;

/**
 * @program: Wxplatform
 * @description: 模拟登陆
 * @author: zhijie
 * @create: 2019-03-01 14:46
 **/
public class SiseLogin {

    //模拟登陆地址
    static final String loginUrl = "http://class.sise.com.cn:7001/sise/login_check_login.jsp";

    static final String logoutUrl = "http://class.sise.com.cn:7001/sise/common/sessionSetNull.jsp";
    //重定向地址
    static String sourceUrl = "http://class.sise.com.cn:7001"
            + "/sise/module/student_schedular/student_schedular.jsp?";
    //响应
    static HttpResponse httpResponse;
    //响应体
    static String responseBody;
    public static boolean isAuthc;
    private static DefaultHttpClient httpClient = new DefaultHttpClient();
    static List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();


    public static String login(String studentName, String password, String schoolyear, String semester) {

        if (isAuthc() == true) {
            logout(studentName, password, schoolyear, semester);
        } else {
            if (studentName.isEmpty() || studentName.length() == 0) {
                throw new NullException("请输入账号");
            }
            if (password.isEmpty() || password.length() == 0) {
                throw new NullException("请输入密码");
            }

            nameValuePairs.add(new BasicNameValuePair(getHiddenName("name"), getHiddenName("value")));
            nameValuePairs.add(new BasicNameValuePair("username", studentName));
            nameValuePairs.add(new BasicNameValuePair("password", password));
            HttpPost post = new HttpPost(loginUrl);
            try {
                post.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
                try {
                    httpResponse = httpClient.execute(post);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } finally {
                post.abort();
            }
        }
        return getText(sourceUrl + "schoolyear=" + schoolyear + "&semester="+ semester+"");
    }

    private static String getText(String url) {
        HttpGet httpGet = new HttpGet(url);
        //创建返回处理
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        try {
            responseBody = httpClient.execute(httpGet, responseHandler);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpGet.abort();

        }
        if (responseBody.contains("<script>top.location.href='/sise/login.jsp';</script>")) {
            nameValuePairs.clear();
            isAuthc = false;
            throw new IncorrectCredentialsException();
        } else {
            isAuthc = true;
            return responseBody;
        }
    }

    private static void logout(String studentName, String password, String schoolyear, String semester) {
        nameValuePairs.clear();
//        ResponseHandler<String> responseHandler = new BasicResponseHandler();
//        HttpGet httpGet = new HttpGet(logoutUrl);
//        String rb = httpClient.execute(httpGet, responseHandler);
//            System.out.println(rb);
            httpClient.getCookieStore().clear();
            isAuthc = false;
            login(studentName, password, schoolyear, semester);

    }

    private static boolean isAuthc() {
        return isAuthc;
    }
}
