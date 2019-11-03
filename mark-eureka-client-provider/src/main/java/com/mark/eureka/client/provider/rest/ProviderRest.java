package com.mark.eureka.client.provider.rest;

import com.mark.eureka.base.UserVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class ProviderRest {
    @PostConstruct
    public void init() {
        System.out.println(11111);
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public String getUser(String name) {
        return "这是服务提供者，参数：" + name;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@RequestBody UserVO userVO) {
        return "这是服务提供者，参数：" + userVO;
    }
}
