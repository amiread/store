package com.example.demo.config;

import com.example.demo.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @create 2022-12-05 16:41
 */
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 创建拦截器对象
        HandlerInterceptor interceptor = new LoginInterceptor();
// 白名单
        List<String> patterns = new ArrayList<String>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/index.html");
        patterns.add("/web/product.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");
        patterns.add("/districts/**");
        patterns.add("/products/**");
        patterns.add("/web/index.html");
        patterns.add("/products/**");
        // 通过注册工具添加拦截器
        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns
                (patterns);
    }

    }
