package com.coocle.springboot.entity.modules.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {

  @Getter
  @Setter
  String userName;

  @Getter
  @Setter
  String phone;

  @Getter
  @Setter
  String password;

  @Getter
  @Setter
  Date startDate;

  @Getter
  @Setter
  String acctId;

  @Getter
  @Setter
  Province province;

  @Getter
  @Setter
  List<Role> roles;

}
