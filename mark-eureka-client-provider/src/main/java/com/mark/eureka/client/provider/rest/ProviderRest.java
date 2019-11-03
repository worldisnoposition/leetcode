package com.mark.eureka.client.provider.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class ProviderRest {
    @PostConstruct
    public void init(){
        System.out.println(11111);
    }
    @RequestMapping("/getUser")
    public String index(String name) {
        return "这是服务提供者，参数："+name;
    }
}
