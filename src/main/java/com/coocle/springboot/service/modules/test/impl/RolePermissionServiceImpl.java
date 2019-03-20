package com.coocle.springboot.service.modules.test.impl;


import com.coocle.springboot.entity.modules.test.Permission;
import com.coocle.springboot.mapper.cen.modules.test.RolePermissionMapper;
import com.coocle.springboot.service.modules.test.RolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class RolePermissionServiceImpl implements RolePermissionService {

  @Autowired
  private RolePermissionMapper rolePermissionMapper;

  private Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * 根据用户名查询权限.
   *
   * @param roleCode
   * @return
   */
  @Override
  public List<Permission> getRolePermissionByRoleCode(String roleCode) {
    logger.debug("RolePermissionServiceImpl.getRolePermissionByRoleCode roleCode = {}", roleCode);
    return rolePermissionMapper.selectRolePermissionByRoleCode(roleCode);
  }

  /**
   * 新增权限.
   *
   * @param permission
   */
  @Override
  public void addRolePermission(Permission permission) {
    logger.debug("RolePermissionServiceImpl.addRolePermission permission = {}", permission);
    rolePermissionMapper.insertRolePermission(permission);
  }

  /**
   * 删除权限.
   *
   * @param permission
   */
  @Override
  public void deleteRolePermission(Permission permission) {
    logger.debug("RolePermissionServiceImpl.deleteRolePermission permission = {}", permission);
    rolePermissionMapper.deleteRolePermission(permission);
  }

  /**
   * 修改权限.
   *
   * @param permission
   */
  @Override
  public void modifyRolePermission(Permission permission) {
    logger.debug("RolePermissionServiceImpl.modifyRolePermission permission = {}", permission);
    rolePermissionMapper.updateRolePermission(permission);
  }
}
