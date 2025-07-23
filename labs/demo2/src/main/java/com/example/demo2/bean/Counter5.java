package com.example.demo2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApplicationScope
@Component
//@Scope(value= WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Counter5 {
    private Integer value = 50;
}