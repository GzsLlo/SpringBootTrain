/**
 * Copyright 2018 asiainfo Inc.
 **/

package com.coocle.springboot.conf.session;

import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.servlet.Cookie;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.codec.Base64;

/**
 * @Author:jiangchao
 * @CreateDate:2019/3/20
 */
@Configuration
public class SessionConfig {

  @Autowired
  private RedisManager redisManager;

  @Autowired
  private SessionDAO redisSessionDAO;

  @Autowired
  private Cookie sessionIdCookie;

  @Autowired
  private Cookie rememberMeCookie;

  @Bean
  public RedisSessionDAO redisSessionDAO (){
    RedisSessionDAO sessionDAO = new RedisSessionDAO();
    sessionDAO.setRedisManager(redisManager);
    return sessionDAO;
  }

  @Bean
  public SimpleCookie sessionIdCookie() {
    SimpleCookie simpleCookie = new SimpleCookie();
    simpleCookie.setHttpOnly(true);
    simpleCookie.setMaxAge(-1);
    simpleCookie.setName("sid");
    return simpleCookie;
  }

  @Bean
  public SimpleCookie rememberMeCookie() {
    SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
    simpleCookie.setHttpOnly(true);
    simpleCookie.setMaxAge(604800);
    return simpleCookie;
  }

  @Bean
  public DefaultWebSessionManager defaultWebSessionManager() {
    DefaultWebSessionManager securityManager = new DefaultWebSessionManager();
    securityManager.setGlobalSessionTimeout(1800000);
    securityManager.setDeleteInvalidSessions(true);
    securityManager.setSessionDAO(redisSessionDAO);
    securityManager.setSessionIdCookieEnabled(true);
    securityManager.setSessionIdCookie(sessionIdCookie);
    return securityManager;
  }

  @Bean
  public CookieRememberMeManager cookieRememberMeManager(){
    CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
    rememberMeManager.setCipherKey(new Base64().decode("4AvVhmFLUs0KTA3Kprs dag=="));
    rememberMeManager.setCookie(rememberMeCookie);
    return rememberMeManager;
  }

}
