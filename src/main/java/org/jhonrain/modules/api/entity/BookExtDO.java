package org.jhonrain.modules.api.entity;

import lombok.Data;

/**
 * <p>功能描述</br>书籍的阅读量和点赞量</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 17:58
 */
@Data
public class BookExtDO {

  /**
   * 主键
   */
  private Long id;
  /**
   * 书籍Id
   */
  private Long bookId;
  /**
   * 浏览量
   */
  private Integer scan;
  /**
   * 点赞量
   */
  private Integer love;


}
