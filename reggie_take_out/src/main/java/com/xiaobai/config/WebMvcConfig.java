package com.xiaobai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author 终于白发始于青丝
 * @create 2022-04-28 9:29
 * @Version 1.0
 * @ClassName WebMvcConfig
 * @Description 类方法说明：web配置
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
        /**
        * @author 终于白发始于青丝
        * @Classname WebMvcConfig
        * @Description 类方法说明：设置静态资源
        * @Date 2022-04-28 9:33
        */
        @Override
        protected void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/backend/**")
                        .addResourceLocations("classpath:/backend/");
                registry.addResourceHandler("/front/**")
                        .addResourceLocations("classpath:/front/");
        }
}
