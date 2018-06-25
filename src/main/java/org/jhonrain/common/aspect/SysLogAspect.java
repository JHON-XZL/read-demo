package org.jhonrain.common.aspect;

import com.google.gson.Gson;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.jhonrain.common.annotation.SysLog;
import org.jhonrain.common.utils.HttpContextUtils;
import org.jhonrain.common.utils.IPUtils;
import org.jhonrain.modules.sys.entity.SysLogDO;
import org.jhonrain.modules.sys.entity.SysUserDO;
import org.jhonrain.modules.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * <p>功能描述</br>日志切面</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/20 13:52
 */
@Aspect
@Component
public class SysLogAspect {

  @Autowired
  private SysLogService sysLogService;

  @Pointcut("@annotation(org.jhonrain.common.annotation.SysLog)")
  public void logPointCut() {

  }

  @Before("logPointCut()")
  public void saveSysLog(JoinPoint joinPoint) {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    Method method = signature.getMethod();

    SysLogDO sysLog = new SysLogDO();
    SysLog syslog = method.getAnnotation(SysLog.class);
    if (syslog != null) {
      //注解上的描述
      sysLog.setOperation(syslog.value());
    }

    //请求的方法名
    String className = joinPoint.getTarget().getClass().getName();
    String methodName = signature.getName();
    sysLog.setMethod(className + "." + methodName + "()");

    //请求的参数
    Object[] args = joinPoint.getArgs();
    String params = new Gson().toJson(args[0]);
    sysLog.setParams(params);

    //获取request
    HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
    //设置IP地址
    sysLog.setIp(IPUtils.getIpAddr(request));

    //用户名
    String username = ((SysUserDO) SecurityUtils.getSubject().getPrincipal()).getUsername();
    sysLog.setUsername(username);

    sysLog.setCreateDate(new Date());
    //保存系统日志
    sysLogService.save(sysLog);
  }

}

