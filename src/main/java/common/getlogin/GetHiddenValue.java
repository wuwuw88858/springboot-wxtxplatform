package common.getlogin;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @program: Wxplatform
 * @description: 获取华软教务系统登录时需要的hiddenValue
 * @author: zhijie
 * @create: 2019-03-01 14:37
 **/
public class GetHiddenValue {
   static Document document = null;
    static String name = null;
    static final String hiddenValueurl = "http://class.sise.com.cn:7001/sise/login.jsp";

    public static String getHiddenName(String getStr) {
        try {
            document = Jsoup.connect(hiddenValueurl).get();
            Elements elements = document.select("input[type]");
            String element = elements.attr(getStr);
            return element;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            document = null;
        }
        return null;
    }


}
