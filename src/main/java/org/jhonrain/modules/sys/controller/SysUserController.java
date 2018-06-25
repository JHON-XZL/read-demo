package org.jhonrain.modules.sys.controller;

import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.jhonrain.common.annotation.SysLog;
import org.jhonrain.common.response.SysResp;
import org.jhonrain.common.utils.Constant;
import org.jhonrain.common.utils.PageData;
import org.jhonrain.common.utils.Query;
import org.jhonrain.common.validator.Assert;
import org.jhonrain.common.validator.ValidatorUtils;
import org.jhonrain.common.validator.group.AddGroup;
import org.jhonrain.common.validator.group.UpdateGroup;
import org.jhonrain.modules.sys.entity.SysUserDO;
import org.jhonrain.modules.sys.service.SysUserRoleService;
import org.jhonrain.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月31日 上午10:40:10
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	
	/**
	 * 所有用户列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:user:list")
	public SysResp list(@RequestParam Map<String, Object> params){
		//只有超级管理员，才能查看所有管理员列表
		if(getUserId() != Constant.SUPER_ADMIN){
			params.put("createUserId", getUserId());
		}
		
		//查询列表数据
		Query query = new Query(params);
		List<SysUserDO> userList = sysUserService.queryList(query);
		int total = sysUserService.queryTotal(query);
		
		PageData pageUtil = new PageData(userList, total, query.getLimit(), query.getPage());
		
		return SysResp.success().put("page", pageUtil);
	}
	
	/**
	 * 获取登录的用户信息
	 */
	@RequestMapping("/info")
	public SysResp info(){
		return SysResp.success().put("user", getUser());
	}
	
	/**
	 * 修改登录用户密码
	 */
	@SysLog("修改密码")
	@RequestMapping("/password")
	public SysResp password(String password, String newPassword){
		Assert.isBlank(newPassword, "新密码不为能空");
		
		//sha256加密
		password = new Sha256Hash(password, getUser().getSalt()).toHex();
		//sha256加密
		newPassword = new Sha256Hash(newPassword, getUser().getSalt()).toHex();
				
		//更新密码
		int count = sysUserService.updatePassword(getUserId(), password, newPassword);
		if(count == 0){
			return SysResp.error("原密码不正确");
		}
		
		return SysResp.success();
	}
	
	/**
	 * 用户信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("sys:user:info")
	public SysResp info(@PathVariable("userId") Long userId){
		SysUserDO user = sysUserService.queryObject(userId);
		
		//获取用户所属的角色列表
		List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
		user.setRoleIdList(roleIdList);
		
		return SysResp.success().put("user", user);
	}
	
	/**
	 * 保存用户
	 */
	@SysLog("保存用户")
	@RequestMapping("/save")
	@RequiresPermissions("sys:user:save")
	public SysResp save(@RequestBody SysUserDO user){
		ValidatorUtils.validateEntity(user, AddGroup.class);
		
		user.setCreateUserId(getUserId());
		sysUserService.save(user);
		
		return SysResp.success();
	}
	
	/**
	 * 修改用户
	 */
	@SysLog("修改用户")
	@RequestMapping("/update")
	@RequiresPermissions("sys:user:update")
	public SysResp update(@RequestBody SysUserDO user){
		ValidatorUtils.validateEntity(user, UpdateGroup.class);
		
		user.setCreateUserId(getUserId());
		sysUserService.update(user);
		
		return SysResp.success();
	}
	
	/**
	 * 删除用户
	 */
	@SysLog("删除用户")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:user:delete")
	public SysResp delete(@RequestBody Long[] userIds){
		if(ArrayUtils.contains(userIds, 1L)){
			return SysResp.error("系统管理员不能删除");
		}
		
		if(ArrayUtils.contains(userIds, getUserId())){
			return SysResp.error("当前用户不能删除");
		}
		
		sysUserService.deleteBatch(userIds);
		
		return SysResp.success();
	}
}
