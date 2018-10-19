/**
 * Copyright 2018 asiainfo Inc.
 **/

package com.coocle.vehicletest.utils.modules.common;

import com.coocle.vehicletest.service.modules.common.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * 常用工具类.
 *
 * @Author:jiangchao
 * @CreateDate:2018/10/4
 */
@Component
public class VehicleTool {

  private static Logger logger = LoggerFactory.getLogger(VehicleTool.class);

  private static CommonService commonService = SpringApplicationContext.getBean(CommonService.class);

  /**
   * date2String.
   *
   * @param date
   * @param format
   * @return
   */
  public static String date2String(Date date, String... format) {
    String dateStr = null;
    if (null == date) {
      return dateStr;
    }
    String fmt = null;
    if (null != format && format.length > 0) {
      fmt = format[0];
    }
    if (StringUtils.isEmpty(fmt)) {
      fmt = "yyyy-MM-dd HH:mm:ss";
    }
    SimpleDateFormat sdf = new SimpleDateFormat(fmt);
    try {
      dateStr = sdf.format(date);
    } catch (Exception e) {
      dateStr = "date或format格式不正确";
    }
    return dateStr;
  }

  /**
   * String2Date.
   *
   * @param date
   * @param format
   * @return
   */
  public static Date string2Date(String date, String... format) {
    Date returnDate = null;

    if (!VehicleTool.notEmpty(date)) {
      return returnDate;
    }

    String fmt = null;
    if (null != format && format.length > 0) {
      fmt = format[0];
    }
    if (StringUtils.isEmpty(fmt)) {
      fmt = "yyyy-MM-dd HH:mm:ss";
    }
    SimpleDateFormat sdf = new SimpleDateFormat(fmt);
    try {
      returnDate = sdf.parse(date);
    } catch (ParseException e) {
      logger.error("VehicleTool.String2Date error = {}", e);
    }
    return returnDate;
  }

  /**
   * notEmpty.
   *
   * @param object
   * @return
   */
  public static boolean notEmpty(Object object) {
    boolean notEmpty = false;

    if (null == object) {
      return notEmpty;
    }

    if (object instanceof Collection) {
      if (((Collection) object).size() > 0) {
        notEmpty = true;
      }
    } else if (object instanceof Map) {
      if (((Map) object).size() > 0) {
        notEmpty = true;
      }
    } else if (object instanceof String) {
      if (!StringUtils.isEmpty(object) && !"".equals(((String) object).trim())) {
        notEmpty = true;
      }
    } else {
      if (!StringUtils.isEmpty(object)) {
        notEmpty = true;
      }
    }
    return notEmpty;
  }

  /**
   * 获取开始时间.
   *
   * @return
   */
  public static String getStartDate() {
    return commonService.getNow();
  }

  /**
   * 获取结束时间.
   *
   * @return
   */
  public static String getEndDate() {
    return "2099-12-31 23:23:23";
  }

}
