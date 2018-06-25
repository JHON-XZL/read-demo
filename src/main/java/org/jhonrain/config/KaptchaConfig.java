package org.jhonrain.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * <p>功能描述</br>生成验证码配置</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
@Configuration
public class KaptchaConfig {

  @Bean
  public DefaultKaptcha producer() {
    Properties properties = new Properties();
    properties.put("kaptcha.border", "no");
    properties.put("kaptcha.textproducer.font.color", "black");
    properties.put("kaptcha.textproducer.char.space", "5");
    Config config = new Config(properties);
    DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
    defaultKaptcha.setConfig(config);
    return defaultKaptcha;
  }
}
