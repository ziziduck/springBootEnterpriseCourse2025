package com.example.demo2.controllers;

import com.example.demo2.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class WelcomeController {
    @Autowired
    private Message m;

    @RequestMapping("/welcome")
    Message hello() {
        m.setCost(4.5f);
        m.setValid(true);
        m.setDate(new Date());
        m.setDetail("使用unicode行不行");
        return m;
    }
}