package com.ahmedwaeer.crmsystem.service.Impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ahmedwaeer.crmsystem.entity.ActionEntity;
import com.ahmedwaeer.crmsystem.entity.CallEntity;
import com.ahmedwaeer.crmsystem.shared.dto.ActionDto;
import com.ahmedwaeer.crmsystem.shared.dto.CallDto;

@Service
public class DairyManagmentServiceImpl implements DairyManagementService {

	@Autowired
	CallHandlingService callservice;

	@Override
	public List<ActionDto> getAllIncompleteActions(String customerId) {

		List<ActionDto> returnValue = new ArrayList<>();
		List<CallDto> calls = new ArrayList<>();
		List<CallEntity> foundCalls = callservice.getAllcallsforcustomerById(customerId);
		Type listType = new TypeToken<List<CallEntity>>() {
		}.getType();
		calls = new ModelMapper().map(foundCalls, listType);
		for (CallDto call : calls) {
			List<ActionDto> foundActions = call.getActions();
			for (ActionDto action : foundActions) {
				returnValue.add(action);
			}

		}

		return returnValue;
	}
}
