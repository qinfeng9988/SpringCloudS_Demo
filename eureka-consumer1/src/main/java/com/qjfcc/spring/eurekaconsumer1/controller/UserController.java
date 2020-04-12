package com.qjfcc.spring.eurekaconsumer1.controller;

import com.qjfcc.spring.eurekaconsumer1.facde.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
public class UserController {
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    IUserService userService;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/user/{name}")
    public ResponseEntity<Integer> getUser(@PathVariable String name) {
        return ResponseEntity.ok(userService.getuserIdByName(name));
    }

    @GetMapping(value = "dc")
    public ResponseEntity<String> dc() {
        ServiceInstance instance = loadBalancerClient.choose("eureka-client");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/dc";
        System.out.println(url);
        return ResponseEntity.ok(Objects.requireNonNull(restTemplate.getForObject(url, String.class)));
    }
}
