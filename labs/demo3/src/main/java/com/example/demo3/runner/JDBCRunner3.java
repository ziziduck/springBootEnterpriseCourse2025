package com.example.demo3.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Slf4j
@Order(3)
public class JDBCRunner3 implements CommandLineRunner {
    @Autowired
    private JdbcTemplate template;
    private static final String USER1 = "Mark password1";
    private static final String USER2 = "John password2";
    private static final String USER3 = "Ken password3";
    private static final String USER4 = "Tim password4";


    @Override
    public void run(String... args) throws Exception {
        List<String[]> names = Stream.of(USER1, USER2, USER3, USER4).map(new Function<String, String[]>() {

            @Override
            public String[] apply(String s) {
                return s.split(" ");
            }
        }).toList();
        names.forEach(o -> {
            log.info("after split, 1st={}, 2nd={}", o[0], o[1]);
        });
    }
}