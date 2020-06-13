package com.microservices.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.microservices.domain.CustomerAccount;
import com.microservices.domain.CustomerAccountInput;

@Aspect
@Component
public class CustomerAccountsAspect {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerAccountsAspect.class);
	
	@Before(value = "execution(* com.microservices.controller.CustomerAccountController.getCustomer(..)) and args(customerId)")
	public void beforeAdvice(JoinPoint joinPoint, String customerId) {
		
		log.info("Before method:" + joinPoint.getSignature());
		log.info("Finding Customer Account with customerId("+customerId+")");

	}
	

	@AfterReturning(value = "execution(* com.microservices.controller.CustomerAccountController.getCustomer(..)) and args(customerId)",
			returning = "result")
	public void afterAdvice(JoinPoint joinPoint,  String customerId, CustomerAccount result) {
		log.info("After method:" + joinPoint.getSignature());
		log.info("Found Customer Account with customerId("+customerId+"):");
		log.info("--------------------------------");
	    log.info(result.toString());
	    log.info("");
		
	}
	
	
	@Before(value = "execution(* com.microservices.controller.CustomerAccountController.updateCustomer(..)) and args(input)")
	public void beforeAdvice(JoinPoint joinPoint, CustomerAccountInput input) {
		
		log.info("Before method:" + joinPoint.getSignature());
		log.info("Updating Customer Account with customerId(1)");

	}

	@AfterReturning(value = "execution(* com.microservices.controller.CustomerAccountController.updateCustomer(..)) and args(input)")
	public void afterAdvice(JoinPoint joinPoint,  CustomerAccountInput input) {
		log.info("After method:" + joinPoint.getSignature());
		log.info("Updated Customer Account with customerId(1)");
		log.info("--------------------------------");
		log.info(input.toString());
	    log.info("");
	}

}
