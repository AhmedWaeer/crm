package com.ahmedwaeer.crmsystem.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ahmedwaeer.crmsystem.exceptions.CustomerServiceException;
import com.ahmedwaeer.crmsystem.service.Impl.CallHandlingService;
import com.ahmedwaeer.crmsystem.service.Impl.CustomerService;
import com.ahmedwaeer.crmsystem.service.Impl.DairyManagementService;
import com.ahmedwaeer.crmsystem.shared.dto.ActionDto;
import com.ahmedwaeer.crmsystem.shared.dto.CallDto;
import com.ahmedwaeer.crmsystem.shared.dto.CustomerDto;
import com.ahmedwaeer.crmsystem.ui.model.request.CallRequestModel;
import com.ahmedwaeer.crmsystem.ui.model.request.CustomerDetailsRequestModel;
import com.ahmedwaeer.crmsystem.ui.model.response.ActionRepresenation;
import com.ahmedwaeer.crmsystem.ui.model.response.CustomerRepresentation;
import com.ahmedwaeer.crmsystem.ui.model.request.UserDetailsRequestModel;
import com.ahmedwaeer.crmsystem.ui.model.response.ActionRepresenation;
import com.ahmedwaeer.crmsystem.ui.model.response.CustomerRepresenation;
import com.ahmedwaeer.crmsystem.ui.model.response.ErrorMessages;
import com.ahmedwaeer.crmsystem.ui.model.response.OperationStatusModel;
import com.ahmedwaeer.crmsystem.ui.model.response.RequestOperationName;
import com.ahmedwaeer.crmsystem.ui.model.response.RequestOperationStatus;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private CallHandlingService CallService;
	@Autowired
	private DairyManagementService dairyService;


	@ApiOperation(value = "The Get Customer Details Web Service Endpoint", notes = "${CustomerController.GetCustomer.ApiOperation.Notes}")
	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public CustomerRepresentation getCustomer(@PathVariable String id) {
		ModelMapper modelMapper = new ModelMapper();
		CustomerDto customerDto = customerService.getCustomerById(id);
		CustomerRepresentation returnValue = modelMapper.map(customerDto, CustomerRepresentation.class);
	
	@ApiOperation(value="The Get Customer Details Web Service Endpoint",
			notes="${CustomerController.GetCustomer.ApiOperation.Notes}")
	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public CustomerRepresenation getCustomer(@PathVariable String id) {
		ModelMapper modelMapper = new ModelMapper();
		CustomerDto customerDto = customerService.getCustomerById(id);
		CustomerRepresenation returnValue = modelMapper.map(customerDto, CustomerRepresenation.class);

		return returnValue;

	}

	@ApiOperation(value = "The create Customer Details Web Service Endpoint")
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public CustomerRepresentation creatCustomer(@RequestBody CustomerDetailsRequestModel userDetails) throws Exception {

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public CustomerRepresenation creatCustomer(@RequestBody UserDetailsRequestModel userDetails) throws Exception {

		if (userDetails.getCompanyName().isEmpty())
			throw new CustomerServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
		ModelMapper modelMapper = new ModelMapper();
		CustomerDto customerDto = modelMapper.map(userDetails, CustomerDto.class);
		CustomerDto createdCustomer = customerService.createCustomer(customerDto);
		CustomerRepresentation returnValue = modelMapper.map(createdCustomer, CustomerRepresentation.class);
		CustomerRepresenation returnValue = modelMapper.map(createdCustomer, CustomerRepresenation.class);


		return returnValue;
	}

	@ApiOperation(value = "The update Customer Details Web Service Endpoint")
	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public CustomerRepresentation updateCustomer(@PathVariable String id,
			@RequestBody CustomerDetailsRequestModel userDetails) {
		ModelMapper modelMapper = new ModelMapper();
		CustomerDto customerDto = modelMapper.map(userDetails, CustomerDto.class);
		CustomerDto updatedCustomer = customerService.updateCustomer(id, customerDto);
		CustomerRepresentation returnValue = modelMapper.map(updatedCustomer, CustomerRepresentation.class);

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public CustomerRepresenation updateCustomer(@PathVariable String id,
			@RequestBody UserDetailsRequestModel userDetails) {
		ModelMapper modelMapper = new ModelMapper();
		CustomerDto customerDto = modelMapper.map(userDetails, CustomerDto.class);
		CustomerDto updatedCustomer = customerService.updateCustomer(id, customerDto);
		CustomerRepresenation returnValue = modelMapper.map(updatedCustomer, CustomerRepresenation.class);


		return returnValue;
	}


	@ApiOperation(value = "The delete Customer Details Web Service Endpoint")
	@DeleteMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public OperationStatusModel deleteCustomer(@PathVariable String id) {
		OperationStatusModel returnValue = new OperationStatusModel();
		returnValue.setOperationName(RequestOperationName.Delete.name());
		returnValue.setOperationResult(RequestOperationStatus.Success.name());
		customerService.deleteCustomer(id);

		return returnValue;
	}

	@ApiOperation(value = "The Get all Customers Details Web Service Endpoint", notes = "${CustomerController.GetallCustomers.ApiOperation.Notes}")
	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<CustomerRepresentation> getAllCustomers(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "limit", defaultValue = "25") Integer limit) {
		ModelMapper modelMapper = new ModelMapper();
		List<CustomerRepresentation> returnValue = new ArrayList<>();
		List<CustomerDto> customers = customerService.getAllCustomers(page, limit);
		for (CustomerDto next : customers) {
			CustomerRepresentation customerModel = modelMapper.map(next, CustomerRepresentation.class);

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<CustomerRepresenation> getAllCustomers(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "limit", defaultValue = "25") Integer limit) {
		ModelMapper modelMapper = new ModelMapper();
		List<CustomerRepresenation> returnValue = new ArrayList<>();
		List<CustomerDto> customers = customerService.getAllCustomers(page, limit);
		for (CustomerDto next : customers) {
			CustomerRepresenation customerModel = modelMapper.map(next, CustomerRepresenation.class);
			returnValue.add(customerModel);
		}

		return returnValue;

	}


	@ApiOperation(value = "The record business call Web Service Endpoint", notes = "${CustomerController.recordCall.ApiOperation.Notes}")
	@PostMapping(path = "/{id}/calls", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public OperationStatusModel recordBusinessCall(@PathVariable String id, @RequestBody CallRequestModel incomingCall)
			throws Exception {
		ModelMapper modelMapper = new ModelMapper();
		CallDto newCall = modelMapper.map(incomingCall, CallDto.class);
		CallService.recordcall(id, newCall);
		OperationStatusModel returnValue = new OperationStatusModel();
		returnValue.setOperationName(RequestOperationName.record.name());
		returnValue.setOperationResult(RequestOperationStatus.Success.name());

		return returnValue;
	}


	@ApiOperation(value = "The Get all incomplete actions for specific customer Web Service Endpoint", notes = "${CustomerController.getactions.ApiOperation.Notes}")
	@GetMapping(path = "/{id}/actions", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<ActionRepresenation> getIncompleteActionsForCustomer(@PathVariable String id) {
		List<ActionRepresenation> returnValue = new ArrayList<>();
		List<ActionDto> actions = dairyService.getAllIncompleteActions(id);
		for (ActionDto foundAction : actions) {
			ActionRepresenation action = new ModelMapper().map(foundAction, ActionRepresenation.class);
			returnValue.add(action);
		}

		return returnValue;

	}

}
