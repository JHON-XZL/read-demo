package org.jhonrain.modules.api.entity;

import lombok.Data;

import java.util.Date;

/**
 * <p>功能描述</br>书籍评论表</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 17:54
 */
@Data
public class BookDiscussDO {
  /**
   * 主键
   */
  private Long id;
  /**
   * 书籍ID
   */
  private Long bookId;
  /**
   * 会员ID
   */
  private Long memberId;
  /**
   * 会员头像
   */
  private String avatarUrl;
  /**
   * 评论内容
   */
  private String discuss;

  /**
   * 评论时间
   */
  private Date createDate;

}
