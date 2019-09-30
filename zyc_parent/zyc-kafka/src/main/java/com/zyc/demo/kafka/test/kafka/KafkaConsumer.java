package com.zyc.demo.kafka.test.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/3/3 16:40
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "shuaige")
    public void processMessage(String content) {

        System.out.println("*******message="+content);
    }
}
