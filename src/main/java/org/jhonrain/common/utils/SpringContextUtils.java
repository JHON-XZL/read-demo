package org.jhonrain.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <p>功能描述</br>Spring Context 工具类</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 15:01
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {
  public static ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext)
          throws BeansException {
    SpringContextUtils.applicationContext = applicationContext;
  }

  public static Object getBean(String name) {
    return applicationContext.getBean(name);
  }

  public static <T> T getBean(String name, Class<T> requiredType) {
    return applicationContext.getBean(name, requiredType);
  }

  /**
   * <p> 功能描述：获取bean对象</p>
   *
   * @param componentClass 要加载的bean类
   * @param <T>            自定义的类型
   * @return
   */
  public static <T> T getComponent(Class<T> componentClass) {
    return applicationContext.getBean(componentClass);

  }

  public static boolean containsBean(String name) {
    return applicationContext.containsBean(name);
  }

  public static boolean isSingleton(String name) {
    return applicationContext.isSingleton(name);
  }

  public static Class<? extends Object> getType(String name) {
    return applicationContext.getType(name);
  }

}