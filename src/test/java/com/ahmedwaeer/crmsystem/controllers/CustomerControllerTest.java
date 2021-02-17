package com.ahmedwaeer.crmsystem.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.ahmedwaeer.crmsystem.service.Impl.CustomerServiceImpl;
import com.ahmedwaeer.crmsystem.shared.dto.CustomerDto;
import com.ahmedwaeer.crmsystem.ui.model.response.CustomerRepresentation;

class CustomerControllerTest {
	
	@InjectMocks
	CustomerController customerController;
	@Mock
	CustomerServiceImpl customerService;
	
	CustomerDto customerDto;
	String customerId = "abd-123-2021";

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		customerDto = new CustomerDto();
		customerDto.setCustomerId(customerId);
		customerDto.setCompanyName("Chevron");
		customerDto.setEmail("test@test.com");
		customerDto.setTelephone("0123333444");
	}

	@Test
	void testGetCustomer() {
		 when(customerService.getCustomerById(anyString())).thenReturn(customerDto);
		 CustomerRepresentation customerRep = customerController.getCustomer(customerId);
		 assertNotNull(customerRep);
		 assertEquals(customerId,customerRep.getCustomerId());
		 assertEquals(customerDto.getCompanyName(),customerRep.getCompanyName());

	}

	@Test
	void testGetIncompleteActionsForCustomer() {
		
	}

}
