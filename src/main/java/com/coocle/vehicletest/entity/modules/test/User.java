package com.coocle.vehicletest.entity.modules.test;

import com.coocle.vehicletest.utils.modules.common.VehicleTool;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class User implements Serializable {

  String userName;

  String phone;

  String password;

  Date startDate;

  String acctId;

  Province province;

  Set<RolePermission> rolePermissions;


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public String getAcctId() {
    return acctId;
  }

  public void setAcctId(String acctId) {
    this.acctId = acctId;
  }

  public Province getProvince() {
    return province;
  }

  public void setProvince(Province province) {
    this.province = province;
  }

  public Set<RolePermission> getRolePermissions() {
    return rolePermissions;
  }

  public void setRolePermissions(Set<RolePermission> rolePermissions) {
    this.rolePermissions = rolePermissions;
  }

  public User(String userName, String phone, String password, Date startDate, String acctId, Province province, Set<RolePermission> rolePermissions) {
    this.userName = userName;
    this.phone = phone;
    this.password = password;
    this.startDate = startDate;
    this.acctId = acctId;
    this.province = province;
    this.rolePermissions = rolePermissions;
  }

  public User() {
  }

  @Override
  public String toString() {
    return "User{" +
        "userName='" + userName + '\'' +
        ", phone='" + phone + '\'' +
        ", password='" + password + '\'' +
        ", startDate=" + VehicleTool.date2String(startDate) +
        ", acctId='" + acctId + '\'' +
        ", province=" + province +
        ", rolePermissions=" + rolePermissions +
        '}';
  }
}
