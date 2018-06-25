package org.jhonrain.modules.sys.service;

import org.jhonrain.common.response.SysResp;
import org.jhonrain.modules.sys.entity.SysUserTokenDO;

/**
 * 用户Token
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:07
 */
public interface SysUserTokenService {

  SysUserTokenDO queryByUserId(Long userId);

  SysUserTokenDO queryByToken(String token);

  void save(SysUserTokenDO token);

  void update(SysUserTokenDO token);

  /**
   * 生成token
   *
   * @param userId 用户ID
   */
  SysResp createToken(long userId);

}
