package org.jhonrain.modules.sys.service.impl;

import org.apache.commons.lang.StringUtils;
import org.jhonrain.common.utils.Constant;
import org.jhonrain.modules.sys.dao.SysMenuDao;
import org.jhonrain.modules.sys.dao.SysUserDao;
import org.jhonrain.modules.sys.dao.SysUserTokenDao;
import org.jhonrain.modules.sys.entity.SysMenuDO;
import org.jhonrain.modules.sys.entity.SysUserDO;
import org.jhonrain.modules.sys.entity.SysUserTokenDO;
import org.jhonrain.modules.sys.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShiroServiceImpl implements ShiroService {

  @Autowired
  private SysMenuDao sysMenuDao;

  @Autowired
  private SysUserDao sysUserDao;

  @Autowired
  private SysUserTokenDao sysUserTokenDao;

  @Override
  public Set<String> getUserPermissions(long userId) {
    List<String> permsList;

    //系统管理员，拥有最高权限
    if (userId == Constant.SUPER_ADMIN) {
      List<SysMenuDO> menuList = sysMenuDao.queryList(new HashMap<>());
      permsList = new ArrayList<>(menuList.size());
      for (SysMenuDO menu : menuList) {
        permsList.add(menu.getPerms());
      }
    } else {
      permsList = sysUserDao.queryAllPerms(userId);
    }
    //用户权限列表
    Set<String> permsSet = new HashSet<>();
    for (String perms : permsList) {
      if (StringUtils.isBlank(perms)) {
        continue;
      }
      permsSet.addAll(Arrays.asList(perms.trim().split(",")));
    }
    return permsSet;
  }

  @Override
  public SysUserTokenDO queryByToken(String token) {
    return sysUserTokenDao.queryByToken(token);
  }

  @Override
  public SysUserDO queryUser(Long userId) {
    return sysUserDao.queryObject(userId);
  }
}
