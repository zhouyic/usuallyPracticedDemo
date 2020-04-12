package com.zyc.demo.redis.jedis;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/3/2 16:04
 */
@Component
public class RedisUtil {
    private static final Logger log    = LoggerFactory.getLogger(RedisUtil.class);

    @Autowired
    private JedisCluster jedisCluster;

    /**
     * 设置缓存
     * @param key 缓存key
     * @param value 缓存value
     */
    public void set(String key,String value){
        jedisCluster.set(key, value);
        log.debug("RedisUtil:set cache key={},value={}", key, value);
    }

    /**
     * 设置缓存对象
     * @param key 缓存key
     * @param obj 缓存value
     * @param expireTime
     * @param <T>
     */
    public <T> void setObject(String key,T obj,int expireTime){
        jedisCluster.setex(key, expireTime, JSON.toJSONString(obj));
    }

    /**
     * 获取指定key的缓存
     * @param key  ----JSON.parseObject(value,User.class)
     * @return
     */
    public String getObject(String key){
        return jedisCluster.get(key);

    }

    /**
     * 判断当前key 是否存在
     * @param key
     * @return
     */
    public boolean hasKey(String key){
        return jedisCluster.exists(key);
    }

    /**
     * 设置缓存,并且自己指定过期时间
     * @param key
     * @param value
     * @param expireTime  过期时间
     */
    public void setWithExpireTIme(String key,String value,int expireTime){

        jedisCluster.setex(key, expireTime, value);
        log.debug("RedisUtil: setWithExpireTime cache key={},value={},expireTime={}",key,value,expireTime);
    }

    /**
     * 获取指定key的缓存
     * @param key
     * @return
     */
    public String get(String key){
        String value=jedisCluster.get(key);
        log.debug("RedisUtil:get cache key={},value={}",key,value);
        return value;
    }

    /**
     * 删除指定key的缓存
     * @param key
     */
    public void delete(String key){
        jedisCluster.decr(key);
        log.debug("RedisUtil:delete cache key={}",key);
    }

}
