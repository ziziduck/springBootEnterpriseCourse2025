package com.example.demo2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestController1 {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    String getHome() {
        return "[get] hello home world";
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    String postHome() {
        return "[post] hello home world";
    }
}