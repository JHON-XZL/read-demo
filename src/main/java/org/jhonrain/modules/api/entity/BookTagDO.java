package org.jhonrain.modules.api.entity;

import lombok.Data;

/**
 * <p>功能描述</br>书籍标签</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 18:11
 */
@Data
public class BookTagDO {
  /**
   * 主键
   */
  private Long id;

  /**
   * 书籍ID
   */
  private Long bookId;

  /**
   * 标签名称
   */
  private String name;
}
