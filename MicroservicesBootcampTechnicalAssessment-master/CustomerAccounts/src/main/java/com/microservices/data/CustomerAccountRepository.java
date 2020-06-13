package com.microservices.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.microservices.domain.CustomerAccount;

@RestResource(path="customerAccounts", rel="customerAccount")
public interface CustomerAccountRepository extends CrudRepository<CustomerAccount, String> {
  
	
}
