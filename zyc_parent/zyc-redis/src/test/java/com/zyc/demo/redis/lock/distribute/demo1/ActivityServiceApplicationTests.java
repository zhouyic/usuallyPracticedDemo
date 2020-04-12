package com.zyc.demo.redis.lock.distribute.demo1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/2/23 20:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ActivityServiceApplicationTests {

    @Autowired
    private RedisDistributeLock redisDistributeLock;
    @Test
    public void testRedislock() throws InterruptedException {
        for(int i=0;i < 50;i++){
            int finalI = i;
            new Thread(() ->{
                if (redisDistributeLock.tryLock("TEST_LOCK_KEY", "TEST_LOCK_VAL_"+ finalI, 1000* 100, 1000*20)){
                    try {
                        log.warn("get lock successfully with lock value:-----" + "TEST_LOCK_VAL_"+ finalI);
                        Thread.sleep(2000);
                        if (!redisDistributeLock.tryUnLock("TEST_LOCK_KEY", "TEST_LOCK_VAL_"+ finalI)){
                            throw new RuntimeException("release lock fail");
                        }
                        log.warn("release lock successfully with lock value:-----" + "TEST_LOCK_VAL_"+ finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    log.warn("get lock fail with lock value:-----" + "TEST_LOCK_VAL_"+ finalI);
                }
            }).start();
        }

        Thread.sleep(1000*1000);
    }

}
