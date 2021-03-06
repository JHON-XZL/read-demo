package org.jhonrain.modules.sys.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jhonrain.common.annotation.SysLog;
import org.jhonrain.common.exception.RainbowException;
import org.jhonrain.common.response.SysResp;
import org.jhonrain.common.utils.Constant;
import org.jhonrain.modules.sys.entity.SysMenuDO;
import org.jhonrain.modules.sys.service.ShiroService;
import org.jhonrain.modules.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 系统菜单
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午9:58:15
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends AbstractController {

  @Autowired
  private SysMenuService sysMenuService;

  @Autowired
  private ShiroService shiroService;

  /**
   * 所有菜单列表
   */
  @RequestMapping("/list")
  @RequiresPermissions("sys:menu:list")
  public List<SysMenuDO> list() {
    return sysMenuService.queryList(new HashMap<String, Object>());
  }

  /**
   * 选择菜单(添加、修改菜单)
   */
  @RequestMapping("/select")
  @RequiresPermissions("sys:menu:select")
  public SysResp select() {
    //查询列表数据
    List<SysMenuDO> menuList = sysMenuService.queryNotButtonList();

    //添加顶级菜单
    SysMenuDO root = new SysMenuDO();
    root.setMenuId(0L);
    root.setName("一级菜单");
    root.setParentId(-1L);
    root.setOpen(true);
    menuList.add(root);

    return SysResp.success().put("menuList", menuList);
  }

  /**
   * 角色授权菜单
   */
  @RequestMapping("/perms")
  @RequiresPermissions("sys:menu:perms")
  public SysResp perms() {
    //查询列表数据
    List<SysMenuDO> menuList = null;

    //只有超级管理员，才能查看所有管理员列表
    if (getUserId() == Constant.SUPER_ADMIN) {
      menuList = sysMenuService.queryList(new HashMap<String, Object>());
    } else {
      menuList = sysMenuService.queryUserList(getUserId());
    }

    return SysResp.success().put("menuList", menuList);
  }

  /**
   * 菜单信息
   */
  @RequestMapping("/info/{menuId}")
  @RequiresPermissions("sys:menu:info")
  public SysResp info(@PathVariable("menuId") Long menuId) {
    SysMenuDO menu = sysMenuService.queryObject(menuId);
    return SysResp.success().put("menu", menu);
  }

  /**
   * 保存
   */
  @SysLog("保存菜单")
  @RequestMapping("/save")
  @RequiresPermissions("sys:menu:save")
  public SysResp save(@RequestBody SysMenuDO menu) {
    //数据校验
    verifyForm(menu);

    sysMenuService.save(menu);

    return SysResp.success();
  }

  /**
   * 修改
   */
  @SysLog("修改菜单")
  @RequestMapping("/update")
  @RequiresPermissions("sys:menu:update")
  public SysResp update(@RequestBody SysMenuDO menu) {
    //数据校验
    verifyForm(menu);

    sysMenuService.update(menu);

    return SysResp.success();
  }

  /**
   * 删除
   */
  @SysLog("删除菜单")
  @RequestMapping("/delete")
  @RequiresPermissions("sys:menu:delete")
  public SysResp delete(long menuId) {
    if (menuId <= 30) {
      return SysResp.error("系统菜单，不能删除");
    }

    //判断是否有子菜单或按钮
    List<SysMenuDO> menuList = sysMenuService.queryListParentId(menuId);
    if (menuList.size() > 0) {
      return SysResp.error("请先删除子菜单或按钮");
    }

    sysMenuService.deleteBatch(new Long[]{menuId});

    return SysResp.success();
  }

  /**
   * 用户菜单列表
   */
  @RequestMapping("/user")
  public SysResp user() {
    List<SysMenuDO> menuList = sysMenuService.getUserMenuList(getUserId());
    Set<String> permissions = shiroService.getUserPermissions(getUserId());
    return SysResp.success().put("menuList", menuList).put("permissions", permissions);
  }

  /**
   * 验证参数是否正确
   */
  private void verifyForm(SysMenuDO menu) {
    if (StringUtils.isBlank(menu.getName())) {
      throw new RainbowException("菜单名称不能为空");
    }

    if (menu.getParentId() == null) {
      throw new RainbowException("上级菜单不能为空");
    }

    //菜单
    if (menu.getType() == Constant.MenuType.MENU.getValue()) {
      if (StringUtils.isBlank(menu.getUrl())) {
        throw new RainbowException("菜单URL不能为空");
      }
    }

    //上级菜单类型
    int parentType = Constant.MenuType.CATALOG.getValue();
    if (menu.getParentId() != 0) {
      SysMenuDO parentMenu = sysMenuService.queryObject(menu.getParentId());
      parentType = parentMenu.getType();
    }

    //目录、菜单
    if (menu.getType() == Constant.MenuType.CATALOG.getValue() ||
            menu.getType() == Constant.MenuType.MENU.getValue()) {
      if (parentType != Constant.MenuType.CATALOG.getValue()) {
        throw new RainbowException("上级菜单只能为目录类型");
      }
      return;
    }

    //按钮
    if (menu.getType() == Constant.MenuType.BUTTON.getValue()) {
      if (parentType != Constant.MenuType.MENU.getValue()) {
        throw new RainbowException("上级菜单只能为菜单类型");
      }
      return;
    }
  }
}
