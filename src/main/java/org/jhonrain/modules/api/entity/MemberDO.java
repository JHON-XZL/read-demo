package org.jhonrain.modules.api.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>功能描述</br>会员类</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/21 21:23
 */
@Data
public class MemberDO implements Serializable {

  private static final long serialVersionUID = 7299138219772710161L;

  private Long id;
  /**
   * 会员卡号
   */
  private String memberCardNum;
  /**
   * 微信openId
   */
  private String openId;
  /**
   * 昵称
   */
  private String nickName;

  /**
   * 头像url
   */
  private String avatarUrl;
  /**
   * 国家
   */
  private String country;
  /**
   * 省份
   */
  private String province;
  /**
   * 城市
   */
  private String city;

  /**
   * 状态
   */
  private Integer status;
  /**
   * 积分
   */
  private Integer score;
  /**
   * 创建日期
   */
  private Date createDate;
  /**
   * 更新日期
   */
  private Date updateDate;

  /**
   * 系统自己生成的token
   */
  private String accessToken;
  /**
   * 过期日期
   */
  private Date expireTime;

}
