package org.jhonrain.modules.sys.entity;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.annotation.security.DenyAll;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>功能描述</br>角色</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
@Data
public class SysRoleDO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 角色ID
   */
  private Long roleId;

  /**
   * 角色名称
   */
  @NotBlank(message = "角色名称不能为空")
  private String roleName;

  /**
   * 备注
   */
  private String remark;

  /**
   * 创建者ID
   */
  private Long createUserId;

  private List<Long> menuIdList;

  /**
   * 创建时间
   */
  private Date createTime;
}
