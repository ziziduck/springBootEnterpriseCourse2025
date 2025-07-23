package com.example.demo2.calc;

public class SubCalculator implements Calculator {
    @Override
    public int calc(int a, int b) {
        return a - b;
    }
}