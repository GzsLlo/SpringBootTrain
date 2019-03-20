package com.coocle.springboot.entity.modules.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 城市实体类
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class City implements Serializable {

  private static final long serialVersionUID = -1L;

  /**
   * 城市编号
   */
  @Getter
  @Setter
  private Long id;

  /**
   * 省份编号
   */
  @Getter
  @Setter
  private Long provinceId;

  /**
   * 城市名称
   */
  @Getter
  @Setter
  private String cityName;

  /**
   * 描述
   */
  @Getter
  @Setter
  private String description;
}
