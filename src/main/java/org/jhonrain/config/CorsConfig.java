package org.jhonrain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <p>功能描述</br>cors配置</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 16:18
 */
@Configuration
public class CorsConfig {

  @Bean
  public WebMvcConfigurer corsConfigurer() {

    return new WebMvcConfigurerAdapter() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/v1/api/**")
                .allowedOrigins("*")
                .allowedMethods("PUT", "DELETE", "POST")
                .allowedHeaders("accessToken")
                .allowCredentials(false)
                .maxAge(3600);
      }
    };
  }
}
