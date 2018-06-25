package org.jhonrain.modules.api.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>功能描述</br>书籍实体</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/21 21:27
 */
@Data
public class BookInfoDO {


  private Long id;

  /**
   * 类目
   */
  private Long categoryId;
  /**
   * 书籍名称
   */
  private String name;
  /**
   * 作者
   */
  private String author;

  /**
   * 出版社
   */
  private String publisher;

  /**
   * 书籍的isbn
   */
  private String ssbn;

  /**
   * 描述
   */
  private String description;
  /**
   * 价格
   */
  private BigDecimal price;

  /**
   * 折扣
   */
  private BigDecimal discount;

  /**
   * 封面
   */
  private String cover;

  /**
   * 书籍状态（1：上架；2：下架）
   */
  private Integer status;
  /**
   * 书籍发布日期
   */
  private Date publishDate;

  /**
   * 创建日期
   */
  private Date createDate;
  /**
   * 更新日期
   */
  private Date updateDate;
}
