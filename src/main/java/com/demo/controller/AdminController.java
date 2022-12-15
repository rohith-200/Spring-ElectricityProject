package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pojo.Bill;
import com.demo.repository.BillRepository;

@RestController
public class AdminController {
	
	@Autowired
	BillRepository billRepository;
	
	@GetMapping("/Admin/getBillsByYear/{year}")
	public List<Bill> getBillsByYear(@PathVariable int year) {
		if((billRepository.findAllByYear(year)).isEmpty()) {
			return null;
		}else {
			return billRepository.findAllByYear(year);
		}
	}
	
	@GetMapping("/Admin/getBillsByMonth/{month}/{year}")
	public List<Bill> getBillsByYear(@PathVariable String month, @PathVariable int year) {
		if((billRepository.findAllByMonth(month, year)).isEmpty()) {
			return null;
		}else {
			return billRepository.findAllByMonth(month, year);
		}
	}

}
