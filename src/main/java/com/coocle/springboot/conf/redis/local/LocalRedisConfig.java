/**
 * Copyright 2018 asiainfo Inc.
 **/

package com.coocle.springboot.conf.redis.local;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author:jiangchao
 * @CreateDate:2018/10/9
 */
@EnableCaching
@Configuration
@PropertySource("classpath:redis.properties")
public class LocalRedisConfig {

  @Value("${local-redis.nodes}")
  private String clusterNodes;
  @Value("${local-redis.timeout}")
  private int timeout;
  @Value("${local-redis.pool.max-idle}")
  private int maxIdle;
  @Value("${local-redis.pool.max-wait}")
  private long maxWaitMillis;
  @Value("${local-redis.commandTimeout}")
  private int commandTimeout;

  @Bean
  public JedisCluster getJedisCluster() {
    String[] cNodes = clusterNodes.split(",");
    Set<HostAndPort> nodes = new HashSet();
    // 分割出集群节点
    for (String node : cNodes) {
      String[] hp = node.split(":");
      nodes.add(new HostAndPort(hp[0], Integer.parseInt(hp[1])));
    }
    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    jedisPoolConfig.setMaxIdle(maxIdle);
    jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
    // 创建集群对象
//      JedisCluster jedisCluster = new JedisCluster(nodes,commandTimeout);
    JedisCluster jedisCluster = new JedisCluster(nodes, commandTimeout, jedisPoolConfig);
    return jedisCluster;
  }

}
