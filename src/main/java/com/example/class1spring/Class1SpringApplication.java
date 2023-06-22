package com.example.class1spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Class1SpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(Class1SpringApplication.class, args);
	}

}
