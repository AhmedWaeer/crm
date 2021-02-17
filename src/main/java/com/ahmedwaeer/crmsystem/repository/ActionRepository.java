package com.ahmedwaeer.crmsystem.repository;
import org.springframework.data.repository.CrudRepository;
import com.ahmedwaeer.crmsystem.entity.ActionEntity;
import org.springframework.data.repository.CrudRepository;
import com.ahmedwaeer.crmsystem.entity.ActionEntity;


public interface ActionRepository extends CrudRepository<ActionEntity,Long> {

	ActionEntity findByactionId(String actionId);

}
