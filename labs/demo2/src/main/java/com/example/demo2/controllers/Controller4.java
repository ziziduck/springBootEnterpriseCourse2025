package com.example.demo2.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class Controller4 {
    @GetMapping("/session2")
    public String list1(Model model, @SessionAttribute("key1") String key1) {
        model.addAttribute("key1", key1);
        return "session_result";
    }
}