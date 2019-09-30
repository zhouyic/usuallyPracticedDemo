package com.zyc.java.test.thread.concurrent.countdownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/8/18 18:22
 */
public class CountDownLatchDemo {
    static final  int SIZE=100;
    public static void main(String[] args) {
        ExecutorService exexc = Executors.newCachedThreadPool();
        CountDownLatch latth = new CountDownLatch(SIZE);


    }


}
