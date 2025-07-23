package com.example.demo4.runner;

import com.example.demo4.entity.Beverage;
import com.example.demo4.repository.BeverageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(1)
public class BeverageCRUDRunner implements CommandLineRunner {
    @Autowired
    private BeverageRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Beverage b1 = new Beverage();
        b1.setTitle("Tall ice coffee");
        b1.setDetail("Americano");
        b1.setPrice(120);
        b1.setSugar(0.0f);
        repository.save(b1);
    }
}