package com.mark.eureka.client.consumer.hystrix;

import com.mark.eureka.base.UserVO;
import com.mark.eureka.client.consumer.feign.UserFeign;
import com.mark.eureka.client.consumer.ribbon.RibbonService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HystrixController {
    @Autowired
    private UserFeign userFeign;
    @Autowired
    private RibbonService ribbonRervice;

    @HystrixCommand(fallbackMethod = "getDefaultUser")
    @RequestMapping("/hystrix/getUser")
    public String getUser() {
        return userFeign.getUser("hystrixUserName");
    }
    @HystrixCommand(fallbackMethod = "getDefaultUser")
    @RequestMapping("/hystrix/saveUser")
    public String saveUser() {
        UserVO userVO = new UserVO();
        userVO.setId(1L);
        userVO.setName("hystrixUserName");
        userVO.setExtend("save");
        userVO.setAge(10);
        return ribbonRervice.saveUser(userVO);
    }
    private String getDefaultUser() {
        log.info("熔断，默认回调函数");
        return "{\"username\":\"hystrixUserName\",\"age\":\"-1\"}";
    }
}
