package com.leosanqing.demo.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {
 

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("2.X版本")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.leosanqing.demo.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }



    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("knife4j-demo接口API") // 标题
                .contact(new Contact("leosanqing",
                        "https://github.com/leosanqing/Java-Notes",
                        "stormleo@qq.com")) // 联系人
                .version("1.0.1")
                .termsOfServiceUrl("https://github.com/leosanqing/Java-Notes") // 网站地址
                .description("knife4j-demo API")  // 描述
                .build();


    }
}