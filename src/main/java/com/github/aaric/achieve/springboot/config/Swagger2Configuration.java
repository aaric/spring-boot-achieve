package com.github.aaric.achieve.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
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
 * Swagger2 API配置
 *
 * @author Aaric, created on 2018-10-09T10:09.
 * @since 0.2.0-SNAPSHOT
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    /**
     * 设置Swagger2 API信息
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .globalOperationParameters(operationParameters())
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.aaric.achieve"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 全局参数配置
     *
     * @return
     */
    private List<Parameter> operationParameters() {
        // 支持标准国际化
        ParameterBuilder builder = new ParameterBuilder();
        builder.name(LocaleChangeInterceptor.DEFAULT_PARAM_NAME).description("国际化参数，默认zh_CN(简体中文), en_US(英文)")
                .modelRef(new ModelRef("String"))
                .parameterType("query")
                .required(false);

        // 构建全局参数列表
        List<Parameter> list = new ArrayList<>();
        list.add(builder.build());
        return list;
    }

    /**
     * 声明API文档基本信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger2 API")
                .description("Test Swagger2 API")
                .termsOfServiceUrl("https://github.com/aaric/spring-boot-achieve")
                /*.contact(new Contact("Aaric", "", ""))*/
                .version("0.2.0-SNAPSHOT")
                .build();
    }
}
