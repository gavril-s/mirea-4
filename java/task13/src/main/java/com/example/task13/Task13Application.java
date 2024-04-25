package com.example.task13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class Task13Application implements CommandLineRunner {
	@Value("${student.name}")
	private String studentName;

	@Value("${student.last_name}")
	private String studentLastName;

	@Value("${student.group}")
	private String studentGroup;

	public static void main(String[] args) {
		SpringApplication.run(Task13Application.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Student Name: " + studentName);
		System.out.println("Student Last Name: " + studentLastName);
		System.out.println("Student Group: " + studentGroup);
	}
}
