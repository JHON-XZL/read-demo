package org.jhonrain.modules.api.service;

import org.jhonrain.modules.api.entity.MemberAccessTokenDO;

/**
 * <p>功能描述</br></p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 12:59
 */
public interface MemberAccessTokenService {
  /**
   * <Pre>生成第三方的token</Pre>
   *
   * @param openId 用户openId
   * @return
   */
  String generateAccessToken(String openId, String sessionKey);

  /**
   * <pre>查询token</pre>
   *
   * @param accessToken token
   * @return accessToken记录
   */
  MemberAccessTokenDO queryRecordByToken(String accessToken);
}
