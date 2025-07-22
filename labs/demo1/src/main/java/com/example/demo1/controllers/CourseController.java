package com.example.demo1.controllers;

import com.example.demo1.form.CourseForm;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class CourseController {
	private static final String COURSE_FORM2 = "form2";

	@GetMapping("/course")
	public String showCourseForm(CourseForm f, Model model) {
//        f.setCourseId("OO-226");
//        f.setCourseName("Java and UML");
//        f.setDuration(35);
		model.addAttribute(COURSE_FORM2, new CourseForm(
				"BDPY", "Python and Big Data", 42
		));
		return "courseForm";
	}

	@PostMapping("/course")
	public String handleFormSubmit(@Valid CourseForm f, BindingResult result) {
		// temporary get the result, see if validation is valid or not
		if (result.hasErrors()) {
			return "courseForm";
		} else {
			return "home";
		}
//        log.info("get course={}", f);
//        return "courseForm"; // but need to refactor later
	}
}