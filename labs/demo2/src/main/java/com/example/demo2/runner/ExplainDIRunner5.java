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
@Order(5)
public class ExplainDIRunner5 implements CommandLineRunner {
    public ExplainDIRunner5(@Qualifier("add") Calculator cal1,
                            @Qualifier("sub") Calculator cal2) {
        this.cal1 = cal1;
        this.cal2 = cal2;
    }

    private Calculator cal1;
    private Calculator cal2;

    @Override
    public void run(String... args) throws Exception {
        log.info("cal1 7,8={}", cal1.calc(7, 8));
        log.info("cal2 9,10={}", cal2.calc(9, 10));
    }
}