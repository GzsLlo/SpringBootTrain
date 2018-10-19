package com.coocle.vehicletest.service.modules.test.impl;


import com.coocle.vehicletest.entity.modules.test.User;
import com.coocle.vehicletest.mapper.cen.modules.test.UserMapper;
import com.coocle.vehicletest.service.modules.test.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  private Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * 根据用户名获取用户.
   *
   * @param acctName
   * @return
   */
  @Override
  public User selectUserByUsernameAndPassword(String acctName) {
    logger.debug("UserServiceImpl.selectUserByUsernameAndPassword acctName = {}", acctName);
    return userMapper.selectUserByUsernameAndPassword(acctName);
  }

  /**
   * 根据用户名获取多个用户.
   *
   * @param acctNames
   * @return
   */
  @Override
  public List<User> getUsersByAcctName(List acctNames) {
    logger.debug("UserServiceImpl.getUsersByAcctName acctNames = {}", acctNames);
    return userMapper.selectUsersByAcctName(acctNames);
  }

}
