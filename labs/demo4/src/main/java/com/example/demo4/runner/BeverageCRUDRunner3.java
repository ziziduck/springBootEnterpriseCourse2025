package com.example.demo4.runner;

import com.example.demo4.entity.Beverage;
import com.example.demo4.repository.BeverageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@Order(3)
@Slf4j
public class BeverageCRUDRunner3 implements CommandLineRunner {
    @Autowired
    private BeverageRepository repository;

    @Override
    public void run(String... args) throws Exception {
        getBeverageByPage();
        getBeverageByPageOrderByPrice();
    }
    private static final int PAGE_SIZE=4;
    private void getBeverageByPageOrderByPrice() {

        Pageable r1 = PageRequest.of(0, PAGE_SIZE);
        log.info("page request r1={}", r1);
        log.info("page number:{}, page size:{}", r1.getPageNumber(), r1.getPageSize());
        Page<Beverage> page1 = repository.findByOrderByPriceAsc(r1);
        for (Beverage b : page1.getContent()) {
            log.info("SORTED[page1]b={}", b);
        }
        Pageable r2 = page1.nextPageable();
        log.info("page number:{}, page size:{}", r2.getPageNumber(), r2.getPageSize());
        Page<Beverage> page2 = repository.findByOrderByPriceAsc(r2);
        for (Beverage b : page2.getContent()) {
            log.info("SORTED[page2]b={}", b);
        }
        //page2.hasNext()
    }

    private void getBeverageByPage() {
        Pageable r1 = PageRequest.of(0, 3);
        log.info("page request r1={}", r1);
        log.info("page number:{}, page size:{}", r1.getPageNumber(), r1.getPageSize());
        Page<Beverage> page1 = repository.findAll(r1);
        for (Beverage b : page1.getContent()) {
            log.info("[page1]b={}", b);
        }
        Pageable r2 = page1.nextPageable();
        log.info("page number:{}, page size:{}", r2.getPageNumber(), r2.getPageSize());
        Page<Beverage> page2 = repository.findAll(r2);
        for (Beverage b : page2.getContent()) {
            log.info("[page2]b={}", b);
        }
    }
}