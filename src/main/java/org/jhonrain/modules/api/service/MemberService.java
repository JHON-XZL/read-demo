package org.jhonrain.modules.api.service;

import org.jhonrain.modules.api.entity.MemberDO;
import org.jhonrain.modules.api.vo.MemberInfoVO;

import java.util.List;

/**
 * <p>功能描述</br></p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 0:08
 */
public interface MemberService {
  /**
   * <pre>通过openId查询用户信息</pre>
   *
   * @param openId openId
   * @return
   */
  List<MemberDO> queryByOpenId(String openId);

  /**
   * <pre>初始化会员信息</pre>
   *
   * @param openId     会员openId
   * @param sessionKey 微信获取的sessionKey
   * @param memberInfo 会员信息
   * @return 会员信息
   */
  MemberDO initMemberInfo(String openId, String sessionKey, MemberInfoVO memberInfo);
}
