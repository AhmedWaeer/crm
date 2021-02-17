package com.ahmedwaeer.crmsystem.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.ahmedwaeer.crmsystem.entity.CustomerEntity;
import com.ahmedwaeer.crmsystem.exceptions.CustomerServiceException;
import com.ahmedwaeer.crmsystem.repository.CustomerRepository;
import com.ahmedwaeer.crmsystem.entity.CallEntity;
import com.ahmedwaeer.crmsystem.entity.CustomerEntity;
import com.ahmedwaeer.crmsystem.exceptions.CustomerServiceException;
import com.ahmedwaeer.crmsystem.repository.CallRepository;
import com.ahmedwaeer.crmsystem.repository.CustomerRepository;
import com.ahmedwaeer.crmsystem.shared.dto.CallDto;
import com.ahmedwaeer.crmsystem.shared.dto.CustomerDto;
import com.ahmedwaeer.crmsystem.ui.model.response.ErrorMessages;
import com.ahmedwaeer.crmsystem.util.Util;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Autowired
	Util util;

	@Override
	public CustomerDto createCustomer(CustomerDto newCustomer) {

		if (customerRepository.findByemail(newCustomer.getEmail()) != null)
			throw new CustomerServiceException(ErrorMessages.RECORD_ALREADY_EXISTS.getErrorMessage());
		ModelMapper modelMapper = new ModelMapper();
		CustomerEntity customerEntity = modelMapper.map(newCustomer, CustomerEntity.class);
		String publicCustomerId = util.generateUserId(8);
		customerEntity.setCustomerId(publicCustomerId);
		CustomerEntity storedCustomerDetails = customerRepository.save(customerEntity);
		CustomerDto returnedValue = modelMapper.map(storedCustomerDetails, CustomerDto.class);

		return returnedValue;
	}

	@Override
	public CustomerDto getCustomerById(String customerId) {

		ModelMapper modelMapper = new ModelMapper();
		CustomerEntity customerEntity = customerRepository.findBycustomerId(customerId);
		if (customerEntity == null)
			throw new CustomerServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		CustomerDto returnedValue = modelMapper.map(customerEntity, CustomerDto.class);

		return returnedValue;
	}

	@Override
	public CustomerDto updateCustomer(String customerId, CustomerDto updatedCustomer) {
		ModelMapper modelMapper = new ModelMapper();

		CustomerEntity customerEntity = customerRepository.findBycustomerId(customerId);
		if (customerEntity == null)
			throw new CustomerServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		if (updatedCustomer.getCompanyName() != null)
			customerEntity.setCompanyName(updatedCustomer.getCompanyName());
		if (updatedCustomer.getEmail() != null)
			customerEntity.setEmail(updatedCustomer.getEmail());
		if (updatedCustomer.getTelephone() != null)
			customerEntity.setTelephone(updatedCustomer.getTelephone());
		CustomerEntity updatedCustomerDetails = customerRepository.save(customerEntity);
		CustomerDto returnedValue = modelMapper.map(updatedCustomerDetails, CustomerDto.class);

		return returnedValue;
	}

	@Override
	public void deleteCustomer(String customerId) {
		CustomerEntity customerEntity = customerRepository.findBycustomerId(customerId);
		if (customerEntity == null)
			throw new CustomerServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		customerRepository.delete(customerEntity);
	}

	@Override
	public List<CustomerDto> getAllCustomers(int page, int limit) {
		List<CustomerDto> returnValue = new ArrayList<>();
		if (page > 0)
			page = page - 1;
		Pageable pagableRequest = PageRequest.of(page, limit);
		Page<CustomerEntity> customerpage = customerRepository.findAll(pagableRequest);
		List<CustomerEntity> customers = customerpage.getContent();
		for (CustomerEntity customerEntity : customers) {
			CustomerDto result = new CustomerDto();
			BeanUtils.copyProperties(customerEntity, result);
			returnValue.add(result);
		}
		return returnValue;
	}

	}

