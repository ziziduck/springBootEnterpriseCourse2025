package com.example.demo3.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(1)
public class JDBCRunner1 implements CommandLineRunner {
    @Autowired
    private NamedParameterJdbcTemplate template;
    private static final String SQL1 = "SELECT 123+321";

    @Override
    public void run(String... args) throws Exception {
        log.info("got a jdbc template:{}", template);
        log.info("data source = :{}", template.getJdbcTemplate().getDataSource());
        log.info("connection = :{}", template.getJdbcTemplate().getDataSource().getConnection());
        SqlParameterSource source = new MapSqlParameterSource();
        Integer result = template.queryForObject(SQL1, source, Integer.class);
        log.info("result={}",result);
    }
}