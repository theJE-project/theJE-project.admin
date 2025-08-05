package com.threeteam.sns.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // === 여기 경로만 실제 업로드 위치에 맞게 변경하면 끝! ===
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploads/");
    }
}
