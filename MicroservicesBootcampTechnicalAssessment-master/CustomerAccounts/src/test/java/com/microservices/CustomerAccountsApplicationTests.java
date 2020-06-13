package com.microservices;

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
import com.microservices.domain.CustomerAccountInput;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerAccountsApplicationTests {

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void testCustomerGet() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/customerAccounts/1")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.customerId").exists());

	}

	@Test
	public void testCustomerPost() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/customerAccounts/update")
				.content(asJsonString(new CustomerAccountInput("My Account", "Current", "SGD")))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.customerId").exists());

	}

	@Test
	public void testCustomerPostNegative1() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/customerAccounts/update")
				.content(asJsonString(new CustomerAccountInput("My @Account", "Current", "SGD")))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());

	}

	@Test
	public void testCustomerPostNegative2() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/customerAccounts/update")
				.content(asJsonString(new CustomerAccountInput("123456", "Current", "SGD")))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
