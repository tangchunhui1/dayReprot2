package com.yunwei.dayReport.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Administrator
 */
@Configuration
public class LoginConfiguration
        implements WebMvcConfigurer {

    public LoginConfiguration() {
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] addPathPatterns = {
                "/**"
        };
        String[] excludePathPatterns = {
                "/", "/login", "/loginout", "/css/*.css", "/fonts/*.TTF", "/fonts/*.otf", "/fonts/*.eot", "/fonts/*.svg", "/fonts/*.woff", "/fonts/*.woff2",
                "/fonts/*.ttf", "/images/*.png", "/images/*.jpg", "/images/*.gif", "/js/*.js", "/libs/*.js"
        };
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns).order(0);
    }
}

