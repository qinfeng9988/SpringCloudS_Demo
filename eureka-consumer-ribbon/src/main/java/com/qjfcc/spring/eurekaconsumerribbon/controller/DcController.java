package com.qjfcc.spring.eurekaconsumerribbon.controller;

import com.qjfcc.spring.eurekaconsumerribbon.entity.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RestController
@EnableConfigurationProperties({UserConfig.class})
public class DcController {

    @Autowired
    RestTemplate restTemplate;
    WebClient.Builder clientBuilder;

    @Autowired
    UserConfig userConfig;

    @Value("${my.name}")
    String name;
    @Autowired
    public DcController(WebClient.Builder webClientBuilder) {
        this.clientBuilder = webClientBuilder;
    }

    @GetMapping(value = "dc")
    public ResponseEntity<String> dc() {

        String url = "http://eureka-client/dc";
//        System.out.println(url);
        return ResponseEntity.ok(Objects.requireNonNull(restTemplate.getForObject(url, String.class)));
    }

    @GetMapping(value = "dc2")
    public Mono<String> dc2() {
        String url = "http://eureka-client/dc";
//        System.out.println(url);
//        clientBuilder.baseUrl(url).build().get().header("authkey","aaaaaaaaaaa").retrieve().bodyToMono(String.class);
        return
                clientBuilder.baseUrl(url).build().get().header("authkey", "aaaaaaaaaaa").retrieve().bodyToMono(String.class)
                ;
    }

    @GetMapping(value = "user")
    public ResponseEntity<UserConfig> getUser() {
        return ResponseEntity.ok(userConfig);
    }
}
