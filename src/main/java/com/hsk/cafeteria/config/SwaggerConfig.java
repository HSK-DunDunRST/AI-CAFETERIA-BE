package com.hsk.cafeteria.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AI CAFETERIA API")
                        .version("1.0.0")
                        .description("인증이 포함되지 않은 API입니다. 임시로 구현을 하였으며 추후에 인증을 추가할 예정입니다."));
    }
}