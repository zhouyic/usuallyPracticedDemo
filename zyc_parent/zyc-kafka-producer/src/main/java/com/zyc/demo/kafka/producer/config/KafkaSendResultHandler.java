package com.zyc.demo.kafka.producer.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

/**
 * @author zhouyicai
 * @Description: 消息回调
 *  编写一个消息结果回调类KafkaSendResultHandler
 *  当我们使用KafkaTemplate发送消息成功的时候回调用OnSuccess方法，发送失败则会调用onError方法。
 * @date 2019/11/24 15:06
 */
@Component
@Slf4j
public class KafkaSendResultHandler implements ProducerListener{
    @Override
    public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
        log.info("Message send success："+producerRecord.toString());
    }

    @Override
    public void onError(ProducerRecord producerRecord, Exception exception) {
        log.error("Message send error:"+ producerRecord.toString());
    }
}
