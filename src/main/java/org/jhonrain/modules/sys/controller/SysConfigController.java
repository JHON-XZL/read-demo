package org.jhonrain.modules.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jhonrain.common.annotation.SysLog;
import org.jhonrain.common.response.SysResp;
import org.jhonrain.common.utils.PageData;
import org.jhonrain.common.utils.Query;
import org.jhonrain.common.validator.ValidatorUtils;
import org.jhonrain.modules.sys.entity.SysConfigDO;
import org.jhonrain.modules.sys.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 系统配置信息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月4日 下午6:55:53
 */

@RestController
@RequestMapping("/sys/config")
public class SysConfigController extends AbstractController {

  @Autowired
  private SysConfigService sysConfigService;

  /**
   * 所有配置列表
   */
  @RequestMapping("/list")
  @RequiresPermissions("sys:config:list")
  public SysResp list(@RequestParam Map<String, Object> params) {
    //查询列表数据
    Query query = new Query(params);
    List<SysConfigDO> configList = sysConfigService.queryList(query);
    int total = sysConfigService.queryTotal(query);

    PageData pageData = new PageData(configList, total, query.getLimit(), query.getPage());

    return SysResp.success().put("page", pageData);
  }


  /**
   * 配置信息
   */
  @RequestMapping("/info/{id}")
  @RequiresPermissions("sys:config:info")
  public SysResp info(@PathVariable("id") Long id) {
    SysConfigDO config = sysConfigService.queryObject(id);
    return SysResp.success().put("config", config);
  }

  /**
   * 保存配置
   */
  @SysLog("保存配置")
  @RequestMapping("/save")
  @RequiresPermissions("sys:config:save")
  public SysResp save(@RequestBody SysConfigDO config) {
    ValidatorUtils.validateEntity(config);

    sysConfigService.save(config);

    return SysResp.success();
  }

  /**
   * 修改配置
   */
  @SysLog("修改配置")
  @RequestMapping("/update")
  @RequiresPermissions("sys:config:update")
  public SysResp update(@RequestBody SysConfigDO config) {
    ValidatorUtils.validateEntity(config);

    sysConfigService.update(config);

    return SysResp.success();
  }

  /**
   * 删除配置
   */
  @SysLog("删除配置")
  @RequestMapping("/delete")
  @RequiresPermissions("sys:config:delete")
  public SysResp delete(@RequestBody Long[] ids) {
    sysConfigService.deleteBatch(ids);

    return SysResp.success();
  }

}
