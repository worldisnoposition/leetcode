package com.mark.eureka.client.consumer.rest;

import com.mark.eureka.client.consumer.feign.UserFeign;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class Test {
    @Autowired
    private UserFeign userFeign;
    @RequestMapping("/test")
    public String index(@RequestParam String name) {
        return userFeign.getUser(name);
    }
}
