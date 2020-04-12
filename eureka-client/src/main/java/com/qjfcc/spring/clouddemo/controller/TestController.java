package com.qjfcc.spring.clouddemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

//    IUserService userService;
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping(value = "/dc")
    public List<String> test1(String a) {
        return discoveryClient.getServices();
    }
}
