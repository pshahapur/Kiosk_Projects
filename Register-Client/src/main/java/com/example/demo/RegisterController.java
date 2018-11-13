package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

	@GetMapping("/test")
	public String TestMethod() {
		return "Register service using Spring Boot";
	}
}
