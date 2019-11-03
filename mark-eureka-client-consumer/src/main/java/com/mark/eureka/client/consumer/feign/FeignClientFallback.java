package com.mark.eureka.client.consumer.feign;

import com.mark.eureka.base.UserVO;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback implements UserFeign {
    @Override
    public String getUser(String name) {
        System.out.println("熔断，默认回调函数"+name);
        return "{\"username\":\"admin\",\"age\":\"-1\"}";
    }

    @Override
    public String saveUser(UserVO userVO) {
        System.out.println("熔断，默认回调函数"+userVO);
        return "{\"username\":\"admin\",\"age\":\"-1\"}";
    }
}
