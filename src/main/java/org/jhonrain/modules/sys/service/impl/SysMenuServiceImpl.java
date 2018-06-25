package org.jhonrain.modules.sys.service.impl;

import org.jhonrain.common.utils.Constant;
import org.jhonrain.modules.sys.dao.SysMenuDao;
import org.jhonrain.modules.sys.entity.SysMenuDO;
import org.jhonrain.modules.sys.service.SysMenuService;
import org.jhonrain.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysUserService sysUserService;
	
	@Override
	public List<SysMenuDO> queryListParentId(Long parentId, List<Long> menuIdList) {
		List<SysMenuDO> menuList = queryListParentId(parentId);
		if(menuIdList == null){
			return menuList;
		}
		
		List<SysMenuDO> userMenuList = new ArrayList<>();
		for(SysMenuDO menu : menuList){
			if(menuIdList.contains(menu.getMenuId())){
				userMenuList.add(menu);
			}
		}
		return userMenuList;
	}

	@Override
	public List<SysMenuDO> queryListParentId(Long parentId) {
		return sysMenuDao.queryListParentId(parentId);
	}

	@Override
	public List<SysMenuDO> queryNotButtonList() {
		return sysMenuDao.queryNotButtonList();
	}

	@Override
	public List<SysMenuDO> getUserMenuList(Long userId) {
		//系统管理员，拥有最高权限
		if(userId == 1){
			return getAllMenuList(null);
		}
		
		//用户菜单列表
		List<Long> menuIdList = sysUserService.queryAllMenuId(userId);
		return getAllMenuList(menuIdList);
	}
	
	@Override
	public SysMenuDO queryObject(Long menuId) {
		return sysMenuDao.queryObject(menuId);
	}

	@Override
	public List<SysMenuDO> queryList(Map<String, Object> map) {
		return sysMenuDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysMenuDao.queryTotal(map);
	}

	@Override
	public void save(SysMenuDO menu) {
		sysMenuDao.save(menu);
	}

	@Override
	public void update(SysMenuDO menu) {
		sysMenuDao.update(menu);
	}

	@Override
	@Transactional
	public void deleteBatch(Long[] menuIds) {
		sysMenuDao.deleteBatch(menuIds);
	}
	
	@Override
	public List<SysMenuDO> queryUserList(Long userId) {
		return sysMenuDao.queryUserList(userId);
	}

	/**
	 * 获取所有菜单列表
	 */
	private List<SysMenuDO> getAllMenuList(List<Long> menuIdList){
		//查询根菜单列表
		List<SysMenuDO> menuList = queryListParentId(0L, menuIdList);
		//递归获取子菜单
		getMenuTreeList(menuList, menuIdList);
		
		return menuList;
	}

	/**
	 * 递归
	 */
	private List<SysMenuDO> getMenuTreeList(List<SysMenuDO> menuList, List<Long> menuIdList){
		List<SysMenuDO> subMenuList = new ArrayList<SysMenuDO>();
		
		for(SysMenuDO entity : menuList){
			//目录
			if(entity.getType() == Constant.MenuType.CATALOG.getValue()){
				entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
			}
			subMenuList.add(entity);
		}
		
		return subMenuList;
	}
}
