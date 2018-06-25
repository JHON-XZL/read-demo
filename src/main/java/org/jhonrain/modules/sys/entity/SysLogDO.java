package org.jhonrain.modules.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * <p>功能描述</br>系统日志</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
@Data
public class SysLogDO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  /**
   * 用户名
   **/
  private String username;
  /**
   * 用户操作
   **/
  private String operation;
  /**
   * 请求方法
   **/
  private String method;
  /**
   * 请求参数
   **/
  private String params;
  /**
   * IP地址
   **/
  private String ip;
  /**
   * 创建时间
   **/
  private Date createDate;
}
