package org.jhonrain.common.utils;

/**
 * <p>功能描述</br>常量</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
public class Constant {
  /**
   * 超级管理员ID
   */
  public static final int SUPER_ADMIN = 1;

  /**
   * <p>功能描述</br>菜单类型</p>
   *
   * @author jiangy19
   * @version v1.0
   * @projectName happy-read
   * @date 2018/6/19 13:56
   */
  public enum MenuType {
    /**
     * 目录
     */
    CATALOG(0),
    /**
     * 菜单
     */
    MENU(1),
    /**
     * 按钮
     */
    BUTTON(2);

    private int value;

    private MenuType(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }


  /**
   * 云服务商
   */
  public enum CloudService {
    /**
     * 七牛云
     */
    QINIU(1),
    /**
     * 阿里云
     */
    ALIYUN(2),
    /**
     * 腾讯云
     */
    QCLOUD(3);

    private int value;

    private CloudService(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

}
