package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class ServerCheck {
	
	@RequestMapping("status")
	static String status() {
		System.out.println("Server Running fine...");
		return "Server Running Fine...";
	}
}
