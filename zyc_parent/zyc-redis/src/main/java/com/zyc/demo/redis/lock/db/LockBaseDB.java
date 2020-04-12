package com.zyc.demo.redis.lock.db;

import com.zyc.demo.redis.mapper.TbLockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author zhouyicai
 * @Description: 基于数据实现的分布式锁
 * @date 2020/4/12 14:34
 */
@Service("lockBaseDB")
public class LockBaseDB implements Lock {
    private static final int ID_NUM = 1;
    @Autowired
    private TbLockMapper tbLockMapper;
    @Override
    //阻塞式的加锁
    public void lock() {
        //1.尝试加锁
        if(tryLock()){
            return ;
        }
        //2.加锁失败,当前任务休眠一段时间
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //递归调用,再次重新加锁
        lock();

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    //非阻塞式的加锁,往数据库写入id为1的数据,能写成功的即加锁成功
    public boolean tryLock() {
        try {
            tbLockMapper.insertData(ID_NUM);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        tbLockMapper.del(ID_NUM);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
