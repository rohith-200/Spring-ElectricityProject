package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/consumer/getBillsByMonth/{consumer_id}/{year}/{month}")
	public List<Bill> getBillsByMonth(@PathVariable String month, @PathVariable int year, @PathVariable Consumer consumerId) {
		if((billRepository.getBillsByMonth(month, year,consumerId)).isEmpty()) {
			return null;
		}else {
			return billRepository.getBillsByMonth(month, year, consumerId);
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
