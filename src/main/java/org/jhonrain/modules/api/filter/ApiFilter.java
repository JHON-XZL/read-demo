package org.jhonrain.modules.api.filter;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpStatus;
import org.jhonrain.common.response.RainbowResp;
import org.jhonrain.common.utils.SpringContextUtils;
import org.jhonrain.modules.api.entity.MemberAccessTokenDO;
import org.jhonrain.modules.api.service.MemberAccessTokenService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>功能描述</br></p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/22 15:28
 */
public class ApiFilter implements Filter {

  private final static String AUTH_URI = "v1/api/member/code";

  @Override
  public void init(FilterConfig config) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
          throws IOException, ServletException {
    HttpServletRequest tmpRequest = (HttpServletRequest) request;
    String requestUri = tmpRequest.getRequestURI();
    String accessToken = tmpRequest.getHeader("accessToken");
    if (!AUTH_URI.equals(requestUri)) {
      if (accessToken == null || "".equals(accessToken)) {
        unauthorizedResp(response, "unauthorized request");
        return;
      } else {
        MemberAccessTokenDO accessTokenDO = SpringContextUtils.getComponent(MemberAccessTokenService.class).queryRecordByToken(accessToken);
        if (accessTokenDO == null || accessTokenDO.getExpireDate() == null) {
          unauthorizedResp(response, "unauthorized request");
          return;
        } else {
          Long expireTime = accessTokenDO.getExpireDate().getTime();
          if (System.currentTimeMillis() - expireTime > 0) {
            unauthorizedResp(response, "AccessToken Is Expired!");
            return;
          } else {
            chain.doFilter(tmpRequest, response);
          }
        }
      }
    } else {
      chain.doFilter(tmpRequest, response);
    }
  }

  /**
   * <pre>未授权的返回值</pre>
   *
   * @param response 响应对象
   * @param msg      携带消息
   * @throws IOException
   */
  private void unauthorizedResp(ServletResponse response, String msg) throws IOException {
    PrintWriter out = response.getWriter();
    out.print(JSON.toJSONString(RainbowResp.error(HttpStatus.SC_UNAUTHORIZED, msg)));
    out.flush();
    out.close();
  }

  @Override
  public void destroy() {
  }
}
