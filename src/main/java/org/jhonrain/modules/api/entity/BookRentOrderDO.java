package org.jhonrain.modules.api.entity;

import lombok.Data;

import java.util.Date;

/**
 * <p>功能描述</br>书籍借阅记录</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 18:19
 */
@Data
public class BookRentOrderDO {

  private Long id;

  /**
   * 会员ID
   */
  private Long memberId;

  /**
   * 书籍ID列表（逗号隔开）
   */
  private String bookIds;

  /**
   * 数量
   */
  private Integer count;

  /**
   * 支付记录ID
   */
  private Long payRecordId;

  /**
   * 订单状态（借阅中|已归还）
   */
  private Integer status;

  /**
   * 备注
   */
  private String remark;

  /**
   * 创建时间
   */
  private Date createDate;

  /**
   * 归还日期
   */
  private Date returnDate;

}
