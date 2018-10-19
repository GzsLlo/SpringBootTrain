/**
 * Copyright 2018 asiainfo Inc.
 **/

package com.coocle.springboot.entity.modules.test;

import com.coocle.springboot.utils.modules.common.VehicleTool;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:jiangchao
 * @CreateDate:2018/10/4
 */
public class RolePermission implements Serializable {

  String roleCode;

  String permissionCode;

  String permissionType;

  Date startDate;

  Date endDate;

  public String getRoleCode() {
    return roleCode;
  }

  public void setRoleCode(String roleCode) {
    this.roleCode = roleCode;
  }

  public String getPermissionCode() {
    return permissionCode;
  }

  public void setPermissionCode(String permissionCode) {
    this.permissionCode = permissionCode;
  }

  public String getPermissionType() {
    return permissionType;
  }

  public void setPermissionType(String permissionType) {
    this.permissionType = permissionType;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public RolePermission(String roleCode, String permissionCode, String permissionType, Date startDate, Date endDate) {
    this.roleCode = roleCode;
    this.permissionCode = permissionCode;
    this.permissionType = permissionType;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public RolePermission() {
  }

  @Override
  public String toString() {
    return "RolePermission{" +
        "roleCode='" + roleCode + '\'' +
        ", permissionCode='" + permissionCode + '\'' +
        ", permissionType='" + permissionType + '\'' +
        ", startDate=" + VehicleTool.date2String(startDate) +
        ", endDate=" + VehicleTool.date2String(endDate) +
        '}';
  }
}
