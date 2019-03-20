/**
 * Copyright 2017 asiainfo Inc.
 **/
package com.coocle.springboot.conf.shiro;

import org.apache.shiro.web.servlet.AdviceFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author zhangshaoyong
 *         Created on 2017/11/17.
 *         ajax请求拦截器：将session过期的请求重定向到登录页面
 */
public class AjaxFilter extends AdviceFilter {

  //重定向url
  private String url;

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Override
  protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;
    String requestType = req.getHeader("X-Requested-With");
    HttpSession session = req.getSession(false);
    //ajax请求 并且session失效
    if ("XMLHttpRequest".equals(requestType) && session == null) {
      log.debug("Ajax Session Expired");
      res.setHeader("SessionState","SessionTimeOut");
      res.setHeader("redirectAddr",url);
      return false;//返回false将中断后续拦截器链的执行
    }
    return true;//继续执行
  }
  @Override
  protected void postHandle(ServletRequest request, ServletResponse response) throws Exception {

  }
  @Override
  public void afterCompletion(ServletRequest request, ServletResponse response, Exception exception) throws Exception {

  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
