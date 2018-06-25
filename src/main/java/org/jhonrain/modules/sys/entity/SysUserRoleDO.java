package org.jhonrain.modules.sys.entity;


import lombok.Data;

import java.io.Serializable;


/**
 * <p>功能描述</br>用户与角色对应关系</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
@Data
public class SysUserRoleDO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  /**
   * 用户ID
   */
  private Long userId;

  /**
   * 角色ID
   */
  private Long roleId;

}
