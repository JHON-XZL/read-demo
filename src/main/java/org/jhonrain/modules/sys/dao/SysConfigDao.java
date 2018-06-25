package org.jhonrain.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.jhonrain.modules.sys.entity.SysConfigDO;

/**
 * <p>功能描述</br>系统配置信息</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
@Mapper
public interface SysConfigDao extends BaseDao<SysConfigDO> {

  /**
   * 根据key，查询value
   */
  String queryByKey(String paramKey);

  /**
   * 根据key，更新value
   */
  int updateValueByKey(@Param("key") String key, @Param("value") String value);

}
