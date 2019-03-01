package com.yy.base.config.swagger;

import com.yy.base.config.base.ObtainAppliationPropertis;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfig extends ObtainAppliationPropertis {


    @Bean
    public Docket docket() {

        String title=getStringOrDefault(Swagger2PropertiesKeyConstant.KEY_SWAGGER_TITLE,"电商商城");
        String version=getStringOrDefault(Swagger2PropertiesKeyConstant.KEY_SWAGGER_VERSION,"1.0");
        String basePackage=getStringOrDefault(Swagger2PropertiesKeyConstant.KEY_SWAGGER_BASEPACKAGE,"com.hailong.controller");
        String description=getStringOrDefault(Swagger2PropertiesKeyConstant.KEY_SWAGGER_DESCIPTION,"Swagger2的相关的接口文档");



        ApiInfoBuilder builder = new ApiInfoBuilder()
                .title(title)
                .version(version)
                .description(description);
        ApiInfo apiInfo = builder.build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }



}
