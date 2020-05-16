package com.zyc.demo.task.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * 日期工具类
 */
public class DateUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);


    /**
     * 获取上月第一天00:00:00的时间戳
     * @return
     */
    public static long getMonthStarTimestamp(){
        LocalDateTime now = LocalDateTime.now();
        now=now.plusMonths(-1L);
        LocalDateTime firstDay = LocalDateTime.of(now.getYear(), now.getMonthValue(), 01, 00, 00, 00);
        return firstDay.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }
    /**
     * 获取指定日期第一天00:00:00的时间戳
     * @return
     */
    public static long getMonthStarTimestamp(String yearMonth){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        formatter.parse(yearMonth);
        LocalDateTime firstDay = LocalDateTime.of(Integer.valueOf(yearMonth.substring(0,4)), Integer.valueOf(yearMonth.substring(5,7)), 01, 00, 00, 00);
        return firstDay.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }
    /**
     * 获取上月最后一天23:59:59的时间戳
     * @return
     */
    public static long getMonthEndTimestamp(){
        LocalDateTime now = LocalDateTime.now();
        now=now.plusMonths(-1L);
        LocalDateTime of = LocalDateTime.of(now.getYear(), now.getMonthValue(), 01, 23, 59, 59);
        LocalDateTime lastDay =of.with(TemporalAdjusters.lastDayOfMonth());
        return lastDay.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }
    /**
     * 获取指定日期最后一天23:59:59的时间戳
     * @return
     */
    public static long getMonthEndTimestamp(String yearMonth){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        formatter.parse(yearMonth);
        LocalDateTime of = LocalDateTime.of(Integer.valueOf(yearMonth.substring(0,4)), Integer.valueOf(yearMonth.substring(5,7)), 01, 23, 59, 59);
        LocalDateTime lastDay =of.with(TemporalAdjusters.lastDayOfMonth());
        return lastDay.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }





}
