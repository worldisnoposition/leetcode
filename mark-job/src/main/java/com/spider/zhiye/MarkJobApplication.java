package com.spider.zhiye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.spider.zhiye")
@EnableJpaRepositories(basePackages = "com.spider.zhiye.jpa.repository")
@EntityScan(basePackages = "com.spider.zhiye.jpa.entity")
public class MarkJobApplication {
    public static void main(String[] args) {
        SpringApplication.run(MarkJobApplication.class, args);
    }
}
