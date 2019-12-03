package com.zyc.demo.kafka.producer.config;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${kafka.servers}")
    private String servers;
    @Value("${kafka.retries}")
    private int retries;
    @Value("${kafka.batch.size}")
    private int batchSize;
    @Value("${kafka.linger}")
    private int linger;
    @Value("${kafka.buffer.memory}")
    private int bufferMemory;
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        /**设置重试次数*/
        props.put(ProducerConfig.RETRIES_CONFIG, retries);
        /**达到batchSize大小的时候会发送消息*/
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
        /**延时时间，延时时间到达之后计算批量发送的大小没达到也发送消息*/
        props.put(ProducerConfig.LINGER_MS_CONFIG, linger);
        /**缓冲区的值*/
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
        /**序列化手段*/
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        /**producer端的消息确认机制,-1和all都表示消息不仅要写入本地的leader中还要写入对应的副本中*/
        props.put(ProducerConfig.ACKS_CONFIG, "-1");
        /**单条消息的最大值以字节为单位,默认值为1048576*/
        props.put(ProducerConfig.LINGER_MS_CONFIG, 10485760);
        /**key序列化*/
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        /**value序列化*/
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        /**指定拦截器*/
//        List<String> list = new ArrayList<String>();
//        list.add("com.zyc.demo.kafka.producer.interceptor.TimeStampPrependerInterceptor");
//        list.add("com.zyc.demo.kafka.producer.interceptor.CounterInterceptor");
//        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, list);
        /**设置broker响应时间，如果broker在60秒之内还是没有返回给producer确认消息，则认为发送失败*/
        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 60000);
        return props;
    }

    /**
     * 生产者工厂
     * @return
     */
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    /**
     * 模板发送消息
     * @return
     */
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<String, String>(producerFactory());
    }


}