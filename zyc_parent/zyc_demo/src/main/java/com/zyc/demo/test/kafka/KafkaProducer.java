package com.zyc.demo.test.kafka;

import com.alibaba.fastjson.JSON;
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
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    /**
     * 发送消息的方法
     */
    public void send(){
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.debug("++++++++++++++++++++++message={}", JSON.toJSONString(message));
        /*topic-ideal为主题*/
        kafkaTemplate.send("shuaige", JSON.toJSONString(message));

    }

}
