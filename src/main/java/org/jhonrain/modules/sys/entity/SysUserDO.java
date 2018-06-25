package org.jhonrain.modules.sys.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.jhonrain.common.validator.group.AddGroup;
import org.jhonrain.common.validator.group.UpdateGroup;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>功能描述</br>系统用户</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
@Data
public class SysUserDO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 用户ID
   */
  private Long userId;

  /**
   * 用户名
   */
  @NotBlank(message = "用户名不能为空", groups = {AddGroup.class, UpdateGroup.class})
  private String username;

  /**
   * 密码
   */
  @NotBlank(message = "密码不能为空", groups = AddGroup.class)
  private String password;

  /**
   * 盐
   */
  private String salt;

  /**
   * 邮箱
   */
  @NotBlank(message = "邮箱不能为空", groups = {AddGroup.class, UpdateGroup.class})
  @Email(message = "邮箱格式不正确", groups = {AddGroup.class, UpdateGroup.class})
  private String email;

  /**
   * 手机号
   */
  private String mobile;

  /**
   * 状态  0：禁用   1：正常
   */
  private Integer status;

  /**
   * 角色ID列表
   */
  private List<Long> roleIdList;

  /**
   * 创建者ID
   */
  private Long createUserId;

  /**
   * 创建时间
   */
  private Date createTime;

}
