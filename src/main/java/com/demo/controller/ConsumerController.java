package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Bill> getBillsByMonth(@RequestParam("month") String month, @RequestParam("year") int year,@RequestParam("consumerId") int consumerId) {
		List<Bill> bills = billRepository.getBillsByMonth(month, year, consumerId);
		if(bills.isEmpty()) {
			System.out.println(bills);
			return null;
		}else {
			return bills;
		}
	}
	
	@GetMapping("/consumer/getBillsByYear")
	public List<Bill> getBillsByYear(@RequestParam("year") int year,@RequestParam("consumerId") int consumerId) {
		List<Bill> bills = billRepository.getBillsByYear(year, consumerId);
		if(bills.isEmpty()) {
			System.out.println(bills);
			return null;
		}else {
			return bills;
		}
	}
	
	@GetMapping("/consumer/getAllBills")
	public List<Bill> getAllBills(@RequestParam("consumerId") int consumerId) {
		List<Bill> bills = billRepository.getAllBills(consumerId);
		if(bills.isEmpty()) {
			System.out.println(bills);
			return null;
		}else {
			return bills;
		}
	}
//	@GetMapping("/consumer/getBillsByYear/{consumer_id}/{year}")
//	public List<Bill> getBillsByYear(@PathVariable int year, @PathVariable int consumerId) {
//		if((billRepository.getBillsByYear(year,consumerId)).isEmpty()) {
//			return null;
//		}else {
//			return billRepository.getBillsByYear(year,consumerId);
//		}
//	}
	
	
}
