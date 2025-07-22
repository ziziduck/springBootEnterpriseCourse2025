package com.example.demo1;

import com.example.demo1.controllers.GreetController;
import com.example.demo1.services.GreetingService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = GreetController.class)
public class Demo5Tests {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private GreetingService service;

    @Test
    public void checkPrecondition() {
        Assertions.assertNotNull(mockMvc);
        Assertions.assertNotNull(service);
    }

    @Test
    public void performGreeting1() throws Exception {
        String serviceString = "hello mockito test";
        Mockito.when(service.greet()).thenReturn(serviceString);
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("mockito".toUpperCase())));

    }

    @Test
    public void performHomeAccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        ;
    }
}