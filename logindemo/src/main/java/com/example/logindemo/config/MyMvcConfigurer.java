/**
 * @projectName logindemo
 * @package com.example.logindemo.config
 * @className com.example.logindemo.config.WebMvcConfigurer
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.example.logindemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfigurer
 * @description 将登录拦截器配置到容器中.除了首页，其他操作都拦截下来，所以，需要在MyMvcConfig中添加一个拦截器，让上边的配置都有作用
 * @author lichengyong
 * @date 2020/12/25 15:07
 * @version 1.0
 */
@Configuration
public class MyMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("login");
    }

    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截的请求，并排除几个不拦截的请求
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")  // 所有路径都被拦截
                .excludePathPatterns("/login")
                .excludePathPatterns("/index.html")
                .excludePathPatterns("/mdzz/login")
                .excludePathPatterns("/mdzz/logout")
                .excludePathPatterns("/mdzz")
                .excludePathPatterns("/assets/**");

    }
}