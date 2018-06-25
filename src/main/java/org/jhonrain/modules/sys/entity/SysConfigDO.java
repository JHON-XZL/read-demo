package org.jhonrain.modules.sys.entity;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;


/**
 * <p>功能描述</br>系统配置信息</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
@Data
public class SysConfigDO {
  private Long id;

  @NotBlank(message = "参数名不能为空")
  private String key;

  @NotBlank(message = "参数值不能为空")
  private String value;

  private String remark;
}
