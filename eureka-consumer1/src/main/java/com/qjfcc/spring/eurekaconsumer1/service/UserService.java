package com.qjfcc.spring.eurekaconsumer1.service;

import com.qjfcc.spring.eurekaconsumer1.facde.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

public class UserService implements IUserService {
    private String initName;

    @Override
    public Integer getuserIdByName(String userName) {
        return StringUtils.isNotBlank(userName) && userName.equals(initName) ? 123 : 987;
    }

    @PostConstruct
    public void init() {
        this.initName = "bcd";
    }

    public void init2(){
        this.initName = "cde";
    }

}
