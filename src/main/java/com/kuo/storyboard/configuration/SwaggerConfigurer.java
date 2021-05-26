package com.kuo.storyboard.configuration;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @author Channing Kuo
 * @date 2020/12/25
 */
@Configuration
@EnableSwagger2
@Profile({"dev"})
public class SwaggerConfigurer {

    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> parameters = Lists.newArrayList();
        tokenPar.name("Authorization")
                .description("AccessToken令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        parameters.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.kuo.storyboard.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("StoryBoard Api Docs")
                .description("Restful Api")
                .version("0.0.1")
                .build();
    }
}
