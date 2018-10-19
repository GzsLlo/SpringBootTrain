package com.coocle.springboot.service.modules.test.impl;


import com.coocle.springboot.entity.modules.test.RolePermission;
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
  public List<RolePermission> getRolePermissionByRoleCode(String roleCode) {
    logger.debug("RolePermissionServiceImpl.getRolePermissionByRoleCode roleCode = {}", roleCode);
    return rolePermissionMapper.selectRolePermissionByRoleCode(roleCode);
  }

  /**
   * 新增权限.
   *
   * @param rolePermission
   */
  @Override
  public void addRolePermission(RolePermission rolePermission) {
    logger.debug("RolePermissionServiceImpl.addRolePermission rolePermission = {}", rolePermission);
    rolePermissionMapper.insertRolePermission(rolePermission);
  }

  /**
   * 删除权限.
   *
   * @param rolePermission
   */
  @Override
  public void deleteRolePermission(RolePermission rolePermission) {
    logger.debug("RolePermissionServiceImpl.deleteRolePermission rolePermission = {}", rolePermission);
    rolePermissionMapper.deleteRolePermission(rolePermission);
  }

  /**
   * 修改权限.
   *
   * @param rolePermission
   */
  @Override
  public void modifyRolePermission(RolePermission rolePermission) {
    logger.debug("RolePermissionServiceImpl.modifyRolePermission rolePermission = {}", rolePermission);
    rolePermissionMapper.updateRolePermission(rolePermission);
  }
}
