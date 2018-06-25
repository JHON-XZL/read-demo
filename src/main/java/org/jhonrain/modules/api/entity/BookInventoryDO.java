package org.jhonrain.modules.api.entity;

import lombok.Data;

/**
 * <p>功能描述</br>库存</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 18:09
 */
@Data
public class BookInventoryDO {
  /**
   * 主键ID
   */
  private Long id;

  /**
   * 书籍ID
   */
  private Long bookId;
  /**
   * 总数
   */
  private Integer totalCount;

  /**
   * 可用数量
   */
  private Integer surplusCount;

}
