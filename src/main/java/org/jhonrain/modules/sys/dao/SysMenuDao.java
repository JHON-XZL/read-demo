package org.jhonrain.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.jhonrain.modules.sys.entity.SysMenuDO;

import java.util.List;

/**
 * <p>功能描述</br>菜单管理</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
@Mapper
public interface SysMenuDao extends BaseDao<SysMenuDO> {

  /**
   * 根据父菜单，查询子菜单
   *
   * @param parentId 父菜单ID
   */
  List<SysMenuDO> queryListParentId(Long parentId);

  /**
   * 获取不包含按钮的菜单列表
   */
  List<SysMenuDO> queryNotButtonList();

  /**
   * 查询用户的权限列表
   */
  List<SysMenuDO> queryUserList(Long userId);
}
