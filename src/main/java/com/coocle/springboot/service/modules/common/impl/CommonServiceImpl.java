/**
 * Copyright 2018 asiainfo Inc.
 **/

package com.coocle.springboot.service.modules.common.impl;

import com.coocle.springboot.mapper.info.modules.common.CommonMapper;
import com.coocle.springboot.service.modules.common.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:jiangchao
 * @CreateDate:2018/10/5
 */
@Service
@Transactional
public class CommonServiceImpl implements CommonService {

  @Autowired
  private CommonMapper commonMapper;

  private Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * 获取当前时间.
   *
   * @return
   */
  @Override
  public String getNow() {
    return commonMapper.selectNow();
  }
}
