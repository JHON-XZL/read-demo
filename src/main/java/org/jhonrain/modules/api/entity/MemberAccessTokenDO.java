package org.jhonrain.modules.api.entity;

import com.sun.xml.internal.rngom.binary.DataExceptPattern;
import lombok.Data;

import java.util.Date;

/**
 * <p>功能描述</br></p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 12:54
 */
@Data
public class MemberAccessTokenDO {

  /**
   * 主键
   */
  private Integer id;
  /**
   * openID
   */
  private String openId;
  /**
   * 微信的sessionKey
   */
  private String sessionKey;
  /**
   * 系统自己生产的accessToken
   */
  private String accessToken;

  /**
   * 创建时间
   */
  private Date createDate;

  /**
   * 更新时间
   */
  private Date updateDate;

  /**
   * 过期时间
   */
  private Date expireDate;

}
