package com.ahmedwaeer.crmsystem.repository;



import org.springframework.data.repository.CrudRepository;

import com.ahmedwaeer.crmsystem.entity.CallEntity;

public interface CallRepository extends CrudRepository<CallEntity,Long> {
	CallEntity findBycallId(String callId);
 
}
