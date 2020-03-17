package com.example.demofunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
@EnableFeignClients
public class DemoFunctionApplication {

	@Autowired
	private NameService nameService;

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
	public Supplier< String> gettime2(){
		return () -> nameService.getTime();
	}

	@Bean
	public Function<String, String> reverse(){
		return text -> new StringBuilder(text).reverse().toString();
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoFunctionApplication.class, args);
	}
}
