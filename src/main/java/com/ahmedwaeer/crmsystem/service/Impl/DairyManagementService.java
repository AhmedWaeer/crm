package com.ahmedwaeer.crmsystem.service.Impl;

import java.util.List;

import com.ahmedwaeer.crmsystem.shared.dto.ActionDto;

public interface DairyManagementService {
	
	List<ActionDto> getAllIncompleteActions(String customerId);

}
