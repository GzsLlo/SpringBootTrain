/**
 * Copyright 2018 asiainfo Inc.
 **/

package com.coocle.springboot.conf.shiro;

import com.coocle.springboot.filter.test.FormAuthenticationFilter;
import com.coocle.springboot.filter.test.LogoutFilter;
import com.coocle.springboot.utils.modules.common.SpringApplicationContext;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisOperator;
import org.springframework.context.annotation.Bean;
import org.apache.shiro.mgt.SecurityManager;
import redis.clients.jedis.JedisCluster;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:jiangchao
 * @CreateDate:2019/3/19
 */
public class ShiroConfig {

  /**
   * 将自己的验证方式加入容器.
   *
   * @return
   */
  @Bean
  public ShiroRealm shiroRealm() {
    return new ShiroRealm();
  }

  /**
   * 权限管理，配置主要是Realm的管理认证.
   */
  @Bean
  public SecurityManager securityManager() {

    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setRealm(shiroRealm());
    securityManager.setCacheManager(SpringApplicationContext.getBean(RedisCacheManager.class));
//    securityManager.setSessionManager();
    return securityManager;
  }

  /**
   * Filter工厂，设置对应的过滤条件和跳转条件.
   */
  @Bean
  public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    shiroFilterFactoryBean.setSecurityManager(securityManager);
    Map<String, String> map = new HashMap();
    //登出
    map.put("/logout", "logout");
    //对所有用户认证
    map.put("/**", "authc");

    Map<String, Filter> filterMap = new HashMap<>();
    filterMap.put("authc", new FormAuthenticationFilter());
    filterMap.put("logout", new LogoutFilter());
    filterMap.put("Ajax", new LogoutFilter());

    //登录
    shiroFilterFactoryBean.setLoginUrl("/login");
    //首页
    shiroFilterFactoryBean.setSuccessUrl("/index");
    //错误页面，认证不通过跳转
    shiroFilterFactoryBean.setUnauthorizedUrl("/error");
    shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
    shiroFilterFactoryBean.setFilters(filterMap);
    return shiroFilterFactoryBean;
  }


  /**
   * 加入注解的使用，不加入这个注解不生效.
   */
  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
    AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
    authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
    return authorizationAttributeSourceAdvisor;
  }

}