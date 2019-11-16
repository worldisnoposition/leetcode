package com.mark.eureka.client.consumer;

import com.sun.org.apache.regexp.internal.RE;
import feign.Contract;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class EurekaClientConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientConsumerApplication.class, args);
    }

    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
//        for (HttpMessageConverter<?> messageConverter : restTemplate.getMessageConverters()) {
//            for (MediaType supportedMediaType : messageConverter.getSupportedMediaTypes()) {
//                System.out.println(supportedMediaType);
//            }
//        }
        return new RestTemplate();
    }

}
