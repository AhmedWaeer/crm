package com.ahmedwaeer.crmsytem.service.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import com.ahmedwaeer.crmsystem.entity.ActionEntity;
import com.ahmedwaeer.crmsystem.entity.CallEntity;
import com.ahmedwaeer.crmsystem.entity.CustomerEntity;
import com.ahmedwaeer.crmsystem.repository.CallRepository;
import com.ahmedwaeer.crmsystem.repository.CustomerRepository;
import com.ahmedwaeer.crmsystem.service.Impl.CallHandlingServiceImpl;
import com.ahmedwaeer.crmsystem.service.Impl.CustomerService;
import com.ahmedwaeer.crmsystem.shared.dto.ActionDto;
import com.ahmedwaeer.crmsystem.shared.dto.CallDto;
import com.ahmedwaeer.crmsystem.util.Util;

class CallHandlingServiceImplTest {

	@InjectMocks
	CallHandlingServiceImpl CallService;
	@Mock
	CustomerService customerService;
	@Mock
	private CustomerRepository customerRepository;
	@Mock
	private CallRepository callRepository;
	@Mock
	Util util;
	String customerId = "abc-123=2021";
	String callId = "abdc123";
	CustomerEntity customerEntity;
	CallEntity callEntity;
	CallDto call;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		customerEntity = new CustomerEntity();
		customerEntity.setId(1L);
		customerEntity.setCompanyName("ameen");
		customerEntity.setCustomerId(customerId);
		List<CallEntity> calls = new ArrayList<>();
		calls.add(callEntity);
		customerEntity.setCalls(calls);
		customerEntity.addCall(callEntity);
		callEntity = new CallEntity();
		callEntity.setId(1L);
		callEntity.setCallId(callId);
		callEntity.setNotes("complaint");
		callEntity.setTimeAndDate(new Date());
		callEntity.setActions(getActionEntity());

	}

	@Test
	void testRecordcall() {

		when(customerRepository.findBycustomerId(anyString())).thenReturn(customerEntity);
		when(util.generateActionId(anyInt())).thenReturn("abddfc123");
		when(util.generateCallId(anyInt())).thenReturn(callId);
		when(callRepository.save(any(CallEntity.class))).thenReturn(callEntity);
		call = new CallDto();
		call.setActions(getActionDto());
		call.setCallId(callId);
		call.setNotes(callId);
		call.setTimeAndDate(new Date());
		CallDto recordedCall = CallService.recordcall(customerId, call);
		assertNotNull(recordedCall);
		assertNotNull(recordedCall.getCallId());
		assertEquals(recordedCall.getCallId(), callEntity.getCallId());
		assertEquals(recordedCall.getActions().size(), callEntity.getActions().size());

	}

	private List<ActionDto> getActionDto() {
		Calendar cal = Calendar.getInstance();
		List<ActionDto> actions = new ArrayList<>();
		ActionDto action1 = new ActionDto();
		action1.setComplete(false);
		action1.setDetails("call them urgently");
		action1.setRequiredBy(cal);
		ActionDto action2 = new ActionDto();
		action1.setComplete(false);
		action1.setDetails("call them tomorrow urgently");
		action1.setRequiredBy(cal);

		actions.add(action1);
		actions.add(action2);

		return actions;

	}

	private List<ActionEntity> getActionEntity() {
		List<ActionDto> actions = getActionDto();

		Type listType = new TypeToken<List<ActionEntity>>() {
		}.getType();

		return new ModelMapper().map(actions, listType);
	}

}
