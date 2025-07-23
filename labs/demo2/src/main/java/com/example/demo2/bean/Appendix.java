package com.example.demo2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appendix {
    private String chapter = "default chapter";
    private String detail = "default detail";
}