package com.ysmdz.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringdocConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(
                new Info()
                        .contact(new Contact().name("用什么点缀").email("763830735@qq.com"))
                        .title("学成在线接口")
                        .description("学成在线接口")
                        .version("1.0")
        );
    }
}
