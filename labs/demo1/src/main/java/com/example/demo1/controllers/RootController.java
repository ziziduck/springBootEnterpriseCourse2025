package com.example.demo1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
	private static final String MESSAGE1 = "message";

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute(MESSAGE1, "Hi, I am Mark");
		return "home";
	}

	@GetMapping("/info")
	public String info() {
		return "info/contact";
	}
}