package com.ahmedwaeer.crmsystem.service.Impl;

import java.util.List;

import com.ahmedwaeer.crmsystem.entity.CallEntity;
import com.ahmedwaeer.crmsystem.shared.dto.CallDto;

public interface CallHandlingService {

	CallDto recordcall(String customerId, CallDto newCall);
	void recordcall(String customerId, CallDto newCall);
	List<CallEntity> getAllcallsforcustomerById(String customerId);

}
