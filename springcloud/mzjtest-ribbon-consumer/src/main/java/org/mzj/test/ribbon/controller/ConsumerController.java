package org.mzj.test.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("ribbon")
	public String callTest() {
		return restTemplate.getForEntity("http://test-service/test", String.class).getBody();
	}
}
