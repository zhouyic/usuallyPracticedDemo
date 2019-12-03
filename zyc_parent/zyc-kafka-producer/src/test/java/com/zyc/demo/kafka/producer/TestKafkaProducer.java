package com.zyc.demo.kafka.producer;

import com.zyc.demo.kafka.producer.service.KafkaProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/11/24 10:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestKafkaProducer {
    @Autowired
    KafkaProducerService kafkaProducerService;
    @Test
    public void testKafkaProducer() throws InterruptedException {
        kafkaProducerService.send();
    }
}
