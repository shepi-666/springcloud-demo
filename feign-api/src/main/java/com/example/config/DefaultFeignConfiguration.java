package com.example.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class DefaultFeignConfiguration {

    @Bean
    public Logger.Level setLogLevel() {
        return Logger.Level.BASIC;
    }
}
