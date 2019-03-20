package com.coocle.springboot.mapper.cen.modules.test;

import com.coocle.springboot.entity.modules.test.Permission;

import java.util.List;

public interface RolePermissionMapper {

  /**
   * 根据用户名查询权限.
   *
   * @param roleCode
   * @return
   */
  public List<Permission> selectRolePermissionByRoleCode(String roleCode);

  /**
   * 新增权限.
   *
   * @param permission
   */
  public void insertRolePermission(Permission permission);

  /**
   * 删除权限.
   *
   * @param permission
   */
  public void deleteRolePermission(Permission permission);

  /**
   * 修改权限.
   *
   * @param permission
   */
  public void updateRolePermission(Permission permission);
}
