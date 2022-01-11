package com.example.config;

import com.example.clients.fallback.UserClientFallbackFactory;
import feign.Logger;
import org.springframework.context.annotation.Bean;

public class DefaultFeignConfiguration {

    @Bean
    public Logger.Level setLogLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    public UserClientFallbackFactory getUserClientFallbackFactory() {
        return new UserClientFallbackFactory();
    }
}
