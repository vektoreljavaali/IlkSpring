package com.vektorel.IlkSpring.config.swagger;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.not;
import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.any;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger ile alakalı ayarların yapılabilmesi ve
 * spring tarafınfan işlenenilmesi için ekliyorz
 * ayrıca @Configuration annotasyonu spring için
 * ayar sınıfı atamsı yapar.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String EXCLUDED_PATHS = "(/info|/health|/health/.*|/metrics|/error|/env|/env/.*)";

    @Bean
    public Docket api() {
        return new Docket(SWAGGER_2)
                .select()
                .apis(any())
                .paths(not(regex(EXCLUDED_PATHS)))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spring Boot Swagger Examaple")
                .description("Muhammet Ali KAYA Dokümanyasyonu")  // no turkish please
                .contact(new Contact("Muhammet Ali KAYA", "", ""))
                .license("Apache 2.0")
                .licenseUrl("")
                .version("V.1.0.5")
                .termsOfServiceUrl("")
                .build();
    }
}
