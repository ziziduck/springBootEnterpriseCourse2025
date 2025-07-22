package com.example.demo1;

import com.example.demo1.controllers.GreetController;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class Demo6Tests {
    @Autowired
    private GreetController controller;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkPreCondition() {
        Assertions.assertNotNull(controller);
        Assertions.assertNotNull(mockMvc);
        //controller.
    }

    @Test
    public void checkGreetingBehavior() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("first service".toUpperCase())));

    }
}