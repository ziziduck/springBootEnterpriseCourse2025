package com.example.demo1.controllers;

import com.example.demo1.form.Form1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MoreDemoController {
	@GetMapping("/more")
	public String listAll(Form1 form1) {
		log.info("form1={}",form1);
		return "operate";
	}
}