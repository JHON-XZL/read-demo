package org.jhonrain.modules.api.vo;

import lombok.Data;

/**
 * <p>功能描述</br>登陆的vo</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/21 21:36
 */
@Data
public class LoginVO extends BaseVO{
  /**
   * 用户名
   */
  private String username;
  /**
   * 密码
   */
  private String password;
}
