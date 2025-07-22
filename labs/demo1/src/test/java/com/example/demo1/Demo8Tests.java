package com.example.demo1;

import com.example.demo1.bean.NormalUser2;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class Demo8Tests {
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
        NormalUser2 user1 = new NormalUser2("ABC");
        Set<ConstraintViolation<NormalUser2>> violations = validator.validate(user1);
        Assertions.assertEquals(0, violations.size());
    }

    @Test
    public void checkUserWithBlankName() {
        NormalUser2 user1 = new NormalUser2("   ");
        Set<ConstraintViolation<NormalUser2>> violations = validator.validate(user1);
        Assertions.assertEquals(0, violations.size());
    }

    @Test
    public void checkUserWithEmptyStringName() {
        NormalUser2 user1 = new NormalUser2("");
        Set<ConstraintViolation<NormalUser2>> violations = validator.validate(user1);
        for (ConstraintViolation<NormalUser2> c:violations){
            System.out.printf("violation message=[%s]\n",c.getMessage());
        }
        Assertions.assertEquals(1, violations.size());
    }

    @Test
    public void checkUserWithNullName() {
        NormalUser2 user1 = new NormalUser2(null);
        Set<ConstraintViolation<NormalUser2>> violations = validator.validate(user1);
        for (ConstraintViolation<NormalUser2> c:violations){
            System.out.printf("violation message=[%s]\n",c.getMessage());
        }
        Assertions.assertEquals(1, violations.size());
    }
}