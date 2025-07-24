package com.example.demo4.controller;

import com.example.demo4.repository.BeverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BeverageController {
    @Autowired
    private BeverageRepository repository;

    @GetMapping("/beverages/add")
    public String showAddBeverage() {
        return "beverage/add";
    }

    @GetMapping("/beverages/all")
    public String getAllBeverage(Model model) {
        model.addAttribute("beverages", repository.findByOrderByPriceAsc());
        return "beverage/list";
    }
}