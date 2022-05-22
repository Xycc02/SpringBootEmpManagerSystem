package com.xuyuchao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-18-20:55
 * @Description:    自定义国际化接口,要有仿照源码写东西的能力,实现LocaleResolver
 */
public class MyLocaleResolver implements LocaleResolver {
    /**
     * 解析请求
     * @param request
     * @return
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求参数的编码
        String language = request.getParameter("l");
        // System.out.println("debug==>"+language);
        //如果没有就使用这个默认的
        Locale locale = Locale.getDefault();
        //如果请求链接携带了国际化参数
        if(!StringUtils.isEmpty(language)) {
            //可分可不分割  看源码
            // String[] s = language.split("_");
            locale = new Locale(language);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
