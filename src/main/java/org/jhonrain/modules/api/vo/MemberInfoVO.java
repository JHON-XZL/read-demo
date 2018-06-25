package org.jhonrain.modules.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>功能描述</br>会员注册的VO对象</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 13:38
 */
@Data
@ApiModel(value = "会员信息", description = "userInfo")
public class MemberInfoVO extends BaseVO{

  private static final long serialVersionUID = 4295314974827278242L;
  /**
   * 微信小程序返回的code
   */
  @ApiModelProperty(name = "code",value = "微信小程序登录返回的code",required = true)
  private String code;
  /**
   * 昵称
   */
  @ApiModelProperty(name = "nickName",value = "昵称",required = true)
  private String nickName;
  /**
   * 头像url
   */
  @ApiModelProperty(name = "avatarUrl",value = "头像url",required = true)
  private String avatarUrl;
  /**
   * 国家
   */
  @ApiModelProperty(name = "country",value = "国家")
  private String country;
  /**
   * 省份
   */
  @ApiModelProperty(name = "province",value = "省份")
  private String province;
  /**
   * 城市
   */
  @ApiModelProperty(name = "city",value = "城市")
  private String city;
  /**
   * 性别（1；男，0：女）
   */
  @ApiModelProperty(name = "gender",value = "性别（1；男，0：女）")
  private Integer gender;
  /**
   * 语言
   */
  @ApiModelProperty(name = "language",value = "语言")
  private String language;
}
