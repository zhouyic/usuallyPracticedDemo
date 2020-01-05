package com.zyc.demo.test.thread.volatiletest;

/**
 * 内存可见性问题:当多个线程操作共享数据时,彼此不可见
 * volatile 关键字：当多个线程a进行操作共享数据时，可以保证内存中的数据可见
 *          相较于synchronized 时一种较为轻量级的同步策略
 * 注意:
 *  1.volatile 不具备”互斥性"
 *  2.volatile 不能保证变量的"原子性"
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/8/18 19:38
 */
public class TestVolatile {
    public static void main  (String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();
        while (true){
            if(td.isFlag()){
                System.out.println("-----------------------");
                break;
            }
        }

    }
}
class ThreadDemo implements Runnable{
    private volatile boolean flag=false;

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        flag=true;
        System.out.println("flag="+isFlag());

    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
