package com.zyc.demo.redis.lock.distribute.demo1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.locks.Lock;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/4/12 14:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TicketTest {
    //100张票
    private int count = 100;
    //面向接口编程
    @Resource(name="lockBaseRedis")
    private Lock lock;
    @Test
    public void ticketTest() throws InterruptedException {
        TicketRunnable tr = new TicketRunnable();
        //四个现成对应四个窗口
        Thread t1 = new Thread(tr, "窗口A");
        Thread t2 = new Thread(tr, "窗口B");
        Thread t3 = new Thread(tr, "窗口C");
        Thread t4 = new Thread(tr, "窗口D");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        Thread.currentThread().join();

    }
    //线程类模拟一个窗口买火车票
    class TicketRunnable implements Runnable{
        @Override
        public void run() {
            while(count>0){
                lock.lock();
                try {
                    if(count>0){
                        log.info(Thread.currentThread().getName()+" 售出第"+(count--)+"张票");
                    }
                } catch (Exception e){
                    //进行异常处理
                }finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

