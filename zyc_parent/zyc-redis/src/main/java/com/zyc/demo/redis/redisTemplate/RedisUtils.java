package com.zyc.demo.redis.redisTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class RedisUtils {
	private static final Logger LOG = LoggerFactory.getLogger(RedisUtils.class);
//	@Autowired
//	RedisProperties redisProperties;
	@Value("${spring.redis.clusterNodes}")
	private String nodes;
	private static JedisCluster jedisCluster;

	private static JedisPool jedisPool;

	public RedisUtils() {

	}
	
	// 初始化rediscluster
	public JedisCluster getJedisCluster() {
		try {

			if (jedisCluster == null) {

				String[] redisArr = "192.168.47.128:7000,192.168.47.128:7001,192.168.47.128:7002".split(",");

				Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
				for(String redisAddr : redisArr ){
					String[] datasourceArr = redisAddr.split(":");
					jedisClusterNodes.add(new HostAndPort(datasourceArr[0], Integer.parseInt(datasourceArr[1])));
				}// End for
				
				jedisCluster = new JedisCluster(jedisClusterNodes);
			}
		} catch (Exception e) {
			LOG.error("连接redis失败！", e);
			System.exit(0);
		}
		return jedisCluster;
	}


 
	
	
	
	

}
