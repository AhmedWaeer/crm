package com.ahmedwaeer.crmsystem.repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.ahmedwaeer.crmsystem.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<CustomerEntity,Long> {
	CustomerEntity findByemail(String email);
	CustomerEntity findBycustomerId(String customerId);
	
}
