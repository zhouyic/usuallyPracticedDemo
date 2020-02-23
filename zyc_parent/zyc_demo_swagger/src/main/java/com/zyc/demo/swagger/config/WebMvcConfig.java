package com.zyc.demo.swagger.config;

import com.zyc.demo.swagger.filter.AuthorityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/2/3 20:41
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    AuthorityInterceptor authorityInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorityInterceptor)
        .addPathPatterns("/**");
    }
}
