package com.example.demo2.controllers;

import com.example.demo2.bean.Counter1;
import com.example.demo2.bean.Counter2;
import com.example.demo2.bean.Counter3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Rest2 {
    @Autowired
    private Counter1 counter1;
    @Autowired
    private Counter2 counter2;
    @Autowired
    private Counter3 counter3;

    @GetMapping("/rest2")
    public ResponseEntity<?> doRest1() {
        Map<String, Integer> result = new HashMap<>();
        counter1.setValue(counter1.getValue() + 5);
        counter2.setValue(counter2.getValue() + 5);
        counter3.setValue(counter3.getValue() + 5);
        result.put("counter1", counter1.getValue());
        result.put("counter2", counter2.getValue());
        result.put("counter3", counter3.getValue());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}