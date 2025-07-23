package com.example.demo3.runner;

import com.example.demo3.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Slf4j
@Order(4)
public class JDBCRunner4 implements CommandLineRunner {
    @Autowired
    private JdbcTemplate template;
    private static final String USER1 = "Mark password1";
    private static final String USER2 = "John password2";
    private static final String USER3 = "Ken password3";
    private static final String USER4 = "Tim password4";
    private static final String DROP_DDL = "DROP TABLE users IF EXISTS";
    private static final String CREATE_DDL = "CREATE TABLE users(id SERIAL, username VARCHAR(255), password VARCHAR(255))";
    private static final String INSERT_DML = "INSERT INTO users(username, password) VALUES (?,?)";
    private static final String SELECT_DML = "SELECT * FROM users";
    private static final String SELECT_DML2 = "SELECT id, username,password FROM users WHERE username=?";

    @Override
    public void run(String... args) throws Exception {
        template.execute(DROP_DDL);
        template.execute(CREATE_DDL);
        List<Object[]> users = Stream.of(USER1, USER2, USER3, USER4)
                .map(o -> o.split(" ")).collect(Collectors.toList());
        template.batchUpdate(INSERT_DML, users);
        List<User> queryUsers = template.query(SELECT_DML, (rs, rowNum) ->
                new User(rs.getString("username"), rs.getString("password")));
        log.info("query back, users={}", queryUsers);
        // explain
        template.query(SELECT_DML, (rs, rowNum) -> {
            log.info("rowNum={},rs={}", rowNum, rs);
            return null;
        });
        // make it efficient
        template.query(SELECT_DML, (rs, rowNum) ->
                        new User(rs.getString("username"), rs.getString("password")))
                .forEach(u -> log.info("extract query back:{}", u));
        List<User> queryWithParameterUsers = template.query(SELECT_DML2, (rs, rowNum) ->
                new User(rs.getString("username"), rs.getString("password")), new Object[]{"Mark"});
        log.info("query with parameter, user={}", queryWithParameterUsers);
        User userWithNameMark = template.queryForObject(SELECT_DML2, (rs, rowNum) ->
                new User(rs.getString("username"), rs.getString("password")), "Mark");
        log.info("user with name Mark ={}", userWithNameMark);

    }
}