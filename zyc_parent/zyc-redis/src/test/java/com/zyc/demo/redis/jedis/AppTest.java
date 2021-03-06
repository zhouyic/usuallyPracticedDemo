package com.zyc.demo.redis.jedis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisCluster;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest 
{
    @Autowired
    JedisCluster jedisCluster;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    public void shouldAnswerWithTrue(){
        jedisCluster.set("aa", "test");
        String limit = jedisCluster.get("aa");
        System.out.println(limit);

    }

    @Test
    public void testSet(){
        stringRedisTemplate.opsForValue().set("bb1","test1");
        String limit = (String)stringRedisTemplate.opsForValue().get("aa");
        System.out.println(limit);

    }
}
