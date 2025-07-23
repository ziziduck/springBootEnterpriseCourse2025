package com.example.demo2.controllers;

import com.example.demo2.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @Autowired
    private Message m;

    @RequestMapping("/welcome")
    Message hello() {
        return m;
    }
}