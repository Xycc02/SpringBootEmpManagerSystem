package com.xuyuchao.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-18-20:19
 * @Description:    自定义扩展mvc配置类,实现WebMvcConfigurer接口
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    /**
     * 实现视图跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");

        registry.addViewController("/main.html").setViewName("dashboard");
    }

    /**
     * 注册自定义国际化类,将该自定义组件交给spring容器管理
     * 注意:底层是按名称进行匹配,该方法的名称一定要为localeResolver
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    /**
     * 添加拦截器
     * @return
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有路径
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index","/index.html","/user/login","/","/css/*","/js/*","/img/*");
    }


    // @Bean
    // @ConditionalOnMissingBean(HiddenHttpMethodFilter.class)
    // @ConditionalOnProperty(prefix = "spring.mvc.hiddenmethod.filter", name = "enabled", matchIfMissing = false)
    // public OrderedHiddenHttpMethodFilter hiddenHttpMethodFilter() {
    //     return new OrderedHiddenHttpMethodFilter();
    // }

}
