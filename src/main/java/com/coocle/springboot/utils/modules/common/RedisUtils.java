/**
 * Copyright 2018 asiainfo Inc.
 **/

package com.coocle.springboot.utils.modules.common;

import redis.clients.jedis.JedisCluster;

/**
 * redis工具类.
 *
 * @Author:jiangchao
 * @CreateDate:2018/10/10
 */
public class RedisUtils {

  private static JedisCluster jedisCluster;

  static {
    jedisCluster = SpringContext.getBean(JedisCluster.class);
  }

  /**
   * getValues.
   *
   * @param key
   * @return
   */
  public static Object getValues(String key) {
    return jedisCluster.get(key);
  }

  /**
   * setString.
   *
   * @param key
   * @param value
   */
  public static void setString(String key, String value) {
    jedisCluster.set(key, value);
  }

  /**
   * delKey.
   *
   * @param key
   */
  public static void delKey(String key) {
    jedisCluster.del(key);
  }

}
