package com.coocle.springboot.mapper.cen.modules.test;


import com.coocle.springboot.entity.modules.test.User;

import java.util.List;

public interface UserMapper {

  /**
   * 根据用户名获取用户.
   *
   * @param acctName
   * @return
   */
  public User selectUserByUsernameAndPassword(String acctName);

  /**
   * 根据用户名获取多个用户.
   *
   * @param acctNames
   * @return
   */
  public List<User> selectUsersByAcctName(List acctNames);

}
