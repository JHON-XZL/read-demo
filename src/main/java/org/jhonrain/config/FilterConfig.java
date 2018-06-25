package org.jhonrain.config;

import org.jhonrain.common.xss.XssFilter;
import org.jhonrain.modules.api.filter.ApiFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;

/**
 * <p>功能描述</br>Filter配置</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
@Configuration
public class FilterConfig {

  @Bean
  public FilterRegistrationBean apiFilterRegistration() {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setDispatcherTypes(DispatcherType.REQUEST);
    registration.setFilter(new ApiFilter());
    registration.addUrlPatterns("/v1/api/*");
    registration.setName("apiFilter");
    registration.setOrder(Integer.MAX_VALUE - 2);
    return registration;
  }

  @Bean
  public FilterRegistrationBean shiroFilterRegistration() {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(new DelegatingFilterProxy("shiroFilter"));
    //该值缺省为false，表示生命周期由SpringApplicationContext管理，设置为true则表示由ServletContainer管理
    registration.addInitParameter("targetFilterLifecycle", "true");
    registration.setEnabled(true);
    registration.setOrder(Integer.MAX_VALUE - 1);
    registration.addUrlPatterns("/*");
    return registration;
  }

  @Bean
  public FilterRegistrationBean xssFilterRegistration() {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setDispatcherTypes(DispatcherType.REQUEST);
    registration.setFilter(new XssFilter());
    registration.addUrlPatterns("/*");
    registration.setName("xssFilter");
    registration.setOrder(Integer.MAX_VALUE);
    return registration;
  }
}
