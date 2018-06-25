package org.jhonrain.modules.api.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>功能描述</br>会员充值记录</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 18:20
 */
@Data
public class MemberTradeRecordDO {

  /**
   * 会员Id
   */
  private Long id;

  /**
   * 会员Id
   */
  private Long memberId;

  /**
   * 交易渠道（1.微信，2.支付宝，3.线下）
   */
  private Integer channel;

  /**
   * 方式（1：增加  2：扣减）
   */
  private Integer payWay;

  /**
   * 交易单号（唯一对账编号）
   */
  private String billNum;

  /**
   * 交易金额
   */
  private BigDecimal money;

  /**
   * 交易备注
   */
  private String remark;

  /**
   * 交易时间
   */
  private Date createDate;
}
