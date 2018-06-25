package org.jhonrain.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.jhonrain.modules.sys.entity.SysRoleMenuDO;

import java.util.List;

/**
 * <p>功能描述</br>角色与菜单对应关系</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
@Mapper
public interface SysRoleMenuDao extends BaseDao<SysRoleMenuDO> {

  /**
   * 根据角色ID，获取菜单ID列表
   */
  List<Long> queryMenuIdList(Long roleId);
}
