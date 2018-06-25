package org.jhonrain.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>功能描述</br>日期处理</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
public class DateUtils {
  /**
   * 时间格式(yyyy-MM-dd)
   */
  public final static String DATE_PATTERN = "yyyy-MM-dd";
  /**
   * 时间格式(yyyy-MM-dd HH:mm:ss)
   */
  public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

  public static String format(Date date) {
    return format(date, DATE_PATTERN);
  }

  public static String format(Date date, String pattern) {
    if (date != null) {
      SimpleDateFormat df = new SimpleDateFormat(pattern);
      return df.format(date);
    }
    return null;
  }
}
