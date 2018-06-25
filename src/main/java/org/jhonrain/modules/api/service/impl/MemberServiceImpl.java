package org.jhonrain.modules.api.service.impl;

import org.jhonrain.modules.api.dao.MemberAccessTokenDao;
import org.jhonrain.modules.api.dao.MemberDao;
import org.jhonrain.modules.api.entity.MemberAccessTokenDO;
import org.jhonrain.modules.api.entity.MemberDO;
import org.jhonrain.modules.api.enums.MemberStatusEnum;
import org.jhonrain.modules.api.service.MemberService;
import org.jhonrain.modules.api.vo.MemberInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>功能描述</br>会员的业务逻辑操作</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 13:00
 */
@Service
public class MemberServiceImpl implements MemberService {

  @Autowired
  private MemberDao memberDao;

  @Autowired
  private MemberAccessTokenDao memberAccessTokenDao;

  @Override
  public List<MemberDO> queryByOpenId(String openId) {
    return memberDao.queryByOpenId(openId);
  }

  @Override
  @Transactional
  public MemberDO initMemberInfo(String openId, String sessionKey, MemberInfoVO memberInfo) {
    Date tmpDate = new Date();
    /** 过期时间:2小时 **/
    Date expireDate = new Date(tmpDate.getTime() + 7200000L);
    /** 会员的初始化 **/
    List<MemberDO> memberDOList = this.queryByOpenId(openId);
    MemberDO memberDO = new MemberDO();
    if (memberDOList == null && memberDOList.size() > 0) {
      memberDO = memberDOList.get(0);
      memberDO.setUpdateDate(tmpDate);
      memberDao.update(memberDO);
    } else {
      BeanUtils.copyProperties(memberInfo, memberDO);
      memberDO.setOpenId(openId);
      memberDO.setMemberCardNum("SZ-" + UUID.randomUUID());
      memberDO.setStatus(MemberStatusEnum.ACTIVE.getValue());
      memberDO.setCreateDate(tmpDate);
      memberDO.setUpdateDate(tmpDate);
      memberDao.insert(memberDO);
    }

    /** =============================后期如果优化的话，需要换成redis=========================== **/
    /** 重新生成的第三方的session **/
    String newAccessToken = UUID.randomUUID().toString();

    /** 查询记录 **/
    MemberAccessTokenDO accessTokenDO = memberAccessTokenDao.queryByOpenId(openId);
    if (accessTokenDO != null) {
      accessTokenDO.setAccessToken(newAccessToken);
      accessTokenDO.setSessionKey(sessionKey);
      accessTokenDO.setUpdateDate(tmpDate);
      memberAccessTokenDao.update(accessTokenDO);
    } else {
      accessTokenDO = new MemberAccessTokenDO();
      accessTokenDO.setOpenId(openId);
      accessTokenDO.setAccessToken(newAccessToken);
      accessTokenDO.setSessionKey(sessionKey);
      accessTokenDO.setCreateDate(tmpDate);
      accessTokenDO.setUpdateDate(tmpDate);
      accessTokenDO.setExpireDate(expireDate);
      memberAccessTokenDao.insert(accessTokenDO);
    }
    memberDO.setAccessToken(newAccessToken);
    memberDO.setExpireTime(expireDate);
    return memberDO;
  }
}
