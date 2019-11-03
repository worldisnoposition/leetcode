package com.mark.eureka.client.consumer.feign;

import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback implements UserFeign {
    @Override
    public String getUser(String name) {
        System.out.println("熔断，默认回调函数"+name);
        return "{\"username\":\"admin\",\"age\":\"-1\"}";
    }
}
