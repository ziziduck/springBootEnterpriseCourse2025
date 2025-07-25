package com.example.demo4.runner;

import com.example.demo4.repository.BeverageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(4)
public class BeverageCRUDRunner4 implements CommandLineRunner {
    @Autowired
    private BeverageRepository repository;

    @Override
    public void run(String... args) throws Exception {
        searchSmallCola();
        searchAllSmallAndCola();
        searchsmallCOLA();
        searchSMALL_COLA();
        searchLatteLike();
        searchLATTEContaining();
        searchPriceBetween();
    }

    private void searchPriceBetween() {
        repository.findByPriceBetweenOrderByPriceAsc(35, 120)
                .forEach(b -> log.info("[55-120] beverage:{}", b));
    }

    private void searchLATTEContaining() {
        repository.findByTitleContainingIgnoreCase("LATTE")
                .forEach(b -> log.info("containing LATTE ignore case:{}", b));
    }

    private void searchLatteLike() {
        repository.findByTitleLike("%latte%").forEach(b ->
                log.info("like latte:{}", b));
    }

    private void searchSMALL_COLA() {
        repository.findByTitleAndDetailOrderByPriceAscAllIgnoreCase("COLA", "SMALL")
                .forEach(b -> log.info("search SMALL COLA:{}", b));
    }

    private void searchsmallCOLA() {
        repository.findByTitleIgnoreCaseAndDetailOrderByPriceAsc("COLA", "small")
                .forEach(b -> log.info("search COLA small:{}", b));
    }

    private void searchAllSmallAndCola() {
        repository.findByTitleOrDetailOrderByPriceAsc("Cola", "small")
                .forEach(b -> log.info("all small and cola={}", b));
    }

    private void searchSmallCola() {
        repository.findByTitleAndDetailOrderByPriceAsc("Cola", "small")
                .forEach(beverage -> log.info("small cola={}", beverage));
    }
}