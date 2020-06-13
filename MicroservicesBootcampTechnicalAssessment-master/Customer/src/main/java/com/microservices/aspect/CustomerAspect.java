package com.microservices.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.microservices.domain.Customer;
import com.microservices.domain.CustomerAccount;


@Aspect
@Component
public class CustomerAspect {

private static final Logger log = LoggerFactory.getLogger(CustomerAspect.class);
	
	@Before(value = "execution(* com.microservices.controller.CustomerController.getCustomer(..)) and args(customerId)")
	public void beforeAdvice(JoinPoint joinPoint, String customerId) {
		
		log.info("Before method:" + joinPoint.getSignature());
		log.info("Finding Customer with customerId("+customerId+")");

	}
	

	@AfterReturning(value = "execution(* com.microservices.controller.CustomerController.getCustomer(..)) and args(customerId)",
			returning = "result")
	public void afterAdvice(JoinPoint joinPoint,  String customerId, Customer result) {
		log.info("After method:" + joinPoint.getSignature());
		log.info("Found Customer with customerId("+customerId+"):");
		log.info("--------------------------------");
	    log.info(result.toString());
	    log.info("");
		
	}
	
	
	@Before(value = "execution(* com.microservices.controller.CustomerController.updateCustomer(..)) and args(input)")
	public void beforeAdvice(JoinPoint joinPoint, CustomerAccount input) {
		
		log.info("Before method:" + joinPoint.getSignature());
		log.info("Updating Customer with customerId(1)");

	}

	@AfterReturning(value = "execution(* com.microservices.controller.CustomerController.updateCustomer(..)) and args(input)")
	public void afterAdvice(JoinPoint joinPoint,  CustomerAccount input) {
		log.info("After method:" + joinPoint.getSignature());
		log.info("Updated Customer with customerId(1)");
		log.info("--------------------------------");
		log.info(input.toString());
	    log.info("");
	}

}
