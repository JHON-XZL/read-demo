package org.jhonrain.modules.sys.service.impl;

import org.jhonrain.common.response.SysResp;
import org.jhonrain.modules.sys.dao.SysUserTokenDao;
import org.jhonrain.modules.sys.entity.SysUserTokenDO;
import org.jhonrain.modules.sys.oauth2.TokenGenerator;
import org.jhonrain.modules.sys.service.SysUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service("sysUserTokenService")
public class SysUserTokenServiceImpl implements SysUserTokenService {

  @Autowired
  private SysUserTokenDao sysUserTokenDao;

  //12小时后过期
  private final static int EXPIRE = 3600 * 12;

  @Override
  public SysUserTokenDO queryByUserId(Long userId) {
    return sysUserTokenDao.queryByUserId(userId);
  }

  @Override
  public SysUserTokenDO queryByToken(String token) {
    return sysUserTokenDao.queryByToken(token);
  }

  @Override
  public void save(SysUserTokenDO token) {
    sysUserTokenDao.save(token);
  }

  @Override
  public void update(SysUserTokenDO token) {
    sysUserTokenDao.update(token);
  }

  @Override
  public SysResp createToken(long userId) {
    //生成一个token
    String token = TokenGenerator.generateValue();

    //当前时间
    Date now = new Date();
    //过期时间
    Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

    //判断是否生成过token
    SysUserTokenDO tokenEntity = queryByUserId(userId);
    if (tokenEntity == null) {
      tokenEntity = new SysUserTokenDO();
      tokenEntity.setUserId(userId);
      tokenEntity.setToken(token);
      tokenEntity.setUpdateTime(now);
      tokenEntity.setExpireTime(expireTime);

      //保存token
      save(tokenEntity);
    } else {
      tokenEntity.setToken(token);
      tokenEntity.setUpdateTime(now);
      tokenEntity.setExpireTime(expireTime);

      //更新token
      update(tokenEntity);
    }

    return SysResp.success().put("token", token).put("expire", EXPIRE);
  }
}
