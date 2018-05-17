package com.github.aaric.achieve.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Redis配置
 *
 * @author Aaric, created on 2017-10-30T11:26.
 * @since 1.0-SNAPSHOT
 */
@Configuration
public class RedisConfiguration {

    @Autowired
    private StringRedisTemplate template;

    @Bean
    public RedisTemplate<String, String> redisTemplate() {
        return template;
    }
}
