package com.example.demo1.controllers;

import com.example.demo1.bean.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
	private static final String MESSAGE1 = "message";
	private static final String MESSAGE2 = "message2";
	private static final String INFO_KEY1 = "jcourse";

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute(MESSAGE1, "Hi, I am Mark");
		model.addAttribute(MESSAGE2, "learning spring");
		return "home";
	}

	@GetMapping("/info")
	public String info(Model model) {
		Course c = new Course();
		c.setId("POOP");
		c.setName("Python and OOP programming");
		c.setDuration(42);
		c.setFee(28000);
		model.addAttribute(INFO_KEY1, c);
		return "info/contact";
	}
}
