package com.mark.eureka.client.consumer.feign;

import com.mark.eureka.base.UserVO;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "mark-eureka-client-provider",fallback = FeignClientFallback.class)
public interface UserFeign {
    @RequestLine("POST /getUser")
    String getUser(String name);
    @RequestLine("POST /saveUser")
    String saveUser(UserVO userVO);


}
