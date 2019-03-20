/**
 * Copyright 2018 asiainfo Inc.
 **/

package com.coocle.springboot.entity.modules.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author:jiangchao
 * @CreateDate:2019/3/19
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {

  @Getter
  @Setter
  String roleCode;

  @Getter
  @Setter
  String roleName;

  @Getter
  @Setter
  String roleDesc;

  @Getter
  @Setter
  Date startDate;

  @Getter
  @Setter
  Date endDate;

  @Getter
  @Setter
  Date updateTime;

  @Getter
  @Setter
  String updateUserName;

  @Getter
  @Setter
  String roleType;

  @Getter
  @Setter
  List<Permission> permissions;

}
