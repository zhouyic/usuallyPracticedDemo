package com.zyc.demo.redis.jedis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * @author zhouyicai
 * @Description: 从配置文件中自动注入redis 配置
 * @date 2019/3/2 15:49
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class JedisProperties {
    private int expireSeconds;
    private String clusterNodes;
    private String password;
    private int commandTimeout;
}
