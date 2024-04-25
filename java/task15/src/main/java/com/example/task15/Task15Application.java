package com.example.task15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.task15"})
public class Task15Application {
	public static void main(String[] args) {
		SpringApplication.run(Task15Application.class, args);
	}
}
