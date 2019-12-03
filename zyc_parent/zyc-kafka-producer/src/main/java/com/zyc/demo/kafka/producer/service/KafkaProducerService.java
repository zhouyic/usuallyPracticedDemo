package com.zyc.demo.kafka.producer.service;

import com.alibaba.fastjson.JSON;
import com.zyc.demo.kafka.producer.config.KafkaSendResultListener;
import com.zyc.demo.kafka.producer.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/3/2 22:27
 */
@Component
@Slf4j
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private KafkaSendResultListener kafkaSendResultListener;

    /**
     * 发送消息的方法
     */
    public void send() throws InterruptedException {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("++++++++++++++++++++++message={}", JSON.toJSONString(message));
        /**发送之前设置消息回调*/
//        kafkaTemplate.setProducerListener(kafkaSendResultListener);
        /**topic-ideal为主题*/
        kafkaTemplate.send("shuaige", JSON.toJSONString(message));
        /**发送消息的时候需要休眠一下，否则发送时间较长的时候会导致进程提前关闭导致无法调用回调时间。主要是因为KafkaTemplate发送消息是采取异步方式发送的*/
        Thread.sleep(1000);

    }

}
