package org.jhonrain.common.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.jhonrain.common.exception.RainbowException;
import org.jhonrain.modules.sys.entity.SysUserDO;

/**
 * <p>功能描述</br>Shiro工具类</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 15:01
 */
public class ShiroUtils {

  public static Session getSession() {
    return SecurityUtils.getSubject().getSession();
  }

  public static Subject getSubject() {
    return SecurityUtils.getSubject();
  }

  public static SysUserDO getUserEntity() {
    return (SysUserDO) SecurityUtils.getSubject().getPrincipal();
  }

  public static Long getUserId() {
    return getUserEntity().getUserId();
  }

  public static void setSessionAttribute(Object key, Object value) {
    getSession().setAttribute(key, value);
  }

  public static Object getSessionAttribute(Object key) {
    return getSession().getAttribute(key);
  }

  public static boolean isLogin() {
    return SecurityUtils.getSubject().getPrincipal() != null;
  }

  public static void logout() {
    SecurityUtils.getSubject().logout();
  }

  public static String getKaptcha(String key) {
    Object kaptcha = getSessionAttribute(key);
    if (kaptcha == null) {
      throw new RainbowException("验证码已失效");
    }
    getSession().removeAttribute(key);
    return kaptcha.toString();
  }

}
