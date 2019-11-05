package com.mark.eureka.client.consumer.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
	//Contract feign的默认契约
	@Bean
	public Contract feignContract() {
		return new Contract.Default();
	}

}