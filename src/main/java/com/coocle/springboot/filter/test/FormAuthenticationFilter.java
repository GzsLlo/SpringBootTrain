/**
 * Copyright 2016 asiainfo Inc.
 **/
package com.coocle.springboot.filter.test;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 * @author tangsz
 */
@Service
public class FormAuthenticationFilter extends org.apache.shiro.web.filter.authc.FormAuthenticationFilter {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired
  private CookieLocaleResolver resolver;

//  @Autowired
//  private EncryptUtils encryptUtils;

  public static final String DEFAULT_CAPTCHA_PARAM = "captcha";
  public static final String DEFAULT_MESSAGE_PARAM = "message";
  private static final String PWD = "";
  private String captchaParam = DEFAULT_CAPTCHA_PARAM;
  private String messageParam = DEFAULT_MESSAGE_PARAM;

  protected UsernamePasswordToken createToken(ServletRequest request, ServletResponse response) {


    return null;
  }

  protected boolean executeLogin(ServletRequest request,
                                 ServletResponse response) throws Exception {
    return true;
  }

  protected void doCaptchaValidate(HttpServletRequest request, UsernamePasswordToken token) {

  }

  protected boolean onLoginFailure(AuthenticationToken token,
                                   AuthenticationException e, ServletRequest request, ServletResponse response) {
    String className = e.getClass().getName();
    String message;
    if (e.getClass().isAssignableFrom(IncorrectCredentialsException.class)
        || e.getClass().isAssignableFrom(UnknownAccountException.class)) {
//    if (IncorrectCredentialsException.class.getName().equals(className)
//        || UnknownAccountException.class.getName().equals(className)) {
      message = "用户或密码错误, 请重试.";
    } else if (e instanceof ExpiredCredentialsException) {
      message = "用户密码过期.";
    } else if (e.getMessage() != null && StringUtils.startsWith(e.getMessage(), "msg:")) {
      message = StringUtils.replace(e.getMessage(), "msg:", "");
      if (message.contains("com.alibaba.dubbo") ||
          message.contains("zookeeper") ||
          message.contains("timeout")) {
        message = "系统问题，请稍联系管理员！";
      }
    } else {
      message = "系统问题，请稍联系管理员！错误信息:</br>" + e.getMessage();
      e.printStackTrace();
    }
    request.setAttribute(getFailureKeyAttribute(), className);
    request.setAttribute(getMessageParam(), message);
    return true;
  }

  public String getCaptchaParam() {
    return captchaParam;
  }

  protected String getCaptcha(ServletRequest request) {
    return WebUtils.getCleanParam(request, getCaptchaParam());
  }

  public String getMessageParam() {
    return messageParam;
  }
}
