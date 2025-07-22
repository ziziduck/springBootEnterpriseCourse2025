package com.example.demo1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	private String id;
	private String name;
	private Integer duration;
	private Integer fee;
}
