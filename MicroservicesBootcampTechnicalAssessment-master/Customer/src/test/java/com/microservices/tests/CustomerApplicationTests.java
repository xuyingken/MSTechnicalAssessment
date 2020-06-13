package com.microservices.tests;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.domain.CustomerAccount;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerApplicationTests {

	@Autowired
	private MockMvc mockMvc;

		
		@Test
		public void testCustomerGet() throws Exception {
			mockMvc.perform(MockMvcRequestBuilders.get("/customers/account/1")).andExpect(status().isOk()).
			andExpect(MockMvcResultMatchers.jsonPath("$.customerId").exists());;
		  
		}
		
		@Test
		public void testCustomerPost() throws Exception {
			mockMvc.perform( MockMvcRequestBuilders
				      .post("/customers/account")
				      .content(asJsonString(new CustomerAccount("12345678", "My Account", "Current", "100.00","SGD","1")))
				      .contentType(MediaType.APPLICATION_JSON)
				      .accept(MediaType.APPLICATION_JSON))
				      .andExpect(status().isCreated());
		  
		}
		
		public static String asJsonString(final Object obj) {
		    try {
		        return new ObjectMapper().writeValueAsString(obj);
		    } catch (Exception e) {
		        throw new RuntimeException(e);
		    }
		}

}
