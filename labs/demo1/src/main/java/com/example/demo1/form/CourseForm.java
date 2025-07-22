package com.example.demo1.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseForm {
	@NotEmpty
	@Size(min = 5, max = 30)
	private String courseId;
	@NotEmpty
	private String courseName;
	@NotNull
	@Min(7)
	private Integer duration;
}