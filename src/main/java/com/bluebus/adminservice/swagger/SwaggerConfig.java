package com.bluebus.adminservice.swagger;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI apiInfo() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("BlueBus Admin Rest Api")
                                .description("Rest Api for BlueBus Admin Service")
                                .version("1.0"));
    }
}
