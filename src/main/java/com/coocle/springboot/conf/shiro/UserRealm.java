/**
 * Copyright 2018 asiainfo Inc.
 **/

package com.coocle.springboot.conf.shiro;

import com.coocle.springboot.entity.modules.test.User;
import com.coocle.springboot.service.modules.test.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:jiangchao
 * @CreateDate:2019/3/19
 */
@Configuration
public class UserRealm extends AuthorizingRealm {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private UserService userService;

  @Bean
  public UserRealm shiroRealm() {
    UserRealm userRealm = new UserRealm();
    return userRealm;
  }

  /**
   * 角色权限和对应权限添加.
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    //获取登录用户名
    String name = (String) principalCollection.getPrimaryPrincipal();

    //查询用户名称
    User user = userService.selectUserByUsername(name);
    //添加角色和权限
    SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

    return simpleAuthorizationInfo;
  }

  /**
   * 用户认证.
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
      throws AuthenticationException {
    //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
    if (authenticationToken.getPrincipal() == null) {
      return null;
    }
    //获取用户信息
    String name = authenticationToken.getPrincipal().toString();
    User user = userService.selectUserByUsername(name);
    if (user == null) {
      //这里返回后会报出对应异常
      return null;
    } else {
      //这里验证authenticationToken和simpleAuthenticationInfo的信息
      SimpleAuthenticationInfo simpleAuthenticationInfo =
          new SimpleAuthenticationInfo(name, user.getPassword().toString(), getName());

      return simpleAuthenticationInfo;
    }
  }

}
