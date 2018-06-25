package org.jhonrain.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.jhonrain.modules.sys.entity.SysUserTokenDO;

/**
 * <p>功能描述</br>系统用户Token</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
@Mapper
public interface SysUserTokenDao extends BaseDao<SysUserTokenDO> {

  SysUserTokenDO queryByUserId(Long userId);

  SysUserTokenDO queryByToken(String token);

}
