package com.demo.coopeuch.configCORS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ConfigCors {
    @Configuration
    public class CorsConfig {

        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**")
                            .allowedOrigins("http://localhost:3000") // Reemplaza con la URL de tu aplicación React
                            .allowedMethods("GET", "POST", "PUT", "DELETE")
                            .allowedHeaders("Content-Type", "Authorization")
                            .allowCredentials(true);
                }
            };
        }
    }
}
