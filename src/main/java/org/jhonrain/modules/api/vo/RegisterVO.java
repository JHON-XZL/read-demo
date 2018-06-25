package org.jhonrain.modules.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>功能描述</br></p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/21 21:39
 */
@Data
@ApiModel(value = "注册用户对象", description = "register")
public class RegisterVO extends BaseVO {

  @ApiModelProperty(name = "openId",value = "小程序openId")
  private String openId;

  @ApiModelProperty(name = "nickname",value = "昵称")
  private String nickname;

  @ApiModelProperty(name = "avatar",value = "头像")
  private String avatar;

}
