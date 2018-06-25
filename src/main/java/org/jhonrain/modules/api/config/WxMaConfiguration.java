package org.jhonrain.modules.api.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.bean.WxMaKefuMessage;
import cn.binarywang.wx.miniapp.bean.WxMaTemplateMessage;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import cn.binarywang.wx.miniapp.message.WxMaMessageHandler;
import cn.binarywang.wx.miniapp.message.WxMaMessageRouter;
import com.google.common.collect.Lists;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Configuration
@ConditionalOnClass(WxMaService.class)
@EnableConfigurationProperties(WxMaProperties.class)
public class WxMaConfiguration {

  @Autowired
  private WxMaProperties properties;

  @Bean
  @ConditionalOnMissingBean
  public WxMaConfig maConfig() {
    WxMaInMemoryConfig config = new WxMaInMemoryConfig();
    config.setAppid(this.properties.getAppid());
    config.setSecret(this.properties.getSecret());
    config.setToken(this.properties.getToken());
    config.setAesKey(this.properties.getAesKey());
    config.setMsgDataFormat(this.properties.getMsgDataFormat());
    return config;
  }

  @Bean
  @ConditionalOnMissingBean
  public WxMaService wxMaService(WxMaConfig maConfig) {
    WxMaService service = new WxMaServiceImpl();
    service.setWxMaConfig(maConfig);
    return service;
  }
}
