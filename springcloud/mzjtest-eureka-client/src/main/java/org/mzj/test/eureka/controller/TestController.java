package org.mzj.test.eureka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

@RestController
public class TestController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DiscoveryClient client;

	@RequestMapping("/test")
	public String test() {
		ServiceInstance instance = client.getLocalServiceInstance();
		String json = JSONObject.fromObject(instance).toString();
		logger.info("LocalServiceInstance: " + json);
		return json;
	}
}
