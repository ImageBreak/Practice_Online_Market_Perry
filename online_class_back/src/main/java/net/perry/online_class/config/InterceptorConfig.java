package net.perry.online_class.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import net.perry.online_class.interceptor.CorsInterceptor;
import net.perry.online_class.interceptor.LoginInterceptor;

/**
 * 拦截器配置
 * 
 * 不用权限可以访问url   /api/v1/pub/
 * 要登录可以访问        /api/v1/pri/
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private CorsInterceptor corsInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        
        //拦截全部路径，跨域的需要放在最上面
        registry.addInterceptor(corsInterceptor).addPathPatterns("/**");

        //拦截全部，但是指定路径不拦截
        registry.addInterceptor(loginInterceptor).addPathPatterns("/api/v1/pri/*/**") 
                .excludePathPatterns("/api/v1/pri/user/login","/api/v1/pri/user/register");
        
        WebMvcConfigurer.super.addInterceptors(registry);
    }
    
    
}
