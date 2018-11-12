/**
 * Copyright 2018 lostyear Inc.
 **/

package com.coocle.springboot.controller.modules.test;

import com.coocle.springboot.entity.modules.test.RolePermission;
import com.coocle.springboot.entity.modules.test.User;
import com.coocle.springboot.service.modules.test.RolePermissionService;
import com.coocle.springboot.service.modules.test.UserService;
import com.coocle.springboot.utils.modules.common.RedisUtils;
import com.coocle.springboot.utils.modules.common.VehicleTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiangchao
 * Created on 2018/3/25.
 */
@Controller
@RequestMapping("views")
public class LoginController {

  @Autowired
  private UserService userService;

  @Autowired
  private RolePermissionService rolePermissionService;

  private Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * 登陆页面.
   *
   * @return mv
   */
  @RequestMapping("/modules/user/login.html")
  public ModelAndView doLogin() {
    selectUserByUsernameAndPassword();
    getUsersByAcctName();
    getRolePermissionByRoleCode();
    deleteRolePermission();
    addRolePermission();
    modifyRolePermission();
//    testRedis();

    Map params = new HashMap();
    params.put("iccid", "iccid不存在");
    ModelAndView mv = new ModelAndView("test/simDiagnostic", params);
    return mv;
  }

  /**
   * selectUserByUsernameAndPassword.
   */
  private void selectUserByUsernameAndPassword() {
    User user = userService.selectUserByUsernameAndPassword("acctAdminDev");
    logger.debug("LoginController.doLogin user = {}", user);
  }

  /**
   * getUsersByAcctName.
   */
  private void getUsersByAcctName() {
    List userParams = new ArrayList();
    userParams.add("acctAdminDev");
    userParams.add("0102service");
    List<User> users = userService.getUsersByAcctName(userParams);
    if (VehicleTool.notEmpty(users)) {
      for (int i = 0; i < users.size(); i++) {
        User userItem = users.get(i);
        logger.debug("LoginController.doLogin user = {}", userItem);
      }
    }
  }

  /**
   * getRolePermissionByRoleCode.
   */
  private void getRolePermissionByRoleCode() {
    logger.debug("ModelAndView getRolePermissionByRoleCode");
    List<RolePermission> rolePermissions = rolePermissionService.getRolePermissionByRoleCode("acctAdminDev");
    if (VehicleTool.notEmpty(rolePermissions)) {
      for (RolePermission rolePermission : rolePermissions) {
        logger.debug("rolePermission = {}", rolePermission);
      }
    }
  }

  /**
   * addRolePermission.
   */
  private void addRolePermission() {
    RolePermission rolePermission = new RolePermission();
    rolePermission.setRoleCode("coocle");
    rolePermission.setPermissionCode("1001");
    rolePermission.setPermissionType("1");
    rolePermission.setStartDate(VehicleTool.string2Date(VehicleTool.getStartDate()));
    rolePermission.setEndDate(VehicleTool.string2Date(VehicleTool.getEndDate()));
    logger.debug("LoginController.addRolePermission rolePermission = {}", rolePermission);
    rolePermissionService.addRolePermission(rolePermission);
  }

  /**
   * deleteRolePermission.
   */
  private void deleteRolePermission() {
    RolePermission rolePermission = new RolePermission();
    rolePermission.setPermissionCode("1001");
    rolePermission.setRoleCode("coocle");
    rolePermissionService.deleteRolePermission(rolePermission);
  }

  /**
   * modifyRolePermission.
   */
  private void modifyRolePermission() {
    RolePermission rolePermission = new RolePermission();
    rolePermission.setPermissionCode("1001");
    rolePermission.setRoleCode("coocle");
    rolePermission.setEndDate(new Date());
    rolePermissionService.modifyRolePermission(rolePermission);
  }

  /**
   * testRedis.
   */
  private void testRedis() {
    RedisUtils.setString("userName", "coocle");
    logger.debug("ModelAndView.testSetRedis = {}", RedisUtils.getValues("userName"));
//    RedisUtils.delKey("userName");
    logger.debug("ModelAndView.testSetRedis = {}", RedisUtils.getValues("userName"));
  }

}
