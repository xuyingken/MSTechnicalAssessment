package com.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.microservices.data.CustomerAccountRepository;
import com.microservices.domain.CustomerAccount;

@SpringBootApplication
public class CustomerAccountsApplication {

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(CustomerAccountsApplication.class, args);
	}

	@Bean
	  public CommandLineRunner demo(CustomerAccountRepository repository) {
	    return (args) -> {
	      // save a few customers
	      repository.save(new CustomerAccount("12345678","My Account","Current","100","SGD","1"));
	     
	    };
	  }
}