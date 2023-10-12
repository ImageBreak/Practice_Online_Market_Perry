package net.perry.online_class.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import net.perry.online_class.interceptor.LoginInterceptor;

/**
 * 拦截器配置
 * 
 * 不用权限可以访问url   /api/v1/pub/
 * 要登录可以访问        /api/v1/pri/
 */
public class InterceptorConfig implements WebMvcConfigurer{

    @Bean
    LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        
        //拦截全部，但是指定路径不拦截
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/*/*/**") 
                .excludePathPatterns("/api/v1/pri/user/login","/api/v1/pri/user/register");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
    
    
}
