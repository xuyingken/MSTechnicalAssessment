package com.microservices.controller;


import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.data.CustomerAccountRepository;
import com.microservices.domain.CustomerAccount;
import com.microservices.domain.CustomerAccountInput;

@RestController
public class CustomerAccountController {
	
	@Autowired CustomerAccountRepository repository;
	
	@GetMapping("/customerAccounts/{customerId}")
	public CustomerAccount getCustomer(@PathVariable String customerId) {	
		  CustomerAccount ac  = repository.findById(customerId).get();
	      return ac;
		
	}
	
	@PostMapping("/customerAccounts/update")
	public ResponseEntity<Object> updateCustomer(@Valid @RequestBody CustomerAccountInput input) {
		
		 CustomerAccount ac = repository.findById("1").get(); // only get Customer ID =1
		 ac.setAccountName(input.getAccountName());
		 ac.setAccountType(input.getAccountType());
		 ac.setCurrency(input.getCurrency());
		 repository.save(ac);
	     Map<String, Object> body = new LinkedHashMap<>();
	     body.put("status", "Success");
	     body.put("customerId", ac.getCustomerId() );
	     
	     return new ResponseEntity<>(body, HttpStatus.OK);
	     
	}
	
}
