package com.qjfcc.spring.eurekaconsumerribbon;

import com.qjfcc.spring.eurekaconsumerribbon.controller.DcController;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
class EurekaConsumerRibbonApplicationTests {

    @Autowired
    private DcController dcController;

    @Test
    void contextLoads() {
        String r = dcController.dc2().block();
        Assert.isTrue("[\"eureka-client\",\"eureka-consumer\",\"eureka-consumer-ribbon\"]".equals(r), "返回结果不符合预期");
    }

}
