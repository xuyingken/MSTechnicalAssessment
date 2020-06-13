package com.microservices.controller;


import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.microservices.domain.Customer;
import com.microservices.domain.CustomerAccount;
import com.microservices.domain.CustomerAccountInput;

@RestController
public class CustomerController {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Bean
	RestTemplate restTemplate(){
	    return new RestTemplate();
	 }
	@Autowired
	RestTemplate rt;
	
	 @Value("${localCustomerEndpoint}")
	 private String localCustomerEndpoint; 
	
	
	
	@GetMapping("/customers/account/{customerId}")
	public Customer getCustomer(@PathVariable String customerId) {	
		String customerEndpoint = System.getenv().getOrDefault("CUSTOMER_ENDPOINT",localCustomerEndpoint);
		CustomerAccount ac
		  =this.rt.getForObject(customerEndpoint+"/customerAccounts/"+customerId, CustomerAccount.class);
		 
		Customer c = new Customer ();
		c.setAccountName(ac.getAccountName());
		c.setAccountType(ac.getAccountType());
		c.setBalance(ac.getBalance());
		c.setCurrency(ac.getCurrency());
		c.setCustomerId(ac.getCustomerId());
		
		
	      return c;
		
	}
	
	@PostMapping("/customers/account")
	public ResponseEntity<Object>  updateCustomer(@RequestBody CustomerAccount c) {
		 Map<String, Object> body = new LinkedHashMap<>();
		
		 CustomerAccountInput ci =new CustomerAccountInput();
		 ci.setAccountName(c.getAccountName());
		 ci.setAccountType(c.getAccountType());
		 ci.setCurrency(c.getCurrency());
		 
		 String customerEndpoint = System.getenv().getOrDefault("CUSTOMER_ENDPOINT",localCustomerEndpoint);
		 
		 try{
			 this.rt.postForEntity(customerEndpoint+"/customerAccounts/update", ci, String.class);
		 }
		 catch (Exception ex) {
			 
			 body.put("Status", "Failed");
			 body.put("Error Code", "CLIENT_ERR001");
		     body.put("Server Error Description",  ex.getMessage());
		     return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	  
	      
	    body.put("Status", "Success");
	    return new ResponseEntity<>(body, HttpStatus.CREATED);
	     
	}
	
}
