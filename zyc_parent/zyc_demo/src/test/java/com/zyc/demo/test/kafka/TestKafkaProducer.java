package com.zyc.demo.test.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestKafkaProducer {
    @Autowired
    private KafkaProducer kafkaProducer;
    @Test
    public void kafkaProducer() {
        this.kafkaProducer.send();
    }


}
