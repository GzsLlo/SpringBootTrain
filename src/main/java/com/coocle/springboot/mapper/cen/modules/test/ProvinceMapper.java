package com.coocle.springboot.mapper.cen.modules.test;

import com.coocle.springboot.entity.modules.test.Province;

public interface ProvinceMapper {
  public Province selectProvinceByProvinceCode(String provinceCode);

}
