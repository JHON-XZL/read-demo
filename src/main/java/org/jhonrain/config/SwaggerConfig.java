package org.jhonrain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>功能描述</br>接口文档的配置</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 11:47
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket createRestApi() {
    ParameterBuilder tokenParam = new ParameterBuilder();
    List<Parameter> params = new ArrayList<>();
    tokenParam.name("accessToken").description("访问令牌")
            .modelRef(new ModelRef("string")).parameterType("header").required(false).build();
    params.add(tokenParam.build());
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("org.jhonrain.modules.api.web"))
            .paths(PathSelectors.any())
            .build()
            .globalOperationParameters(params);
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("xxxx接口文档")
            .description("xxxx接口文档restful风格")
            .version("1.0")
            .build();
  }
}
