package com.zyc.demo.kafka.producer.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/12/3 23:08
 */
public class CounterInterceptor implements ProducerInterceptor<String,String> {
    private static final Logger log = LoggerFactory.getLogger(CounterInterceptor.class);

    private int errorCounter = 0;
    private int successCounter = 0;
    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        if(e==null){
            successCounter++;
        }else{
            errorCounter++;
        }

    }

    @Override
    public void close() {
        log.info("########Successful sent: " + successCounter);
        log.info("##########Failed sent: " + errorCounter);
    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
