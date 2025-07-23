package com.example.demo2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private int id;
    private String name;
    private float cost;
    private boolean isValid;
    private Date date;
    private String detail;
    private String[] referral = {"John", "Mark", "Ken"};
    private Appendix appendix = new Appendix();
}