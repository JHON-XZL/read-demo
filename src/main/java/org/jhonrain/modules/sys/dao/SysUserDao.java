package org.jhonrain.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.jhonrain.modules.sys.entity.SysUserDO;

import java.util.List;
import java.util.Map;

/**
 * <p>功能描述</br>系统用户</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUserDO> {

  /**
   * 查询用户的所有权限
   *
   * @param userId 用户ID
   */
  List<String> queryAllPerms(Long userId);

  /**
   * 查询用户的所有菜单ID
   */
  List<Long> queryAllMenuId(Long userId);

  /**
   * 根据用户名，查询系统用户
   */
  SysUserDO queryByUserName(String username);

  /**
   * 修改密码
   */
  int updatePassword(Map<String, Object> map);
}
