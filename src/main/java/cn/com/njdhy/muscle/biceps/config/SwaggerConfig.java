package cn.com.njdhy.muscle.biceps.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jason.hu
 * @date 2018-07-13
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig{
    @Bean
    public Docket createRestApi() {
        List apiKeys = new ArrayList<ApiKey>();
        apiKeys.add(apiKey());

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.com.njdhy.muscle.biceps.api"))
                .paths(springfox.documentation.builders.PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(apiKeys);
    }

    private ApiKey apiKey() {
        return new ApiKey("x-auth-token", "token", "header");
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "奥米巴项目REST API",
                "奥米巴项目接口文档",
                "v1.0",
                "",
                new Contact("Mr.zhu", "www.taobao.com", "njzhuyuyp@163.com"),
                "",
                ""
        );
        return apiInfo;

    }


}
