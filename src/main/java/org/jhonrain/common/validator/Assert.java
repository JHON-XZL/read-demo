package org.jhonrain.common.validator;

import org.apache.commons.lang.StringUtils;
import org.jhonrain.common.exception.RainbowException;

/**
 * <p>功能描述</br></p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 14:47
 */
public abstract class Assert {

  public static void isBlank(String str, String message) {
    if (StringUtils.isBlank(str)) {
      throw new RainbowException(message);
    }
  }

  public static void isNull(Object object, String message) {
    if (object == null) {
      throw new RainbowException(message);
    }
  }
}