package com.ahmedwaeer.crmsytem.service.Impl;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ahmedwaeer.crmsystem.entity.CustomerEntity;
import com.ahmedwaeer.crmsystem.exceptions.CustomerServiceException;
import com.ahmedwaeer.crmsystem.repository.CustomerRepository;
import com.ahmedwaeer.crmsystem.service.Impl.CustomerServiceImpl;
import com.ahmedwaeer.crmsystem.shared.dto.CustomerDto;
import com.ahmedwaeer.crmsystem.util.Util;

class CustomerServiceImplTest {
	
	@InjectMocks
	CustomerServiceImpl customerService;

	@Mock
	CustomerRepository customerRepository;
	@Mock
	Util util;
	
	String customerId ="abc-123=2021";
	CustomerEntity customerEntity;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		customerEntity =new CustomerEntity();
		customerEntity.setId(1L);
		customerEntity.setCompanyName("ameen");
		customerEntity.setCustomerId(customerId);
		customerEntity.setEmail("ameen@gmail.com");
		customerEntity.setTelephone("0178994403");
	}

	@Test
	void testGetCustomerById() {

		when( customerRepository.findBycustomerId( anyString()) ).thenReturn(customerEntity);
		CustomerDto customer = customerService.getCustomerById("ABS-123-2122");
		assertNotNull(customer);
		assertEquals("ameen", customer.getCompanyName());
	}
	@Test
	void testGetCustomerById_CustomerServiceException() {
		
		when( customerRepository.findBycustomerId( anyString()) ).thenReturn(null);
		assertThrows(CustomerServiceException.class,
				
				()->{
					
					customerService.getCustomerById("ABS-123-2122");
				}
							
				);
	
	}
	
	@Test
	void testcreateCustomer() {
		
	
		when( customerRepository.findByemail( anyString()) ).thenReturn(null);
		when( util.generateUserId( anyInt()) ).thenReturn(customerId);
		when( customerRepository.save(any(CustomerEntity.class)) ).thenReturn(customerEntity);
		CustomerDto customerDto = new CustomerDto();
		CustomerDto storedValue = customerService.createCustomer(customerDto);
		assertNotNull(storedValue);
		assertEquals(customerEntity.getCompanyName(), storedValue.getCompanyName());
		assertNotNull(storedValue.getCustomerId());

}
}
