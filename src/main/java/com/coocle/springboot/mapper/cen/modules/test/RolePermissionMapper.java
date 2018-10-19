package com.coocle.springboot.mapper.cen.modules.test;

import com.coocle.springboot.entity.modules.test.RolePermission;

import java.util.List;

public interface RolePermissionMapper {

  /**
   * 根据用户名查询权限.
   *
   * @param roleCode
   * @return
   */
  public List<RolePermission> selectRolePermissionByRoleCode(String roleCode);

  /**
   * 新增权限.
   *
   * @param rolePermission
   */
  public void insertRolePermission(RolePermission rolePermission);

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
  public void updateRolePermission(RolePermission rolePermission);
}
