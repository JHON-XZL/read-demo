package org.jhonrain.modules.api.web.api;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.jhonrain.common.response.RainbowResp;
import org.jhonrain.common.validator.Assert;
import org.jhonrain.modules.api.entity.MemberAccessTokenDO;
import org.jhonrain.modules.api.entity.MemberDO;
import org.jhonrain.modules.api.service.MemberAccessTokenService;
import org.jhonrain.modules.api.service.MemberService;
import org.jhonrain.modules.api.vo.MemberInfoVO;
import org.jhonrain.modules.api.vo.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * <p>功能描述</br>会员控制器</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName xxxx
 * @date 2018/6/21 21:19
 */
@Slf4j
@RestController
@RequestMapping("v1/api/member")
@Api(value = "会员操作相关API", description = "会员相关操作接口", tags = {"用户操作V1.0"})
public class ApiMemberController {

  @Autowired
  private WxMaService wxService;

  @Autowired
  private MemberService memberService;

  @Autowired
  private MemberAccessTokenService memberAccessTokenService;

  /**
   * <pre>换取session</pre>
   *
   * @param memberInfo 用户信息
   * @return
   */
  @PostMapping("/code")
  @ApiOperation(value = "用户初始化接口", notes = "微信小程序首次登录的时候，需要进行默认注册，后台返回给微信一个登录状态的唯一key")
  public RainbowResp initUserInfo(@RequestBody MemberInfoVO memberInfo) {
    String code = memberInfo.getCode();
    if (StringUtils.isBlank(code)) {
      return RainbowResp.error(200001, "code不能为空");
    }
    try {
      WxMaJscode2SessionResult session = this.wxService.getUserService().getSessionInfo(code);
      String sessionKey = session.getSessionKey();
      String openId = session.getOpenid();
      MemberDO memberDO = memberService.initMemberInfo(openId, sessionKey, memberInfo);
      return RainbowResp.success(memberDO);
    } catch (WxErrorException e) {
      log.error(e.getMessage(), e);
      return RainbowResp.error(999999, e.getMessage());
    }

  }

  /**
   * <pre>登录</pre>
   *
   * @param username 用户名
   * @param password 密码
   * @return
   */
  @PostMapping("/login")
  @ApiOperation(value = "登录接口", notes = "用户输入账号和密码进行系统登录")
  @ApiImplicitParams({
          @ApiImplicitParam(paramType = "query", dataType = "string", name = "username", value = "用户名", required = true),
          @ApiImplicitParam(paramType = "query", dataType = "string", name = "password", value = "密码", required = true)
  })
  public RainbowResp login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
    Assert.isBlank(username, "用户名不能为空");
    Assert.isBlank(password, "密码不能为空");

    return RainbowResp.success("success login");
  }



  @PostMapping("/register")
  @ApiOperation(value = "注册接口", notes = "用户填写注册信息")
  public RainbowResp register(@RequestBody RegisterVO register) {
    System.out.println(register.toString());
    return RainbowResp.success("register success");
  }
}
