package com.example.demo1.controllers;

import com.example.demo1.form.CourseForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {
	private static final String COURSE_FORM2 = "form2";

	@GetMapping("/course")
	public String showCourseForm(CourseForm f, Model model) {
		f.setCourseId("OO-226");
		f.setCourseName("Java and UML");
		f.setDuration(35);
		model.addAttribute(COURSE_FORM2, new CourseForm(
				"BDPY", "Python and Big Data", 42
		));
		return "courseForm";
	}
}
