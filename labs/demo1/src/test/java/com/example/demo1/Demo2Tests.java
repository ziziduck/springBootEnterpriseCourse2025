package com.example.demo1;

import com.example.demo1.controllers.RootController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Demo2Tests {
    @Autowired
    private RootController controller;

    @Test
    public void checkControllerAvailability() {
        Assertions.assertNotNull(controller);
    }
}