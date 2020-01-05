package com.zyc.demo.test.thread.concurrent.countdownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/8/18 18:25
 */
public class TaskPortion implements Runnable{
    private static int counter=0;
    private final int id = counter++;
    private static Random rand = new Random(47);
    private final CountDownLatch latch;

    TaskPortion(CountDownLatch latch){
        this.latch=latch;
    }

    @Override
    public void run() {
        try {
            doWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        System.out.println(this+"completed");
    }

    @Override
    public String toString() {
        return String.format("%1$-3d ",id);
    }
}
