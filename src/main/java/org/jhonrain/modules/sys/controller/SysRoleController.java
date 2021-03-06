package org.jhonrain.modules.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jhonrain.common.annotation.SysLog;
import org.jhonrain.common.response.SysResp;
import org.jhonrain.common.utils.Constant;
import org.jhonrain.common.utils.PageData;
import org.jhonrain.common.utils.Query;
import org.jhonrain.common.validator.ValidatorUtils;
import org.jhonrain.modules.sys.entity.SysRoleDO;
import org.jhonrain.modules.sys.service.SysRoleMenuService;
import org.jhonrain.modules.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月8日 下午2:18:33
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {
  @Autowired
  private SysRoleService sysRoleService;
  @Autowired
  private SysRoleMenuService sysRoleMenuService;

  /**
   * 角色列表
   */
  @RequestMapping("/list")
  @RequiresPermissions("sys:role:list")
  public SysResp list(@RequestParam Map<String, Object> params) {
    //如果不是超级管理员，则只查询自己创建的角色列表
    if (getUserId() != Constant.SUPER_ADMIN) {
      params.put("createUserId", getUserId());
    }

    //查询列表数据
    Query query = new Query(params);
    List<SysRoleDO> list = sysRoleService.queryList(query);
    int total = sysRoleService.queryTotal(query);

    PageData pageUtil = new PageData(list, total, query.getLimit(), query.getPage());

    return SysResp.success().put("page", pageUtil);
  }

  /**
   * 角色列表
   */
  @RequestMapping("/select")
  @RequiresPermissions("sys:role:select")
  public SysResp select() {
    Map<String, Object> map = new HashMap<>();

    //如果不是超级管理员，则只查询自己所拥有的角色列表
    if (getUserId() != Constant.SUPER_ADMIN) {
      map.put("createUserId", getUserId());
    }
    List<SysRoleDO> list = sysRoleService.queryList(map);

    return SysResp.success().put("list", list);
  }

  /**
   * 角色信息
   */
  @RequestMapping("/info/{roleId}")
  @RequiresPermissions("sys:role:info")
  public SysResp info(@PathVariable("roleId") Long roleId) {
    SysRoleDO role = sysRoleService.queryObject(roleId);

    //查询角色对应的菜单
    List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
    role.setMenuIdList(menuIdList);

    return SysResp.success().put("role", role);
  }

  /**
   * 保存角色
   */
  @SysLog("保存角色")
  @RequestMapping("/save")
  @RequiresPermissions("sys:role:save")
  public SysResp save(@RequestBody SysRoleDO role) {
    ValidatorUtils.validateEntity(role);

    role.setCreateUserId(getUserId());
    sysRoleService.save(role);

    return SysResp.success();
  }

  /**
   * 修改角色
   */
  @SysLog("修改角色")
  @RequestMapping("/update")
  @RequiresPermissions("sys:role:update")
  public SysResp update(@RequestBody SysRoleDO role) {
    ValidatorUtils.validateEntity(role);

    role.setCreateUserId(getUserId());
    sysRoleService.update(role);

    return SysResp.success();
  }

  /**
   * 删除角色
   */
  @SysLog("删除角色")
  @RequestMapping("/delete")
  @RequiresPermissions("sys:role:delete")
  public SysResp delete(@RequestBody Long[] roleIds) {
    sysRoleService.deleteBatch(roleIds);

    return SysResp.success();
  }
}
