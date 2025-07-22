package com.example.demo1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Demo1Tests {
    @BeforeEach
    public void prepare() {
        System.out.println("prepare data and directory structure");
    }

    @Test
    public void doSomeTest1() {
        System.out.println("test 1");
    }

    @Test
    public void doSomeTest2() {
        System.out.println("test 2");

    }

    @Test
    @Disabled("no need to re-run fail case")
    public void doSomeTest3() {
        System.out.println("fail on purpose");
        Assertions.fail("fail on purpose");
    }

    @AfterEach
    public void cleanUp() {
        System.out.println("clean up directory");
    }
}