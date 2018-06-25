package org.jhonrain.common.response;

import lombok.Data;
import org.jhonrain.common.constants.RespCodeContants;

/**
 * <p>功能描述</br>返回值对象的封装</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 15:01
 */
@Data
public class RainbowResp {

  /**
   * 返回码
   */
  private int code;
  /**
   * 返回消息
   */
  private String msg;
  /**
   * 返回数据
   */
  private Object data;

  private RainbowResp(int code, String msg, Object data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  private RainbowResp(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  private RainbowResp(Object data) {
    this.code = RespCodeContants.SUCCESS;
    this.data = data;
  }

  public static RainbowResp success(Object data) {
    return new RainbowResp(data);
  }

  public static RainbowResp error(int code, String msg) {
    return new RainbowResp(code, msg);
  }

  public static RainbowResp error(int code, String msg, Object data) {
    return new RainbowResp(code, msg, data);
  }
}
