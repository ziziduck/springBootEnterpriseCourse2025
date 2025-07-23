package com.example.demo2.runner;

import com.example.demo2.race.Racing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
@Slf4j
public class ExplainDIRunner3 implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        Racing r1 = context.getBean("bicycle", Racing.class);
        log.info("bicycle status={}", r1.status());
        Racing r2 = context.getBean("bike", Racing.class);
        log.info("bike status={}", r2.status());
    }
}
