package com.example.demo2.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller3 {
    @GetMapping("/session1")
    public String list1(HttpSession session) {
        session.setAttribute("key1", "abcde12345");
        return "session_list";
    }
}