package org.jhonrain.modules.api.enums;

import lombok.Getter;

/**
 * <p>功能描述</br></p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 13:56
 */
@Getter
public enum MemberStatusEnum {
  ACTIVE(1),
  FROZEN(0);

  private Integer value;

  MemberStatusEnum(Integer value) {
    this.value = value;
  }
}
