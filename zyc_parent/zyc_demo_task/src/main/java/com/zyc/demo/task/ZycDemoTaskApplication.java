package com.zyc.demo.task;

import com.zyc.demo.task.util.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableScheduling
public class ZycDemoTaskApplication {
    @Value("${test.cron}")
    private String testCron ;
    public static void main(String[] args) {
        SpringApplication.run(ZycDemoTaskApplication.class, args);
    }
    @Scheduled(cron = "${test.cron}" )
    public void testDemo(){
        long beginMills= DateUtils.getMonthStarTimestamp();
        long endMills = DateUtils.getMonthEndTimestamp();
        LocalDateTime time2 = LocalDateTime.ofEpochSecond(endMills / 1000, 0, ZoneOffset.ofHours(8));
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localTime = df.format(time2);
        String yearMonth=localTime.substring(0, 7);
        int billDate = Integer.valueOf(yearMonth.replace("-",""));
        System.out.println("********testCron=" +testCron+"**************");
        System.out.println("********beginMills=" +beginMills+"**************");
        System.out.println("********endMills=" +endMills+"**************");
        System.out.println("********localTime=" +localTime+"**************");
        System.out.println("********yearMonth=" +yearMonth+"**************");
        System.out.println("********billDate=" +billDate+"**************");
    }
}
