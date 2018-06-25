package org.jhonrain.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>功能描述</br>自定义异常</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 14:56
 */
@Getter
@Setter
public class RainbowException extends RuntimeException {

  private String msg;

  private int code = 500;

  public RainbowException(String msg) {
    super(msg);
    this.msg = msg;
  }

  public RainbowException(String msg, Throwable e) {
    super(msg, e);
    this.msg = msg;
  }

  public RainbowException(String msg, int code) {
    super(msg);
    this.msg = msg;
    this.code = code;
  }

  public RainbowException(String msg, int code, Throwable e) {
    super(msg, e);
    this.msg = msg;
    this.code = code;
  }
}
