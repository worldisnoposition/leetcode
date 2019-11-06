package com.mark.eureka.client.consumer.config;

import feign.Contract;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfiguration {
//    @Bean
//    @LoadBalanced
//    public RestTemplate feignContract() {
//        return new RestTemplate();
//    }

}
