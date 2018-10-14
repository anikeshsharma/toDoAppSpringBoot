package com.anikesh.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class ToDoStarterApplication {

	private static final Logger LOG = LoggerFactory.getLogger(ToDoStarterApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ToDoStarterApplication.class, args);
		LOG.debug("-----To Do Application Started-----");
	}
}
