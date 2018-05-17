package com.example.demofunction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionScan;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
@FunctionScan
public class DemoFunctionApplication {

	@Bean
	public Function<String, String> upperCase(){
		return name -> name.toUpperCase();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoFunctionApplication.class, args);
	}
}
