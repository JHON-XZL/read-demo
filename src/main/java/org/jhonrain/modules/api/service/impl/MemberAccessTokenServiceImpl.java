package org.jhonrain.modules.api.service.impl;

import org.jhonrain.modules.api.dao.MemberAccessTokenDao;
import org.jhonrain.modules.api.entity.MemberAccessTokenDO;
import org.jhonrain.modules.api.service.MemberAccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <p>功能描述</br></p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 13:03
 */
@Service
public class MemberAccessTokenServiceImpl implements MemberAccessTokenService {

  @Autowired
  MemberAccessTokenDao memberAccessTokenDao;

  @Override
  public String generateAccessToken(String openId,String sessionKey) {
    /** 重新生成的第三方的session **/
    String newAccessToken = UUID.randomUUID().toString();

    return newAccessToken;
  }

  @Override
  public MemberAccessTokenDO queryRecordByToken(String accessToken) {
    return memberAccessTokenDao.queryRecordByToken(accessToken);
  }
}
