package com.coocle.springboot.service.modules.test;

import com.coocle.springboot.entity.modules.test.User;

import java.util.List;


public interface UserService {

  /**
   * 根据用户名获取用户.
   *
   * @param acctName
   * @return
   */
  public User selectUserByUsername(String acctName);

  /**
   * 根据用户名获取多个用户.
   *
   * @param acctNames
   * @return
   */
  public List<User> getUsersByAcctName(List acctNames);

}
