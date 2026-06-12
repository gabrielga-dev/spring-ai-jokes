package br.com.gabrielga_dev.spring_ai_jokes.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring AI Jokes API")
                        .description("API for generating jokes using AI (Gemini)")
                        .version("1.0.0")
                );
    }
}
