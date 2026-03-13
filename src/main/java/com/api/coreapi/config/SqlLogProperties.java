package com.api.coreapi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.sql-log")
@Getter
@Setter
public class SqlLogProperties {
    private boolean enabled;
}
