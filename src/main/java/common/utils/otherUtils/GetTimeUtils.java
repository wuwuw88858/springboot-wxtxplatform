package common.utils.otherUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: Wxplatform
 * @description: 获取当前系统的时间, 转化成时间, 精确到秒戳，最终作为编号
 * @author: zhijie
 * @create: 2018-12-06 22:29
 **/
@Component
public class GetTimeUtils {

    static SimpleDateFormat sdf;
    static Calendar calendar;

    static String termBeginTime;

    static int week = 1;

    /*
    * @Description:  获取当前的时间戳
    * @Param: []
    * @return: java.lang.String
    * @Author:  zhijie
    * @Date: 2019/4/23
    */
    public static String setSthIdByCurrentTime() {
     sdf = new SimpleDateFormat("YYMMddHHmmss");
        String dateString = sdf.format(new Date());
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long s = date.getTime();
        String somethingId = Long.toString(s / 1000);
        return somethingId;
    }

    /*
    * @Description:判断当前的时间和输入的时间是否相同，如果相同则不行
    * @Param:
    * @return:[date]
    * @Autbooleanhor:  zhijie
    * @D2019/2/24ate:
    */
    public static boolean isEqualTime(String date) {
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentdate = sdf.format(new Date()); //系统当前时间
        try {
            long timeStamp = sdf.parse(date).getTime(); //获取到输入的时间
            long currentTimeStamp = sdf.parse(currentdate).getTime();
            return timeStamp <= currentTimeStamp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
     * @Description:  获取自定义的年月份，转换成时间戳的形式
     * @Param: [date]
     * @return: java.lang.String
     * @Author:  zhijie
     * @Date: 2019/1/11
     */
    public static String changDateToTimeStamp(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            long timeStamp = sdf.parse(date).getTime();
            return String.valueOf(timeStamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String changTimeToTimeStamp(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            long timeStamp = sdf.parse(time).getTime();
            return String.valueOf(timeStamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /*
       * @Description:  将时间戳转换成时间
       * @Param: [date]
       * @return: java.lang.String
       * @Author:  zhijie
       * @Date: 2019/1/11
       */
    public static String changDateStampToDate(String getDate) {
        long time = Long.parseLong(getDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        date.setTime(time);
        String strTime = sdf.format(date);
        return strTime;
    }

    public static String changTimeStampToTime(String getTime) {
        long time = Long.parseLong(getTime);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        date.setTime(time);
        String strTime = sdf.format(date);
        return strTime;
    }


    /*
     * @Description:  对周程的操作进行时间范围的控制，只有周五，周六，周日课对周程进行操作
     *  0-6代表周日 到周六
     * @Param: []
     * @return: boolean
     * @Author:  zhijie
     * @Date: 2019/3/28
     */
    public static boolean getWeek() {
        calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (week <= 0) {
            week = 0;
        }
        if (week == 0 || week == 5 || week == 6) {
            return true;
        } else {
            return false;

        }
    }

    public static int getWeekTime() {
        Date nowTime = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date termTime = df.parse(termBeginTime);
            long betweenDay = (nowTime.getTime() - termTime.getTime()) / (1000 * 60 * 60 * 24);
            if (betweenDay < 0) {
                week = 1;
                return week;
            }
            if (betweenDay % 7 > 0) {
                week = Integer.parseInt(String.valueOf(betweenDay)) / 7 + 1;
            } else {
                week = Integer.parseInt(String.valueOf(betweenDay)) / 7;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return week;
    }


    public static String getTermBeginTime() {
        return termBeginTime;
    }
    @Value("${begin.term.time}")
    public  void setTermBeginTime(String termBeginTime) {
        this.termBeginTime = termBeginTime;
    }
}
