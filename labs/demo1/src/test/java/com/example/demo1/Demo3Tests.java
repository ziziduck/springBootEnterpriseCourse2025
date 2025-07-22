package com.example.demo1;

import com.example.demo1.controllers.RootController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class Demo3Tests {
    @Autowired
    private RootController controller;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkControllerAndMVCAvailability() {
        Assertions.assertNotNull(controller);
        Assertions.assertNotNull(mockMvc);
    }
}