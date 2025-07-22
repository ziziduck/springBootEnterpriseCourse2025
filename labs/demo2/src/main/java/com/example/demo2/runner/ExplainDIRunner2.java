package com.example.demo2.runner;

import com.example.demo2.calc.Calculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(2)
public class ExplainDIRunner2 implements CommandLineRunner {
    public ExplainDIRunner2(Calculator cal1) {
        this.cal1 = cal1;
    }

    //@Autowired
    private Calculator cal1;

    @Override
    public void run(String... args) throws Exception {
        log.info("calculate 3,4={}", cal1.calc(3, 4));
    }
}