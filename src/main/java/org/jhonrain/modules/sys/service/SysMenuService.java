package org.jhonrain.modules.sys.service;

import org.jhonrain.modules.sys.entity.SysMenuDO;

import java.util.List;
import java.util.Map;


/**
 * 菜单管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:42:16
 */
public interface SysMenuService {

  /**
   * 根据父菜单，查询子菜单
   *
   * @param parentId   父菜单ID
   * @param menuIdList 用户菜单ID
   */
  List<SysMenuDO> queryListParentId(Long parentId, List<Long> menuIdList);

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
   * 获取用户菜单列表
   */
  List<SysMenuDO> getUserMenuList(Long userId);

  /**
   * 查询菜单
   */
  SysMenuDO queryObject(Long menuId);

  /**
   * 查询菜单列表
   */
  List<SysMenuDO> queryList(Map<String, Object> map);

  /**
   * 查询总数
   */
  int queryTotal(Map<String, Object> map);

  /**
   * 保存菜单
   */
  void save(SysMenuDO menu);

  /**
   * 修改
   */
  void update(SysMenuDO menu);

  /**
   * 删除
   */
  void deleteBatch(Long[] menuIds);

  /**
   * 查询用户的权限列表
   */
  List<SysMenuDO> queryUserList(Long userId);
}
