package com.coocle.springboot.service.modules.test;

import com.coocle.springboot.entity.modules.test.Permission;

import java.util.List;

public interface RolePermissionService {

  /**
   * 根据用户名查询权限.
   *
   * @param roleCode
   * @return
   */
  public List<Permission> getRolePermissionByRoleCode(String roleCode);

  /**
   * 添加权限.
   *
   * @param permission
   */
  public void addRolePermission(Permission permission);

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
  public void modifyRolePermission(Permission permission);

}
