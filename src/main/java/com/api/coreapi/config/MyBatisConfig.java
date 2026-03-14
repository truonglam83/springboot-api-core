package com.api.coreapi.config;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@MapperScan("com.api.coreapi")
public class MyBatisConfig {
    private final SqlLogProperties sqlLogProperties;

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {

        return configuration -> {

            configuration.setMapUnderscoreToCamelCase(true);

            if (sqlLogProperties.isEnabled()) {
                configuration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
            }

        };
    }
}
