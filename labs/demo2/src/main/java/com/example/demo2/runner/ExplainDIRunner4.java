package com.example.demo2.runner;

import com.example.demo2.race.Racing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(4)
public class ExplainDIRunner4 implements CommandLineRunner {
    @Autowired
    private Racing r1;

    @Override
    public void run(String... args) throws Exception {
        log.trace("r1 status={}", r1.status());
        log.debug("r1 status={}", r1.status());
        log.info("r1 status={}", r1.status());
        log.warn("r1 status={}", r1.status());
        log.error("r1 status={}", r1.status());

    }
}
