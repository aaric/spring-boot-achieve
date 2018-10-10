package com.github.aaric.achieve.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * SpringMVC本地化配置
 *
 * @author Aaric, created on 2018-10-10T21:56.
 * @since 0.3.1-SNAPSHOT
 */
@Configuration
public class LocaleConfiguration extends WebMvcConfigurerAdapter {

    /**
     * 声明本地化处理器
     *
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        // 使用回话本地化策略
        //CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();

        // 设置简体中文为默认语言
        localeResolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return localeResolver;
    }

    /**
     * 声明本地化拦截器
     *
     * @return
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        return new LocaleChangeInterceptor();
    }

    /**
     * 启用本地化拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
