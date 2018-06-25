package org.jhonrain.modules.api.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>功能描述</br>会员详细信息</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 18:22
 */
public class MemberDetailDO {
  /**
   * 主键Id
   */
  private Long id;

  /**
   * 会员ID
   */
  private Long memberId;
  /**
   * 真实姓名
   */
  private String realName;

  /**
   * 电话
   */
  private String phone;

  /**
   * 邮件
   */
  private String email;

  /**
   * 证件类型
   */
  private Integer identifyType;

  /**
   * 证件号
   */
  private String identifyNum;

  /**
   * 省份
   */
  private String province;

  /**
   * 城市
   */
  private String city;

  /**
   * 详细地址
   */
  private String address;

  /**
   * 账户余额
   */
  private BigDecimal suplusAccount;

  /**
   * 创建时间
   */
  private Date createDate;

  /**
   * 更新时间
   */
  private Date updateDate;

}
