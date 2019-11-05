package com.mark.eureka.client.consumer.feign;

import com.mark.eureka.base.UserVO;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "mark-eureka-client-provider", fallback = FeignClientFallback.class)
public interface UserFeign {
        @RequestLine("POST /getUser")
//    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    String getUser(String name);

//    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @RequestLine("POST /saveUser")
    String saveUser(@RequestBody UserVO userVO);


}
