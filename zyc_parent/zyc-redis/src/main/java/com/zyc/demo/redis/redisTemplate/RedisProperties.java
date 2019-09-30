package com.zyc.demo.redis.redisTemplate;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "spring.redis.cluster")
@Component
public class RedisProperties {

    private String nodes;

    public String getNodes() {
        return nodes;
    }

    public void setNodes(String nodes) {
        this.nodes = nodes;
    }
}