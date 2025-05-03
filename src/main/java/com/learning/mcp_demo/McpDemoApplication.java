package com.learning.mcp_demo;

import java.util.List;

import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbacks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McpDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpDemoApplication.class, args);
	}

	@Bean
	List<ToolCallback> toolCallBacks(CourseService courseService) {
		return List.of(ToolCallbacks.from(courseService));
	}
}
