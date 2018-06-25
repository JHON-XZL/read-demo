package org.jhonrain.modules.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>功能描述</br>系统用户Token</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
@Data
public class SysUserTokenDO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 用户ID
   **/
  private Long userId;
  /**
   * token
   **/
  private String token;
  /**
   * 过期时间
   **/
  private Date expireTime;
  /**
   * 更新时间
   **/
  private Date updateTime;

}
