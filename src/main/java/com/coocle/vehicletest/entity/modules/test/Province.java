/**
 * Copyright 2018 asiainfo Inc.
 **/

package com.coocle.vehicletest.entity.modules.test;

import com.coocle.vehicletest.utils.modules.common.VehicleTool;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:jiangchao
 * @CreateDate:2018/10/4
 */
public class Province implements Serializable {

  String provinceCode;

  String provinceName;

  Date startDate;

  public String getProvinceCode() {
    return provinceCode;
  }

  public void setProvinceCode(String provinceCode) {
    this.provinceCode = provinceCode;
  }

  public String getProvinceName() {
    return provinceName;
  }

  public void setProvinceName(String provinceName) {
    this.provinceName = provinceName;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Province(String provinceCode, String provinceName, Date startDate) {
    this.provinceCode = provinceCode;
    this.provinceName = provinceName;
    this.startDate = startDate;
  }

  public Province() {
  }

  @Override
  public String toString() {
    return "Province{" +
        "provinceCode='" + provinceCode + '\'' +
        ", provinceName='" + provinceName + '\'' +
        ", startDate=" + VehicleTool.date2String(startDate) +
        '}';
  }
}
