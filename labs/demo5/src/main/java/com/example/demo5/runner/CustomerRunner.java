package com.example.demo5.runner;

import com.example.demo5.entity.Customer;
import com.example.demo5.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(1)
public class CustomerRunner implements CommandLineRunner {
    private final CustomerRepository repository;

    public CustomerRunner(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Customer("Mark", "Ho"));
        repository.findAll().forEach(b -> log.info("query back:{}", b));
    }
}