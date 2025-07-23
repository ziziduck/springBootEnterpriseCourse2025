package com.example.demo2.controllers;

import com.example.demo2.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller2 {
    @Autowired
    private Counter1 counter1;
    @Autowired
    private Counter2 counter2;
    @Autowired
    private Counter3 counter3;
    @Autowired
    private Counter4 counter4;
    @Autowired
    private Counter5 counter5;

    @GetMapping("/list2")
    public String list1(Model model) {
        counter1.setValue(counter1.getValue() + 1);
        counter2.setValue(counter2.getValue() + 1);
        counter3.setValue(counter3.getValue() + 1);
        counter4.setValue(counter4.getValue() + 1);
        counter5.setValue(counter5.getValue() + 1);
        model.addAttribute("c1", counter1.getValue());
        model.addAttribute("c2", counter2.getValue());
        model.addAttribute("c3", counter3.getValue());
        model.addAttribute("c4", counter4.getValue());
        model.addAttribute("c5", counter5.getValue());


        return "list";
    }
}