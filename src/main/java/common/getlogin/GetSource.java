package common.getlogin;

import com.alibaba.fastjson.JSONObject;
import com.wxplatform.mapper.NoCourseInfoMapper;
import com.wxplatform.pojo.NoCourseInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Wxplatform
 * @description: 获取课程
 * @author: zhijie
 * @create: 2019-03-01 15:35
 **/

@Component
public class GetSource {


    static String sourceUrl = "http://class.sise.com.cn:7001"
            + "/sise/module/student_schedular/student_schedular.jsp";

    public  static List getNoCourseList(String studentName, String password,String schoolyear,String semester) {
     ;
        String courseString = SiseLogin.login(studentName, password, schoolyear, semester);
        Document doc = Jsoup.parse(courseString);
        int index = 0;    //定义课程时间的下标位置
        String text;    //定义内容（课程时间，课程内容）
        List<String> courseTime = new ArrayList<String>();    //课程时间的数组
        List<String> courseDetail = new ArrayList<String>();   //课程内容的数组
        for (int j = 0; j < 64; j++) { //表格一共有64格
            //获取课程时间
            if (j == 0 || j == (index * 8)) {
                text = doc.select("tr[height=20][bgcolor=#FFFFFF]").
                        select("td[width=10%]")
                        .get(j)
                        .toString()
                        .replace("<td width=\"10%\" align=\"center\" valign=\"top\" class=\"font12\">", "")
                        .replace("<td width=\"10%\" align=\"left\" valign=\"top\" class=\"font12\">", "")
                        .replace("<br />", "")
                        .replace("</td>", "");


                courseTime.add(text);
                j += 1;    // j+1是为了让获取课程的部分跳过时间段这一点，否则会获取到时间段
                index++;
            }

            //获取课程的内容
            text = doc.select("tr[height=20][bgcolor=#FFFFFF]").
                    select("td[width=10%]")
                    .get(j)
                    .toString()
                    .replace("<td width=\"10%\" align=\"center\" valign=\"top\" class=\"font12\">", "")
                    .replace("<td width=\"10%\" align=\"left\" valign=\"top\" class=\"font12\">", "")
                    .replace("<br />", "")
                    .replace("</td>", "");


					/*1
					 * 一学期都没课的
					 * 课程实例：影视鉴赏(APD 在线课1 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17周 [ZX001])
					 * 		&nbsp;
					 */
            if (text.equals("&nbsp;") || text.contains("在线课")) {
                text = "无课(1 - 17周)";
            }

					/*2
					 * 一学期都有课的
					 * 课程代表：(1)非结构化数据库入门(IK01 陈宁穗 1 2 3 4 5 6 7 8周 [T303]),
					 * 		     系统原型设计与交互(JH 潘正军 9 10 11 12 13 14 15 16 17周 [S105])";
					 *       (2)软件工程(HD01 彭小娟 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17周 [U208]);
					 *       (3)编程规范(JV 赖巧贤 1 3 5 7 9 11 13 15 17周 [C401]), 编程规范(JV02 赖巧贤 2 4 6 8 10 12 14 16周 [S2502])
					 *
					 *	针对大一
					 * 5 6 7 8 9 10 11 12 13 14 15 16 17有课
					 * 课程示例：(1)中国近现代史纲要(AYN 张玥 6 7 8 9 10 11 12 13 14 15 16周 [A301]);
					 * 		  (2)大学英语 I(QV 邬英英 5 6 7 8 9 10 11 12 13 14 15 16 17周 [U403])
					 * */
            else if (text.contains("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16") ||
                    text.contains("1 2 3 4 5 6 7 8") && text.contains("9 10 11 12 13 14 15 16") ||
                    text.contains("1 3 5 7 9 11 13 15 17") && text.contains("2 4 6 8 10 12 14 16") ||
                    text.contains("7 8 9 10 11 12 13 14 15 16") ||
                    text.contains(" 5 6 7 8 9 10 11 12 13 14 15 16 17")) {
                text = "有课";
            }
					/*23
					 * 15 16 17 没课
					 *  课程示例：(1)对象关系映射技术(II 甘宏 1 2 3 4 5 6 7 8 9 10 11 12 13 14周 [T101])
					 * */
            else if (text.contains("1 2 3 4 5 6 7 8 9 10 11 12 13 14")) {
                text = "无课(15 16 17周)";
            }
					/*3
					 *  6 7 8 无课
					 * 大学体育Ⅳ(WI04 陈万军 9 10 11 12 13 14 15 16周 [TY301]),
					 * 形势与政策 II(AZM 黄秋冬 1 2 3 4 5周 [D102])",
					 * */
            else if (text.contains("1 2 3 4 5") && text.contains("9 10 11 12 13 14 15 16")) {
                text = "无课(6 7 8周)";
            }
            //4
            else if (text.contains("2 3 4 5 6") && text.contains("9 10 11 12 13 14 15 16")) {
                text = "无课(1 7 8周)";
            }
            //5
            else if (text.contains("3 4 5 6 7") && text.contains("9 10 11 12 13 14 15 16")) {
                text = "无课(1 2 8周)";
            }
            //6
            else if (text.contains("4 5 6 7 8") && text.contains("9 10 11 12 13 14 15 16")) {
                text = "无课(1 2 3周)";
            }
					 /*7(形式与政策 2 3 4 5）
					  * 第1 6 7 8 周没课
					  * 课程示例:(1)系统原型设计与交互(JH 潘正军 9 10 11 12 13 14 15 16 17周 [S105]),
					  * 	   (2)形势与政策 III(BAG 黄汉昌 2 3 4 5周 [A401])",
					  *
					  * */
            else if (text.contains("1 2 3 4") && text.contains("9 10 11 12 13 14 15 16")) {
                text = "无课(5 6 7 8周)";
            }
            //8
            else if (text.contains("2 3 4 5") && text.contains("9 10 11 12 13 14 15 16 17")) {
                text = "无课(1 6 7 8周)";
            }

					/*9*/
            else if (text.contains("3 4 5 6") && text.contains("9 10 11 12 13 14 15 16")) {
                text = "无课(1 2 7 8周)";
            }
            //10
            else if (text.contains("4 5 6 7") && text.contains("9 10 11 12 13 14 15 16")) {
                text = "无课(1 2 3 8周)";
            }
            //11
            else if (text.contains("5 6 7 8") && text.contains("9 10 11 12 13 14 15 16")) {
                text = "无课(1 - 4周)";
            }

					/*24
					 * 针对大一
					 * 6 7 没课
					 * 课程示例：计算机科学导论(HC01 江立 8 9 10 11 12 13 14 15 16周 [U506])"
					 * */

            else if (text.contains(" 8 9 10 11 12 13 14 15 16")) {
                text = "无课(6 7周)";
            }
					/*12
					 *  9-17有课
					 *  课程示例：(1)分布式应用编程(JN01 陈立军 9 10 11 12 13 14 15 16 17周 [S2206])
					 * */
            else if (text.contains("9 10 11 12 13 14 15 16")) {
                text = "无课(1 - 8周)";
            }
            //13
            else if (text.contains("1 2 3 4 5 6 7 8") && text.contains("9 10 11 12 13")) {
                text = "无课(14 - 17周)";
            }
            //14
            else if (text.contains("1 2 3 4 5 6 7 8") && text.contains("10 11 12 13 14")) {
                text = "无课(9 & 15-17周)";
            }
            //15
            else if (text.contains("1 2 3 4 5 6 7 8") && text.contains("11 12 13 14 15")) {
                text = "无课(9-10 & 16-17周)";
            }
            //16
            else if (text.contains("1 2 3 4 5 6 7 8") && text.contains("12 13 14 15 16")) {
                text = "无课(9-11 & 17周)";
            }
            //17
            else if (text.contains("1 2 3 4 5 6 7 8") && text.contains("9 10 11 12")) {
                text = "无课(13 - 17周)";
            }
            //18
            else if (text.contains("1 2 3 4 5 6 7 8") && text.contains("10 11 12 13")) {
                text = "无课(9 & 14-17周)";
            }
            //19
            else if (text.contains("1 2 3 4 5 6 7 8") && text.contains("11 12 13 14")) {
                text = "无课(9-10 & 15-17周)";
            }
            //20
            else if (text.contains("1 2 3 4 5 6 7 8") && text.contains("12 13 14 15")) {
                text = "无课(9-11 & 16-17周)";
            }
            //21
            else if (text.contains("1 2 3 4 5 6 7 8") && text.contains("13 14 15 16")) {
                text = "无课(9-12周)";
            }
					/*22
					 * 	1-8有课
					 *  课程示例：(1)Hadoop大数据处理(ID01 潘正军 1 2 3 4 5 6 7 8周 [U308])
					 * */
            else if (text.contains(" 1 2 3 4 5 6 7 8")) {
                text = "无课(9 - 17周)";
            }


            //26
            else if (text.contains("1 2 3 4 5")) {
                text = "无课(6 - 17周)";
            }
            //27
            else if (text.contains("2 3 4 5 6")) {
                text = "无课(6 - 17周)";
            }
            //28
            else if (text.contains("3 4 5 6 7")) {
                text = "无课(1-2 & 8-17周)";
            }
            //29
            else if (text.contains("4 5 6 7 8")) {
                text = "无课(1-3 & 9-17周)";
            }
            //30
            else if (text.contains("5 6 7 8 9")) {
                text = "无课(1-4 & 10-17周)";
            }

					/*31
					 * 	1-5 & 11-17没课
					 *  课程示例：(1)形势与政策 II(AZG 唐可杨 6 7 8 9 10周 [D102])
					 * */
            else if (text.contains("6 7 8 9 10")) {
                text = "无课(1-5 & 11-17周)";
            }
            //32
            else if (text.contains("7 8 9 10 11")) {
                text = "无课(1-6 & 12-17周)";
            }
            //33
            else if (text.contains("9 10 11 12 13")) {
                text = "无课(1-8 & 14-17周)";
            }
            //34
            else if (text.contains("10 11 12 13 14")) {
                text = "无课(1-9 & 15-17周)";
            }
            //35
            else if (text.contains("11 12 13 14 15")) {
                text = "无课(1-10 & 16-17周)";
            }
            //36
            else if (text.contains("12 13 14 15 16")) {
                text = "无课(1 - 11周)";
            }
					/*37
					 * 形势与政策 1 2 3 4
					 * */
            else if (text.contains("1 2 3 4")) {
                text = "无课(5 - 17周)";
            }
            //38
            else if (text.contains("2 3 4 5")) {
                text = "无课(1 & 6-17周)";
            }
            //39
            else if (text.contains("3 4 5 6")) {
                text = "无课(1-2 & 7-17周)";
            }
            //40
            else if (text.contains("4 5 6 7")) {
                text = "无课(1-3 & 8-17周)";
            }
            //41
            else if (text.contains("5 6 7 8")) {
                text = "无课(1-4 & 9-17周)";
            }
            //42
            else if (text.contains("6 7 8 9")) {
                text = "无课(1-5 & 10-17周)";
            }
            //43
            else if (text.contains("9 10 11 12")) {
                text = "无课(1-8 & 13-17周)";
            }
            //44
            else if (text.contains("10 11 12 13")) {
                text = "无课(1-9 & 14-17周)";
            }
            //45
            else if (text.contains("11 12 13 14")) {
                text = "无课(1-10 & 15-17周)";
            }
            //46
            else if (text.contains("12 13 14 15")) {
                text = "无课(1-11 & 16-17周)";
            }
					/*47
					 * 形势与政策 13 14 15 16
					 * */
            else if (text.contains("13 14 15 16")) {
                text = "无课(1 - 12周)";
            }
					/*48
					 *单周有课
					 * 课程示例：(1)Python核心编程(BHG 张志威 1 3 5 7 9 11 13 15 17周 [U602])
					 * */
            else if (text.contains("1 3 5 7 9 11 13 15")) {
                text = "无课(2 4 6 8 10 12 14  16周)";

            }
					/*49
					 * 双周有课
					 * 课程示例：(1)马克思主义基本原理概论(BAR 黄长平 2 4 6 8 10 12 14 16周 [D202])
					 * */
            else if (text.contains("2 4 6 8 10 12 14 16")) {
                text = "无课(1 3 5 7 9 11 13 15 17周)";
            }
					/* 50
					 * 针对大一的
					 *  8 10 12 14 16有课
					 *  课程示例：中国近现代史纲要(AYN 张玥 8 10 12 14 16周 [D203])
					 * */
            else if (text.contains("8 10 12 14 16")) {
                text = "无课(9 11 13 15周)";
            }
					/* 51
					 * 针对大一的
					 * 7 9 11 13 15 17有课
					 * 课程示例：计算机科学导论(HE 江立 7 9 11 13 15 17周 [T304])
					 * */
            else if (text.contains(" 7 9 11 13 15 17")) {
                text = "无课(6 8 10 12 14 16周)";
            }
					/*52
					 * 针对大一
					 * 7 9 11 13 15有课
					 * 课程示例：中国近现代史纲要(AYB 魏云锋 7 9 11 13 15周 [D202])
					 * */
            else if (text.contains("7 9 11 13 15")) {
                text = "无课(6 8 10 12 16 17周)";
            }
					/*53
					 * 体育大学的大课
					 * 算作没课吧
					 *
					 * */
            else if (text.contains("大学体育")) {
                text = "无课(1 - 17周)";
            }
            courseDetail.add(text); //添加到课程的数组中
        }

        return courseDetail;

    }
}
