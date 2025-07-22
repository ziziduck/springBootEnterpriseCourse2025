package com.example.demo1.controllers;

import com.example.demo1.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetController {
	@Autowired
	private GreetingService service;
	@RequestMapping("/greeting")
	public @ResponseBody String greeting() {
		return service.greet();
	}
}