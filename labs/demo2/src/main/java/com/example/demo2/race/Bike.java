package com.example.demo2.race;

import org.springframework.stereotype.Component;

@Component("bike")
public class Bike implements Racing {
    @Override
    public String status() {
        return "50km/hr";
    }
}