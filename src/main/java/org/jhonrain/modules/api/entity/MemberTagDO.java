package org.jhonrain.modules.api.entity;

import lombok.Data;

/**
 * <p>功能描述</br>会员标签</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 18:26
 */
@Data
public class MemberTagDO {

  /**
   * ID
   */
  private Long id;
  /**
   * 会员ID
   */
  private Long memberId;
  /**
   * 标签名称
   */
  private String name;
}
