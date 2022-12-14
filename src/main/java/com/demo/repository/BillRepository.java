package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.pojo.Bill;
import com.demo.pojo.Consumer;

//Generate bills for an year: /admin/getBillsByYear/{year} 
@Repository
public interface BillRepository extends CrudRepository<Bill, Integer>{
	
	@Query(value = "select * from Bill where year=:year", nativeQuery = true)
	List<Bill> findAllByYear(@Param("year") int year);
	
//	consumerid
//	consumer name
//	area
//	city
//	connectype
//	total amount
//	year
//	month
//	bill id
	
}
