package org.jhonrain.modules.api.web.error;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.jhonrain.common.response.RainbowResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * <p>功能描述</br>（全局配置）异常处理控制器</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/5/30 14:02
 */
@Controller
@Slf4j
@Api(value = "统一错误处理", description = "错误处理接口", tags = {"系统错误处理操作V1.0"})
public class AppErrorController implements ErrorController {
  /**
   * 错误路径
   */
  private static final String ERROR_PATH = "/error";

  private ErrorAttributes errorAttributes;

  @Override
  public String getErrorPath() {
    return ERROR_PATH;
  }

  @Autowired
  public AppErrorController(ErrorAttributes errorAttributes) {
    this.errorAttributes = errorAttributes;
  }

  /**
   * <pre>Web页面错误处理</pre>
   *
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = ERROR_PATH, produces = "text/html")
  public String errorPageHandler(HttpServletRequest request, HttpServletResponse response) {
    int status = response.getStatus();
    switch (status) {
      case 403:
        return "403";
      case 404:
        return "404";
      case 500:
        return "500";
      default:
        return "index";
    }
  }

  /**
   * <pre>错误的Api处理（返回结果）除Web页面外的错误处理，比如Json/XML等</pre>
   *
   * @param request 请求对象
   * @return
   */
  @RequestMapping(value = ERROR_PATH)
  @ResponseBody
  public RainbowResp errorApiHandler(HttpServletRequest request) {
    RequestAttributes requestAttributes = new ServletRequestAttributes(request);
    Map<String, Object> attr = this.errorAttributes.getErrorAttributes(requestAttributes, false);
    int status = getStatus(request);
    log.error(String.valueOf(attr.getOrDefault("message", "error")));
    return RainbowResp.error(status, "系统繁忙，请稍后再试！");
  }

  /**
   * <pre>获取状态</pre>
   *
   * @param request 请求对象
   * @return
   */
  private int getStatus(HttpServletRequest request) {
    Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
    if (status != null) {
      return status;
    }
    return 500;
  }
}
