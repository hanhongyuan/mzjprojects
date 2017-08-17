package org.mzj.test.ribbon.controller;

import org.mzj.test.ribbon.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConsumerController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ConsumerService consumerService;
	
	//http://localhost:9000/ribbon
	@RequestMapping("ribbon")
	public String doTest() {
		// 必须改造成去service里调用，直接在Controller里测试失败
		return consumerService.doTestInternal();
	}
	
	//下面是直接在Controller里做的测试，没有成功
	//------------------------------------
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "testFallback")
	public String doTestInternal() {
		return restTemplate.getForEntity("http://test-service/test", String.class).getBody();
	}
	
	//熔断请求回调方法
	public String testFallback() {
		logger.info("testFallback");
		return "error";
	}
	//------------------------------------
}
