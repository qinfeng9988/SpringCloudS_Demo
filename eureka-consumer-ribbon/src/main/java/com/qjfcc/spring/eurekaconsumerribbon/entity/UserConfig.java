package com.qjfcc.spring.eurekaconsumerribbon.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "my")
@Component
@Data
public class UserConfig {
    private String name;
    private Integer age;
    private Integer number;
}
