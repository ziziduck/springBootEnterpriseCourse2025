package com.example.demo2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @RequestMapping("/greeting")
    public String greeting(Model model,
                           @RequestParam(value = "name", required = false, defaultValue = "systex") String name) {
//                           String name) {
//        name = "systex";
        model.addAttribute("name", name);
        return "greeting";
    }
}