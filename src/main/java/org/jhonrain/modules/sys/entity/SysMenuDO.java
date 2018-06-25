package org.jhonrain.modules.sys.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>功能描述</br>菜单管理</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
@Data
public class SysMenuDO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 菜单ID
   */
  private Long menuId;

  /**
   * 父菜单ID，一级菜单为0
   */
  private Long parentId;

  /**
   * 父菜单名称
   */
  private String parentName;

  /**
   * 菜单名称
   */
  private String name;

  /**
   * 菜单URL
   */
  private String url;

  /**
   * 授权(多个用逗号分隔，如：user:list,user:create)
   */
  private String perms;

  /**
   * 类型     0：目录   1：菜单   2：按钮
   */
  private Integer type;

  /**
   * 菜单图标
   */
  private String icon;

  /**
   * 排序
   */
  private Integer orderNum;

  /**
   * ztree属性
   */
  private Boolean open;

  private List<?> list;

}
