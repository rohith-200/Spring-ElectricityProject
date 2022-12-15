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
	
	@Query(value = "select * from Bill where year=?", nativeQuery = true)
	List<Bill> findAllByYear(int year);
	
	@Query(value=" SELECT * FROM Bill WHERE month=:month && year=:year", nativeQuery = true)
	List<Bill> findAllByMonth(@Param("month") String month, @Param("year") int year);
	
	@Query(value = "Select * from Bill join Consumer on Bill.consumer_id = Consumer.consumer_id where Consumer.area=?", nativeQuery = true)
	List<Bill> findBillsByArea(String area);

	@Query(value = "select * from Bill join Consumer on Bill.consumer_id = Consumer.consumer_id where Consumer.city=?", nativeQuery = true)
	List<Bill> findBillsByCity(String city);
	
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
