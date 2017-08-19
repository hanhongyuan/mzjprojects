package org.mzj.test.eureka;

import org.mzj.test.eureka.sample.TagSampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//激活DiscoveryClient实现
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceApplication {
	// 产生一个RestTemplate交给Spring容器管理，并开启客户端负载均衡
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	//使用自定义的Sampler
	@Bean
	TagSampler defSample() {
		return new TagSampler();
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
}
