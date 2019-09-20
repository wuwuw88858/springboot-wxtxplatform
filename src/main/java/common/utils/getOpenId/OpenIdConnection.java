package common.utils.getOpenId;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/*
*获取code工具
* @params:code
* @return:code
* */
@Configuration
@PropertySource(value = "classpath:url.properties")
public class OpenIdConnection {

    /*
    * 请求微信服务器的参数
    *
    * */
    @Value("${wx.openid.requesturl}")
    String url;
    @Value("${wx.appid}")
    String appid;
    @Value("${wx.appSecret}")
    String appSecret;
    @Value("${wx.gradeType}")
    String grade_type;


    public String getOpenId(String code) {
        String params = "appid=" + appid + "&secret=" + appSecret + "&js_code=" + code + "&grant_type=" +
                    grade_type;
            String openId = WxLoginSendUtil.sendGet(url, params);
            return openId;
    }
    /*
         * @Description:  使用字节流的形式读取文件
         *                 无法使用@Value读取（未解决）
         * @Param: [code]
         * @return: java.lang.String
         * @Author:  zhijie
         * @Date: 2019/3/23
         */
//    public String getOpenId(String code) {
//     Properties properties = new Properties();
//        InputStream inputStream = this.getClass().getResourceAsStream("/url.properties");
//        try {
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
//            properties.load(inputStreamReader);
//             url = properties.getProperty("wx.openid.requesturl");   //请求地址
//             appid = properties.getProperty("wx.appid");
//             appSecret = properties.getProperty("wx.appSecret");
//             grade_type = properties.getProperty("wx.gradeType");
//            String params = "appid=" + appid + "&secret=" + appSecret + "&js_code=" + code + "&grant_type=" +
//                    grade_type;
//            String openId = WxLoginSendUtil.sendGet(url, params);
//            return openId;
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                properties.clear();
//            }
//        }
//        return null;
//    }

    //硬编码形式
    //请求地址
    //  String url = "https://api.weixin.qq.com/sns/jscode2session";

    //微信小程序唯一识别符（后台获取)
    //     String appid = "wx1365986f993abe81";
    //微信小程序密钥
    //   String appSecret = "e3907e5712fbb00c4103690f0ccf67db";
    //授权
    // String grade_type = "authorization_code";
         /*向微信服务器通过三个参数来获取用户敏感信息*/
    //请求参数
//        String params = "appid=" + appid + "&secret=" + appSecret + "&js_code=" + code + "&grant_type=" +
//                grade_type;
//        String openId = WxLoginSendUtil.sendGet(url, params);
//        return openId;

}
