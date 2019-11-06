package com.mark.eureka.client.consumer.rest;

import com.mark.eureka.base.UserVO;
import com.mark.eureka.client.consumer.feign.UserFeign;
import com.mark.eureka.client.consumer.ribbon.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.ribbon.RibbonResponseStatusCodeException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class Test {
    @Autowired
    private UserFeign userFeign;
    @Autowired
    private RibbonService ribbonRervice;

    @RequestMapping("/test")
    public String index(@RequestParam String name) {
        System.out.println(name);
        UserVO userVO = new UserVO();
        userVO.setId(1L);
        userVO.setName("name");
        userVO.setExtend("extends");
        userVO.setAge(10);
        return userFeign.saveUser(userVO);
    }

    @RequestMapping("/testRibbonGetUser")
    public String testRibbonGetUser(@RequestParam String name) {
        String a = ribbonRervice.getUser();
        return a;
    }

    @RequestMapping("/testRibbonSaveUser")
    public String testRibbonSaveUser(@RequestParam String name) {
        UserVO userVO = new UserVO();
        userVO.setId(1L);
        userVO.setName("name");
        userVO.setExtend("extends");
        userVO.setAge(10);
        String a = ribbonRervice.saveUser(userVO);
        return a;
    }
}
