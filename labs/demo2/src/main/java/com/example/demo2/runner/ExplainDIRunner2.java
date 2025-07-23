package com.example.demo2.runner;

import com.example.demo2.calc.Calculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(2)
public class ExplainDIRunner2 implements CommandLineRunner {
//    public ExplainDIRunner2(Calculator cal1) {
//        this.cal1 = cal1;
//    }

    @Autowired
    @Qualifier("add")
    private Calculator cal1;
    @Autowired
    @Qualifier("sub")
    private Calculator cal2;

    @Override
    public void run(String... args) throws Exception {
        log.info("cal1 3,4={}", cal1.calc(3, 4));
        log.info("cal2 5,6={}", cal2.calc(5, 6));
    }
}