package com.ahmedwaeer.crmsystem.service.Impl;


import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ahmedwaeer.crmsystem.entity.CallEntity;
import com.ahmedwaeer.crmsystem.entity.CustomerEntity;
import com.ahmedwaeer.crmsystem.repository.CallRepository;
import com.ahmedwaeer.crmsystem.repository.CustomerRepository;
import com.ahmedwaeer.crmsystem.shared.dto.ActionDto;
import com.ahmedwaeer.crmsystem.shared.dto.CallDto;
import com.ahmedwaeer.crmsystem.util.Util;

@Service
public class CallHandlingServiceImpl implements CallHandlingService {
	@Autowired
	CustomerService customerService;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CallRepository callRepository;
	@Autowired
	Util util;

	@Override
	public CallDto recordcall(String customerId, CallDto newCall) {
	public void recordcall(String customerId, CallDto newCall) {
		ModelMapper modelMapper = new ModelMapper();
		CustomerEntity foundCustomer = customerRepository.findBycustomerId(customerId);
		List<ActionDto> actions = newCall.getActions();
		List<ActionDto> listOfactions = new ArrayList<>();
		for (ActionDto action : actions) {
			action.setActionId(util.generateActionId(8));
			listOfactions.add(action);
			newCall.setActions(listOfactions);
		}
		CallEntity addedCall = modelMapper.map(newCall, CallEntity.class);
		addedCall.setCallId(util.generateCallId(8));
		foundCustomer.addCall(addedCall);
		CallEntity recordedCall = callRepository.save(addedCall);
		CallDto returnValue = modelMapper.map(recordedCall, CallDto.class);
		return returnValue;
		callRepository.save(addedCall);

	}

	@Override
	public List<CallEntity> getAllcallsforcustomerById(String customerId) {
		CustomerEntity foundCustomer = customerRepository.findBycustomerId(customerId);
		List<CallEntity> returnValue = foundCustomer.getCalls();

		return returnValue;
	}

}
