/**
 * Copyright 2018 asiainfo Inc.
 **/

package com.coocle.springboot.entity.modules.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:jiangchao
 * @CreateDate:2018/10/4
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Permission implements Serializable {

  @Getter
  @Setter
  String permissionCode;

  @Getter
  @Setter
  Date startDate;

  @Getter
  @Setter
  Date endDate;

  @Getter
  @Setter
  String updateUserName;

  @Getter
  @Setter
  Date updateTime;

}
