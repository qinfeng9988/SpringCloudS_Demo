package com.qjfcc.spring.eurekaconsumer1;

import com.qjfcc.spring.eurekaconsumer1.facde.IUserService;
import com.qjfcc.spring.eurekaconsumer1.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumer1Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumer1Application.class, args);
    }

    @Bean(initMethod = "init2")
    public IUserService user(){
        return new UserService();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
