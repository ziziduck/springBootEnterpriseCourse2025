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
@Order(2)
public class BeverageCRUDRunner2 implements CommandLineRunner {
    @Autowired
    private BeverageRepository repository;

    @Override
    public void run(String... args) throws Exception {
        log.info("repository={}", repository);
        listBeverageOrderByPrice();
        listBeverageOrderByPriceDesc();
        listCola();
        listColaOrderByPrice();
        callCount();
        listOnlyCOLAIgnoreCase();
    }

    private void listOnlyCOLAIgnoreCase() {
        repository.findMatchByTitleIgnoreCaseOrderByPriceAsc("COLA")
                .forEach(beverage -> log.info("with COLA ignore case, beverage={}", beverage));
    }

    private void callCount() {
        log.info("with cola, count={}", repository.countByTitle("Cola"));
    }

    private void listColaOrderByPrice() {
        repository.findMatchByTitleOrderByPriceAsc("Cola").forEach(b ->
                log.info("search 'Cola' order by price Asc, {}", b));
    }

    private void listCola() {
        repository.findMatchByTitle("Cola").forEach(b ->
                log.info("search 'Cola', {}", b));
    }

    private void listBeverageOrderByPriceDesc() {
        log.info("-----------------");
        repository.findByOrderByPriceDesc().forEach(beverage ->
                log.info("[{}]order by price desc:{}", beverage.getPrice(), beverage));
    }

    private void listBeverageOrderByPrice() {
        for (Beverage b : repository.findByOrderByPriceAsc()) {
            log.info("[{}] order by price:{}", b.getPrice(), b);
        }
    }
}