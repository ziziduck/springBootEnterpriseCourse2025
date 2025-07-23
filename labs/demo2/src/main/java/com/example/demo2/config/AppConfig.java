package com.example.demo2.config;

import com.example.demo2.calc.AddCalculator;
import com.example.demo2.calc.Calculator;
import com.example.demo2.calc.SubCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "add")
    public Calculator calc1() {
        return new AddCalculator();
    }

    @Bean(name = "sub")
    public Calculator calc2() {
        return new SubCalculator();
    }
}