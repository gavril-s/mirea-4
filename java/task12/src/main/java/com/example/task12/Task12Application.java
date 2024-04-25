package com.example.task12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Task12Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Task12Application.class, args);
		FileProcessor fileProcessor = context.getBean(FileProcessor.class);
	}
}