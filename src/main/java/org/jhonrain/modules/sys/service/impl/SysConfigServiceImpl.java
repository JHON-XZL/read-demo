package org.jhonrain.modules.sys.service.impl;

import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.jhonrain.common.exception.RainbowException;
import org.jhonrain.modules.sys.dao.SysConfigDao;
import org.jhonrain.modules.sys.entity.SysConfigDO;
import org.jhonrain.modules.sys.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService {
  @Autowired
  private SysConfigDao sysConfigDao;

  @Override
  @Transactional
  public void save(SysConfigDO config) {
    sysConfigDao.save(config);
  }

  @Override
  public void update(SysConfigDO config) {
    sysConfigDao.update(config);
  }

  @Override
  public void updateValueByKey(String key, String value) {
    sysConfigDao.updateValueByKey(key, value);
  }

  @Override
  public void deleteBatch(Long[] ids) {
    sysConfigDao.deleteBatch(ids);
  }

  @Override
  public List<SysConfigDO> queryList(Map<String, Object> map) {
    return sysConfigDao.queryList(map);
  }

  @Override
  public int queryTotal(Map<String, Object> map) {
    return sysConfigDao.queryTotal(map);
  }

  @Override
  public SysConfigDO queryObject(Long id) {
    return sysConfigDao.queryObject(id);
  }

  @Override
  public String getValue(String key, String defaultValue) {
    String value = sysConfigDao.queryByKey(key);
    if (StringUtils.isBlank(value)) {
      return defaultValue;
    }
    return value;
  }

  @Override
  public <T> T getConfigObject(String key, Class<T> clazz) {
    String value = getValue(key, null);
    if (StringUtils.isNotBlank(value)) {
      return new Gson().fromJson(value, clazz);
    }

    try {
      return clazz.newInstance();
    } catch (Exception e) {
      throw new RainbowException("获取参数失败");
    }
  }
}
