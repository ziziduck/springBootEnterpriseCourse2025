package com.example.demo1;

import com.example.demo1.bean.NormalUser3;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class Demo9Tests {
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
        NormalUser3 user1 = new NormalUser3("ABC");
        Set<ConstraintViolation<NormalUser3>> violations = validator.validate(user1);
        Assertions.assertEquals(0, violations.size());
    }

    @Test
    public void checkUserWithBlankName() {
        NormalUser3 user1 = new NormalUser3("   ");
        Set<ConstraintViolation<NormalUser3>> violations = validator.validate(user1);
        for (ConstraintViolation<NormalUser3> c:violations){
            System.out.printf("violation message=[%s]\n",c.getMessage());
        }
        Assertions.assertEquals(1, violations.size());
    }

    @Test
    public void checkUserWithEmptyStringName() {
        NormalUser3 user1 = new NormalUser3("");
        Set<ConstraintViolation<NormalUser3>> violations = validator.validate(user1);
        for (ConstraintViolation<NormalUser3> c:violations){
            System.out.printf("violation message=[%s]\n",c.getMessage());
        }
        Assertions.assertEquals(1, violations.size());
    }

    @Test
    public void checkUserWithNullName() {
        NormalUser3 user1 = new NormalUser3(null);
        Set<ConstraintViolation<NormalUser3>> violations = validator.validate(user1);
        for (ConstraintViolation<NormalUser3> c:violations){
            System.out.printf("violation message=[%s]\n",c.getMessage());
        }
        Assertions.assertEquals(1, violations.size());
    }
}