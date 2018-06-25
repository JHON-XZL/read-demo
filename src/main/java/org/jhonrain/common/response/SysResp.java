package org.jhonrain.common.response;

import org.apache.http.HttpStatus;
import org.jhonrain.common.constants.RespCodeContants;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>功能描述</br>返回数据的处理</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 15:01
 */
public class SysResp extends HashMap<String, Object> {

  private static final long serialVersionUID = 1L;

  public static final String CODE = "code";

  public static final String MSG = "msg";

  public SysResp() {
    put(SysResp.CODE, RespCodeContants.SUCCESS);
  }

  public static SysResp error() {
    return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "系统繁忙，请稍后再试！");
  }

  public static SysResp error(String msg) {
    return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
  }

  public static SysResp error(int code, String msg) {
    SysResp sysResp = new SysResp();
    sysResp.put(SysResp.CODE, code);
    sysResp.put(SysResp.MSG, msg);
    return sysResp;
  }

  public static SysResp success(String msg) {
    SysResp sysResp = new SysResp();
    sysResp.put(SysResp.MSG, msg);
    return sysResp;
  }

  public static SysResp success(Map<String, Object> map) {
    SysResp sysResp = new SysResp();
    sysResp.putAll(map);
    return sysResp;
  }

  public static SysResp success() {
    return new SysResp();
  }

  @Override
  public SysResp put(String key, Object value) {
    super.put(key, value);
    return this;
  }
}
