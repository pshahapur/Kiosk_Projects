package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@RequestMapping(value="/test",method = RequestMethod.GET)
	public String HelloSample() {
		return "Spring Boot";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String checkMethod() {
		return "Spring Boot without Endpoint";
	}
}
