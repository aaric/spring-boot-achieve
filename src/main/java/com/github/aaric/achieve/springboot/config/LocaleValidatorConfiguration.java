package com.github.aaric.achieve.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * SpringMVC数据校验本地化配置
 *
 * @author Aaric, created on 2018-10-10T22:32.
 * @since 0.3.1-SNAPSHOT
 */
@Configuration
public class LocaleValidatorConfiguration {

    @Autowired
    private MessageSource messageSource;

    /**
     * 声明数据校验本地化处理器
     *
     * @return
     */
    @Bean
    public LocalValidatorFactoryBean localValidatorFactory() {
        LocalValidatorFactoryBean localValidatorFactory = new LocalValidatorFactoryBean();
        localValidatorFactory.setValidationMessageSource(messageSource);
        return localValidatorFactory;
    }
}
