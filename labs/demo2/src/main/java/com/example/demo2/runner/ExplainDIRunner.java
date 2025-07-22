package com.example.demo2.runner;

import com.example.demo2.calc.Calculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ExplainDIRunner implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        log.info("try to load Calculator instance");
        Calculator bean1 = context.getBean(Calculator.class);
        log.info("calculate 2,3 ={}", bean1.calc(2, 3));
    }
}