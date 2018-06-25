package org.jhonrain.modules.api.entity;

import lombok.Data;

import java.util.Date;

/**
 * <p>功能描述</br>书籍预约（收藏-->书单功能在前端）</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 18:18
 */
@Data
public class BookSubscribeDO {

  /**
   * id
   */
  private Long id;

  /**
   * 会员ID
   */
  private Long memberId;

  /**
   * 书籍ID
   */
  private Long bookId;

  /**
   * 创建日期
   */
  private Date createDate;


}
