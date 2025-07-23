package com.example.demo2.controllers;

import com.example.demo2.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin // for vue access
public class HelloController {
    @Autowired
    private Message message;

    @RequestMapping("/hello")
    Message home() {
        message.setId(888);
        message.setName("Hi Mark");
        return message;
    }
}