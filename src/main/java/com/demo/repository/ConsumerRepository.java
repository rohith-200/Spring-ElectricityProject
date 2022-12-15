package com.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demo.pojo.Consumer;

public interface ConsumerRepository extends CrudRepository<Consumer, Integer> {
	
	@Query(value="Select * from Consumer where consumer_id= :id and password = :password", nativeQuery=true)
	Consumer validateConsumer(int id, String password);

}
