package org.jhonrain.common.xss;

import org.apache.commons.lang.StringUtils;
import org.jhonrain.common.exception.RainbowException;

/**
 * <p>功能描述</br>SQL过滤</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 15:01
 */
public class SQLFilter {

  /**
   * SQL注入过滤
   *
   * @param str 待验证的字符串
   */
  public static String sqlInject(String str) {
    if (StringUtils.isBlank(str)) {
      return null;
    }
    //去掉'|"|;|\字符
    str = StringUtils.replace(str, "'", "");
    str = StringUtils.replace(str, "\"", "");
    str = StringUtils.replace(str, ";", "");
    str = StringUtils.replace(str, "\\", "");

    //转换成小写
    str = str.toLowerCase();

    //非法字符
    String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alert", "drop"};

    //判断是否包含非法字符
    for (String keyword : keywords) {
      if (str.indexOf(keyword) != -1) {
        throw new RainbowException("包含非法字符");
      }
    }

    return str;
  }
}