package com.example.demo5.controller;

import com.example.demo5.entity.Customer;
import com.example.demo5.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
    @Autowired
    private CustomerService service;
    @GetMapping("/all")
    List<Customer> getCustomers() {
        return service.findAll();
    }
}