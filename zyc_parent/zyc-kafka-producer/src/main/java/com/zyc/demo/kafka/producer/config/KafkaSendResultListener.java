package com.zyc.demo.kafka.producer.config;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

/**
 * 消息结果回调
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/12/3 22:55
 */
@Component
public class KafkaSendResultListener implements ProducerListener {
    private static final Logger log = LoggerFactory.getLogger(KafkaSendResultListener.class);

    @Override
    public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
        log.info("***********Message send success : " + producerRecord.toString());
    }

    @Override
    public void onError(ProducerRecord producerRecord, Exception exception) {
        log.info("Message send error : " + producerRecord.toString());
    }
}
