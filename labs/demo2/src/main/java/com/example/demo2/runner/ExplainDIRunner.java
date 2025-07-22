package com.example.demo2.runner;

import com.example.demo2.calc.Calculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(1)
public class ExplainDIRunner implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        log.info("try to load Calculator instance");
        Calculator bean1 = context.getBean("add", Calculator.class);
        log.info("bean1 2,3 ={}", bean1.calc(2, 3));
        Calculator bean2 = context.getBean("sub", Calculator.class);
        log.info("bean2 4,5 ={}", bean2.calc(4, 5));
    }
}