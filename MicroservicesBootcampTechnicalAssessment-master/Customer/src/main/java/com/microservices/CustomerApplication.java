package com.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootApplication
public class CustomerApplication {
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	

}
