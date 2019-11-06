package com.mark.eureka.client.consumer.ribbon;

import com.alibaba.fastjson.JSONObject;
import com.mark.eureka.base.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService implements IRibbonService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Override
    public String getUser() {
        this.loadBalancerClient.choose("mark-eureka-client-provider");
        String info = restTemplate.postForObject("http://mark-eureka-client-provider/getUser?name=parameters", "request",String.class);
        return info;
    }
    @Override
    public String saveUser(UserVO userVO) {
        this.loadBalancerClient.choose("mark-eureka-client-provider");
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(JSONObject.toJSONString(userVO), headers);
        ResponseEntity<String> info = restTemplate.postForEntity("http://mark-eureka-client-provider/saveUser?name=parameters",formEntity ,String.class);
        return info.getBody();
    }
}
