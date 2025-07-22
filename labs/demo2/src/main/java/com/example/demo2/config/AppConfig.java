package com.example.demo2.config;

import com.example.demo2.calc.AddCalculator;
import com.example.demo2.calc.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Calculator calc1() {
        return new AddCalculator();
    }
}