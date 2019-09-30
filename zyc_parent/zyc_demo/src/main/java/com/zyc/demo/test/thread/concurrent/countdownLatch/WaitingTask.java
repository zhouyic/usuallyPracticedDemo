package com.zyc.java.test.thread.concurrent.countdownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/8/18 18:31
 */
public class WaitingTask implements Runnable {
    private static int counter=0;
    private final int id=counter++;
    private final CountDownLatch latch;
    WaitingTask(CountDownLatch latch){
        this.latch=latch;
    }

    @Override
    public void run() {
        try {
            latch.wait ();
            System.out.println("Lacth barrier passwed for "+this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format("waitingTask %1$-3d ",id);
    }

}
