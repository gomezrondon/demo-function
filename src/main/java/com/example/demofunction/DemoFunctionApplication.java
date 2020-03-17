package com.example.demofunction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class DemoFunctionApplication {

	@Bean
	public Function<String, String> uppercase(){
		return name -> name.toUpperCase();
	}

	@Bean
	public Function<Person, String> upperCaseName(){
		return Person -> Person.getName().toUpperCase();
	}

	@Bean
	public Supplier< String> time(){
		return () -> LocalDateTime.now().toString();
	}

	@Bean
	public Function<String, String> reverse(){
		return text -> new StringBuilder(text).reverse().toString();
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoFunctionApplication.class, args);
	}
}
