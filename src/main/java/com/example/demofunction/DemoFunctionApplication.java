package com.example.demofunction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class DemoFunctionApplication {

	@Bean
	public Function<String, String> upperCase(){
		return name -> name.toUpperCase();
	}

	@Bean
	public Function<Person, String> upperCaseName(){
		return Person -> Person.getName().toUpperCase();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoFunctionApplication.class, args);
	}
}
