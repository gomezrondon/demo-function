package com.example.demofunction;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.hateoas.CollectionModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
@EnableFeignClients
public class DemoFunctionApplication {

	@Autowired
	private NameService nameService;

	@Autowired
    private CarClient carClient;

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


	public Collection<Car> fallbackGetCars() {
		return new ArrayList<Car>();
	}

    @Bean
	@HystrixCommand(fallbackMethod = "fallbackGetCars")
    Supplier<Collection<Car>> getcars() {
	    return () -> carClient.getCars()
				.getContent();
    }


	@Bean
	public Function<String, String> reverse(){
		return text -> new StringBuilder(text).reverse().toString();
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoFunctionApplication.class, args);
	}
}

@Data
class Car{
    private String name;

}

@FeignClient(url = "http://localhost:8090", name = "car-service")
interface CarClient{

    @GetMapping("/cars")
	CollectionModel<Car> getCars();
}