package org.jhonrain.modules.sys.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * <p>功能描述</br>角色和菜单的对应关系</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
@Data
public class SysRoleMenuDO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  /**
   * 角色ID
   */
  private Long roleId;

  /**
   * 菜单ID
   */
  private Long menuId;

}
