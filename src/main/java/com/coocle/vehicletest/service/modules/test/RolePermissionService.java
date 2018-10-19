package com.coocle.vehicletest.service.modules.test;

import com.coocle.vehicletest.entity.modules.test.RolePermission;

import java.util.List;

public interface RolePermissionService {

  /**
   * 根据用户名查询权限.
   *
   * @param roleCode
   * @return
   */
  public List<RolePermission> getRolePermissionByRoleCode(String roleCode);

  /**
   * 添加权限.
   *
   * @param rolePermission
   */
  public void addRolePermission(RolePermission rolePermission);

  /**
   * 删除权限.
   *
   * @param rolePermission
   */
  public void deleteRolePermission(RolePermission rolePermission);

  /**
   * 修改权限.
   *
   * @param rolePermission
   */
  public void modifyRolePermission(RolePermission rolePermission);

}
