package org.jhonrain.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.jhonrain.modules.sys.entity.SysUserRoleDO;

import java.util.List;

/**
 * <p>功能描述</br>用户与角色对应关系</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRoleDO> {

  /**
   * 根据用户ID，获取角色ID列表
   */
  List<Long> queryRoleIdList(Long userId);
}
