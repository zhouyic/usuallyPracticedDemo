package com.zyc.demo.test.newfeature.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/8/18 10:01
 */
public class DateTest {
    public static void main(String[] args) {
        /**获取当前时间*/
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间:"+currentTime);
        System.out.println("date1："+currentTime.toLocalDate());
        Month month = currentTime.getMonth();
        int dayOfMonth = currentTime.getDayOfMonth();
        int second = currentTime.getSecond();
        System.out.println("月："+month+"，日："+dayOfMonth+",秒："+second);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2:"+date2);

        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3:"+date3);
        /**22小时15分*/
        LocalTime of = LocalTime.of(22, 15);
        System.out.println("date4："+of);
        /**解析字符串*/
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5:"+date5);


    }
}
