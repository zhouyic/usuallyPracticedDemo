package com.zyc.demo.test.thread.testaa;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 一. i++ 的原子性问题：i++的操作实际上分为三个步骤"读-改-写"
 *         int i=10;
 *         i=i++; //10
 *
 *         int tmp=i;
 *         i=i+1；
 *         i=temp;
 *二. 原子变量: jdk1.5后java.util.concurrent.atomic包下提供了常用的原子变量
 *      1. volatile 保证内存可见性
 *      2. CAS(compile-And-Swap)算法保证数据的原子性
 *              CAS 算法是硬件对于并发操作共享数据的支持
 *              CAS 包含了三个操作数
 *                  内存值V
 *                  预估值A
 *                  更新至B
 *                  当且仅当V==A时,V=B，否则,将不做任何操作
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/8/18 20:13
 */
public class TestAtomicDemo11 {
    public static void main(String[] args) {
        AtomicDemo ad=new AtomicDemo();
        for (int i = 0; i <10 ; i++) {
            new Thread(ad).start();
        }
    }


}
class AtomicDemo implements Runnable{
    //    private volatile int seriaNumber=0;
    private AtomicInteger seriaNumber = new AtomicInteger();
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName()+":"+getSeriaNumber());
    }

    public int getSeriaNumber() {

//        return seriaNumber++;

        return seriaNumber.getAndIncrement();
    }
}
