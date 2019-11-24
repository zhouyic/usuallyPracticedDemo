package com.zyc.demo.kafka.consumer;

import lombok.Data;

import java.util.Date;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/3/2 22:27
 */
@Data
public class Message {
    //id
    private Long id;
    //消息
    private String msg;
    //时间戳
    private Date sendTime;
}