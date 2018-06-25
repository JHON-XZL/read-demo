package org.jhonrain.modules.api.entity;

import lombok.Data;

/**
 * <p>功能描述</br>图书的图片信息（不包括封面）</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 18:11
 */
@Data
public class BookPicturesDO {
  /**
   * 主键ID
   */
  private Long id;
  /**
   * 书籍ID
   */
  private Long bookId;

  /**
   * cdn的路径前缀
   */
  private String cdnPrefix;

  /**
   * 宽度
   */
  private Integer width;

  /**
   * 高度
   */
  private Integer height;

  /**
   * 备注
   */
  private String remark;

  /**
   * 路径
   */
  private String path;
}
