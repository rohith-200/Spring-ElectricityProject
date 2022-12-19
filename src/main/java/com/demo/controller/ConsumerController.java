package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exceptions.BillNotFoundException;
import com.demo.exceptions.ConnectionTypeNotFound;
import com.demo.exceptions.ConsumerNotFoundException;
import com.demo.pojo.Bill;
import com.demo.pojo.Consumer;
import com.demo.repository.BillRepository;
import com.demo.repository.ConsumerRepository;


@RestController
public class ConsumerController {

	@Autowired
	BillRepository billRepository;
	@Autowired
	ConsumerRepository consumerRepository;
	
	@GetMapping("/consumer/getBillsByMonth")
	public List<Bill> getBillsByMonth(@RequestParam("month") String month, @RequestParam("year") int year,@RequestParam("consumerId") int consumerId) throws BillNotFoundException {
		List<Bill> bills = billRepository.getBillsByMonth(month, year, consumerId);
		if(bills.isEmpty()) {
			throw new BillNotFoundException("Bill Not Found!! for these values");
		}else {
			return bills;
		}
	}
	
	@GetMapping("/consumer/getBillsByYear")
	public List<Bill> getBillsByYear(@RequestParam("year") int year,@RequestParam("consumerId") int consumerId) throws BillNotFoundException {
		List<Bill> bills = billRepository.getBillsByYear(year, consumerId);
		if(bills.isEmpty()) {
			throw new BillNotFoundException("Bill Not Found!! for these values");
		}else {
			return bills;
		}
	}
	
	@GetMapping("/consumer/getAllBills")
	public List<Bill> getAllBills(@RequestParam int consumerId) throws BillNotFoundException {
		List<Bill> bills = billRepository.getAllBills(consumerId);
		if(bills.isEmpty()) {
			throw new BillNotFoundException("Bill Not Found!! for these values");
		}else {
			return bills;
		}
	}
	
	@PostMapping("/consumer/register")
	public void addConsumer(@RequestBody Consumer c)  {
			consumerRepository.save(c);
		
	}
	
	@PostMapping("/consumer/updateConsumerDetails")
	public String updateConsumer(@RequestParam String consumerName,@RequestParam String area,@RequestParam String city,@RequestParam String connectionType,@RequestParam int consumerId) throws ConsumerNotFoundException{
		Consumer c  = consumerRepository.findById(consumerId).orElse(null);
		if(c == null)
			throw new ConsumerNotFoundException("Consumer Not Found!!");
		else {
			consumerRepository.updateByConsumerId(consumerName, area, city, connectionType, consumerId);
		}
		
		return "Consumer Details Updated Successfully!!";
	}
	
	@DeleteMapping("/consumer/deleteConsumerById")
	public String deleteConsumer(@RequestParam int consumerId) throws ConsumerNotFoundException {
		Consumer c  = consumerRepository.findById(consumerId).orElse(null);
		if(c == null)
			throw new ConsumerNotFoundException("Consumer Not Found!!");
		else {
			consumerRepository.deleteById(c.getConsumerId());
		}
		return "Consumer Details Deleted Successfully!!";
	}
	
	
}
