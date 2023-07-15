package com.bank.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.bank.web.service.BankService;




@WebMvcTest(controllers = BankController.class)
class BankControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BankService iBank;
	
	
	@Test
	public void testConsultAccount() throws Exception{
		
		mockMvc.perform(get("http://localhost:8080/bank/consultAccount")).andExpect(status().isOk());
		
	}
	
	

}
