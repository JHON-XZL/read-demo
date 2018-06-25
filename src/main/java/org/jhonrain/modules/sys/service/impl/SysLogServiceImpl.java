package org.jhonrain.modules.sys.service.impl;

import org.jhonrain.modules.sys.dao.SysLogDao;
import org.jhonrain.modules.sys.entity.SysLogDO;
import org.jhonrain.modules.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
  @Autowired
  private SysLogDao sysLogDao;

  @Override
  public SysLogDO queryObject(Long id) {
    return sysLogDao.queryObject(id);
  }

  @Override
  public List<SysLogDO> queryList(Map<String, Object> map) {
    return sysLogDao.queryList(map);
  }

  @Override
  public int queryTotal(Map<String, Object> map) {
    return sysLogDao.queryTotal(map);
  }

  @Override
  public void save(SysLogDO sysLog) {
    sysLogDao.save(sysLog);
  }

  @Override
  public void update(SysLogDO sysLog) {
    sysLogDao.update(sysLog);
  }

  @Override
  public void delete(Long id) {
    sysLogDao.delete(id);
  }

  @Override
  public void deleteBatch(Long[] ids) {
    sysLogDao.deleteBatch(ids);
  }

}
