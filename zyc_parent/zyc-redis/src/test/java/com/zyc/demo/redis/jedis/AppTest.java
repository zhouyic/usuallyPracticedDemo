package com.zyc.demo.redis.jedis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
    @Test
    public void shouldAnswerWithTrue()
    {
        String limit = jedisCluster.get("aa");
        System.out.println(limit);

    }
}
