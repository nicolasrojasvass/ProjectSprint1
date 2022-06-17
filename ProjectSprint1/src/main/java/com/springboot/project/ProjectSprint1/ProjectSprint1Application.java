package com.springboot.project.ProjectSprint1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class ProjectSprint1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSprint1Application.class, args);
	}

}
