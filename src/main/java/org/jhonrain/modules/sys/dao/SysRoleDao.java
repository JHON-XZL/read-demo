package org.jhonrain.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.jhonrain.modules.sys.entity.SysRoleDO;

import java.util.List;

/**
 * <p>功能描述</br>角色管理</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
@Mapper
public interface SysRoleDao extends BaseDao<SysRoleDO> {

  /**
   * 查询用户创建的角色ID列表
   */
  List<Long> queryRoleIdList(Long createUserId);
}
