package org.jhonrain.modules.api.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.jhonrain.modules.api.entity.MemberDO;

import java.util.List;

/**
 * <p>功能描述</br>会员的数据接入层</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/21 21:26
 */
@Mapper
public interface MemberDao {
  /**
   * <pre>更新记录</pre>
   *
   * @param memberDO 会员信息实体
   * @return
   */
  int update(MemberDO memberDO);

  /**
   * <pre>创建记录</pre>
   *
   * @param memberDO 会员信息实体
   * @return
   */
  int insert(MemberDO memberDO);

  /**
   * <pre>通过openId查询</pre>
   *
   * @param openId openID
   * @return
   */
  List<MemberDO> queryByOpenId(@Param(value = "openId") String openId);
}
