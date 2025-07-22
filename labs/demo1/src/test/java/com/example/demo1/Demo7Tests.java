package com.example.demo1;

import com.example.demo1.bean.NormalUser1;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class Demo7Tests {
    private static Validator validator;

    @BeforeAll
    public static void initValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @AfterAll
    public static void shutdownValidator() {
        Validation.buildDefaultValidatorFactory().close();
    }

    @Test
    public void checkValidatorIsValid() {
        Assertions.assertNotNull(validator);
        System.out.printf("validator is:%s\n", validator);
    }

    @Test
    public void checkUserWithName() {
        NormalUser1 user1 = new NormalUser1("ABC");
        Set<ConstraintViolation<NormalUser1>> violations = validator.validate(user1);
        Assertions.assertEquals(0, violations.size());
    }

    @Test
    public void checkUserWithBlankName() {
        NormalUser1 user1 = new NormalUser1("   ");
        Set<ConstraintViolation<NormalUser1>> violations = validator.validate(user1);
        Assertions.assertEquals(0, violations.size());
    }

    @Test
    public void checkUserWithEmptyStringName() {
        NormalUser1 user1 = new NormalUser1("");
        Set<ConstraintViolation<NormalUser1>> violations = validator.validate(user1);
        Assertions.assertEquals(0, violations.size());
    }

    @Test
    public void checkUserWithNullName() {
        NormalUser1 user1 = new NormalUser1(null);
        Set<ConstraintViolation<NormalUser1>> violations = validator.validate(user1);
        Assertions.assertEquals(1, violations.size());
    }
}