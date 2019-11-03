package com.mark.eureka.client.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "mark-eureka-client-provider",fallback = FeignClientFallback.class)
public interface UserFeign {
    @RequestMapping("/getUser")
    public String getUser(String name);
}
