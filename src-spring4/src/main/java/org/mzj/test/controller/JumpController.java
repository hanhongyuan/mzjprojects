package org.mzj.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JumpController {

	// http://localhost:8080/spring/welcome
	@RequestMapping("/welcome")
	public String  toIndex(ModelAndView mv) {
		mv.addObject("user", "沐紫剑");
		return "welcome";
	}
}
