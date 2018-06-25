package org.jhonrain.modules.api.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.jhonrain.modules.api.entity.MemberAccessTokenDO;

/**
 * <p>功能描述</br></p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 12:57
 */
@Mapper
public interface MemberAccessTokenDao {
  /**
   * <pre>更新记录</pre>
   *
   * @param accessTokenDO
   * @return
   */
  int update(MemberAccessTokenDO accessTokenDO);

  /**
   * <pre>插入记录</pre>
   *
   * @param accessTokenDO
   * @return
   */
  int insert(MemberAccessTokenDO accessTokenDO);

  /**
   * <pre>通过openId查询对应的记录</pre>
   *
   * @param openId 微信openId
   * @return
   */
  MemberAccessTokenDO queryByOpenId(@Param(value = "openId") String openId);

  /**
   * <pre>通过accessToken查询对应的记录</pre>
   *
   * @param accessToken 用户的Token
   * @return
   */
  MemberAccessTokenDO queryRecordByToken(@Param("accessToken") String accessToken);
}
