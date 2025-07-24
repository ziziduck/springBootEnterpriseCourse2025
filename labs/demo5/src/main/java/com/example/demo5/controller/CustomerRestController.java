package com.example.demo5.controller;

import com.example.demo5.entity.Customer;
import com.example.demo5.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Customer postCustomer(@RequestBody Customer c) {
        return service.create(c);
    }
}