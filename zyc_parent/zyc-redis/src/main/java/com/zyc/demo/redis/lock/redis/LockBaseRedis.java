package com.zyc.demo.redis.lock.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author zhouyicai
 * @Description: redis分布式锁
 * @date 2020/4/12 14:34
 */
@Service("lockBaseRedis")
public class LockBaseRedis implements Lock {

    private static final String LOCK_KEY = "LOCK_KEY";
    /**
     * 线程内部共享变量
     */
    private ThreadLocal<String> threadLocal = new ThreadLocal<>();
    /**
     * lua脚本：判断锁住值是否为当前线程持有，是的话解锁，不是的话解锁失败
     */
    private static final String DISTRIBUTE_LOCK_SCRIPT_UNLOCK_VAL = "if" +
            " redis.call('get', KEYS[1]) == ARGV[1]" +
            " then" +
            " return redis.call('del', KEYS[1])" +
            " else" +
            " return 0" +
            " end";

    @Autowired
    JedisCluster jedisCluster;

    @Override
    //阻塞式的加锁
    public void lock() {
        //1.尝试加锁
        if (tryLock()) {
            return;
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
        //产生随机值
        String uuid = UUID.randomUUID().toString();
        //使用setNX命令请求写值,并设置失效时间
        String set = jedisCluster.set(LOCK_KEY, uuid, "NX", "EX", 1000);
        //返回OK意味着加锁成功
        if( "OK".equals(set)){
            threadLocal.set(uuid);
            return true;
        }
        //没有返回OK意味着加锁失败
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        String uuid = threadLocal.get();
        jedisCluster.eval(DISTRIBUTE_LOCK_SCRIPT_UNLOCK_VAL,
                Arrays.asList(LOCK_KEY),
                Arrays.asList(uuid));
//        tbLockMapper.del(ID_NUM);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
