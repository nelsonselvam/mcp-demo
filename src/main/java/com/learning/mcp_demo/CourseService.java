package com.learning.mcp_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class CourseService {
	
	private static final Logger log = LoggerFactory.getLogger(CourseService.class);
	
	private List<Course> courses = new ArrayList<>();
	
	@Tool(name = "get_courses", description = "Get courses list")
	public List<Course> getCourses() {
		log.info("getCourses method called");
		return courses;
	}
	
	@Tool(name = "get_course", description = "Get course by name")
	public Course getCourse(String courseName) {
		log.info("getCourse method called with courseName: {}", courseName);
		return courses.stream()
				.filter(course -> course.title().equalsIgnoreCase(courseName))
				.findFirst()
				.orElse(null);
	}
	
	@PostConstruct
	public void init() {
		log.info("CourseService bean is created");
		courses.addAll(Arrays.asList(
				new Course("Learn AWS", "https://aws.amazon.com/training/"),
				new Course("Learn Azure", "https://learn.microsoft.com/en-us/training/"),
				new Course("Learn GCP", "https://cloud.google.com/training")
		));
		
	}
	
	

}
