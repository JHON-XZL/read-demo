package org.jhonrain.modules.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jhonrain.common.response.SysResp;
import org.jhonrain.common.utils.PageData;
import org.jhonrain.common.utils.Query;
import org.jhonrain.modules.sys.entity.SysLogDO;
import org.jhonrain.modules.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


/**
 * 系统日志
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-08 10:40:56
 */
@Controller
@RequestMapping("/sys/log")
public class SysLogController {

  @Autowired
  private SysLogService sysLogService;

  /**
   * 列表
   */
  @ResponseBody
  @RequestMapping("/list")
  @RequiresPermissions("sys:log:list")
  public SysResp list(@RequestParam Map<String, Object> params) {
    //查询列表数据
    Query query = new Query(params);
    List<SysLogDO> sysLogList = sysLogService.queryList(query);
    int total = sysLogService.queryTotal(query);

    PageData pageData = new PageData(sysLogList, total, query.getLimit(), query.getPage());
    return SysResp.error().put("page", pageData);
  }

}
