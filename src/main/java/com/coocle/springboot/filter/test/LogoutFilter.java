/**
 * Copyright 2017 asiainfo Inc.
 **/

package com.coocle.springboot.filter.test;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: jingyang
 * @CreateDate: 2017/11/18
 * @Version: v1.0
 */
public class LogoutFilter extends org.apache.shiro.web.filter.authc.LogoutFilter {

  private final Logger log = LoggerFactory.getLogger(getClass());

//  @Autowired
//  private RedisCacheUtils redisCacheUtils;

  protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
    Subject subject = getSubject(request, response);
    String redirectUrl = getRedirectUrl(request, response, subject);
    try {
      // 清除 cookie
      Cookie[] cookies = ((HttpServletRequest) request).getCookies();
      if (cookies != null) {
        for (Cookie cookie : cookies) {
          log.debug("*****************{} -- {}*****************", cookie.getName(), cookie.getValue());
          if (cookie.getName().equals("iot-connect")) {
            cookie.setValue(null);
            cookie.setMaxAge(0);
            cookie.setSecure(true);
            cookie.setPath("/");
            ((HttpServletResponse) response).addCookie(cookie);

            break;
          }
        }
      }
      Session session = subject.getSession();
      Object cacheKey = session.getAttribute("cacheKey");
      log.debug("cacheKey---------- " + cacheKey);
      if (cacheKey != null) {
        String key = cacheKey.toString();
        //清除权限和角色缓存
//        redisCacheUtils.removePermissionCacheByKey(key);
//        redisCacheUtils.removeRoleCacheByKey(key);
//        redisCacheUtils.removeMenuPermissionCacheByKey(key);
      }
      subject.logout();
    } catch (SessionException ise) {
      log.debug("Encountered session exception during logout.  This can generally safely be ignored.", ise);
    }
    issueRedirect(request, response, redirectUrl);
    return false;
  }
}
