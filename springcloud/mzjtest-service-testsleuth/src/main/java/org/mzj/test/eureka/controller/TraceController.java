package org.mzj.test.eureka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TraceController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RestTemplate restTemplate;
	
	// 模拟调用另外一个微服务，不能叫trace
	// http://localhost:8083/trace1
	@RequestMapping("trace1")
	public String trace1() {
		logger.info("==== trace1 -->");
		
		logger.info("call test begin...");
		String result = restTemplate.getForEntity("http://test-service/test", String.class).getBody();
		logger.info("call test end. result=" + result);
		
		logger.info("==== trace1 --|");
		return result;
	}
}
