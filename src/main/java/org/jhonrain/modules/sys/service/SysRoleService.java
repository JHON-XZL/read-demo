package org.jhonrain.modules.sys.service;

import org.jhonrain.modules.sys.entity.SysRoleDO;

import java.util.List;
import java.util.Map;


/**
 * 角色
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:42:52
 */
public interface SysRoleService {

  SysRoleDO queryObject(Long roleId);

  List<SysRoleDO> queryList(Map<String, Object> map);

  int queryTotal(Map<String, Object> map);

  void save(SysRoleDO role);

  void update(SysRoleDO role);

  void deleteBatch(Long[] roleIds);

  /**
   * 查询用户创建的角色ID列表
   */
  List<Long> queryRoleIdList(Long createUserId);
}
