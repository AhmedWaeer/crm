package com.ahmedwaeer.crmsystem.service.Impl;

import java.util.List;
import com.ahmedwaeer.crmsystem.shared.dto.CustomerDto;

public interface CustomerService {

	CustomerDto createCustomer(CustomerDto newCustomer); 
	CustomerDto getCustomerById(String customerId);
	CustomerDto updateCustomer(String customerId,CustomerDto updatedCustomer);
	void deleteCustomer(String customerId);
	List<CustomerDto> getAllCustomers(int page, int limit);







}
