package com.zyc.demo.redis.jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/3/2 15:48
 */
@Configuration
public class JedisClusterConfig {
    @Autowired
    private JedisProperties redisProperties;


    @Bean
    public JedisCluster getJedisCluster(){
        /*获取服务器数组(这里要相信自己的输入，所以没有考虑空指针问题)*/
        String[] serverArray = redisProperties.getClusterNodes().split(",");
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        for(String ipPort:serverArray){
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0],Integer.valueOf(ipPortPair[1].trim())));
        }
        /*需要密码连接的创建对象方式*/
        return new JedisCluster(nodes, redisProperties.getCommandTimeout(), 1000, 1, null, new GenericObjectPoolConfig());





    }
}
