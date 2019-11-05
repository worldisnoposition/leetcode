package com.mark.eureka.client.consumer.rest;

import com.mark.eureka.base.UserVO;
import com.mark.eureka.client.consumer.feign.UserFeign;
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
        System.out.println(name);
        UserVO userVO = new UserVO();
        userVO.setId(1L);
        userVO.setName("name");
        userVO.setExtend("extends");
        return userFeign.saveUser(userVO);
    }
}
