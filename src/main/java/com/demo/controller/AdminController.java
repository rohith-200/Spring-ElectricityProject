package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exceptions.BillNotFoundException;
import com.demo.pojo.Admin;
import com.demo.pojo.Bill;
import com.demo.pojo.Consumer;
import com.demo.repository.AdminRepository;
import com.demo.repository.BillRepository;
import com.demo.repository.ConsumerRepository;

@RestController
public class AdminController {
	
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	ConsumerRepository consumerRepository;
	
	@PostMapping("/admin/addUnits")
	public void addUnitsConsumed(@RequestBody Bill bill) {
		Consumer c  = consumerRepository.findById(bill.getConsumerId().getConsumerId()).orElse(null);
		bill.setConsumerId(c);
		if(c.getConnectionType().equals("domestic")){
			bill.setTotalAmount(bill.getUnitsConsumed()*2);
		}else
			bill.setTotalAmount(bill.getUnitsConsumed()*4);
	
		billRepository.save(bill);
	}
	
	@GetMapping("/Admin/getBillsByYear/{year}")
	public List<Bill> getBillsByYear(@PathVariable int year) throws BillNotFoundException{
		List<Bill> bills = billRepository.findAllByYear(year);
		if(bills.isEmpty()) {
			throw new BillNotFoundException("year = "+ year);
		}else {
			return bills;
		}
	}
	
	@GetMapping("/Admin/getBillsByMonth/{month}/{year}")
	public List<Bill> getBillsByYear(@PathVariable String month, @PathVariable int year) {
		List<Bill> bills = billRepository.findAllByMonth(month, year);
		if(bills.isEmpty()) {
			return null;
		}else {
			return bills;
		}
	}
	
	@GetMapping("/admin/getBillsByArea/{area}")
	public List<Bill> getBillsByArea(@PathVariable String area) {
		List<Bill> bills = billRepository.findBillsByArea(area);
		if(bills.isEmpty()) {
			return null;
		}else {
			return bills;
		}
	}
	@GetMapping("/admin/getBillsByCity/{city}")
	public List<Bill> getBillsByCity(@PathVariable String city) {
		List<Bill> bills = billRepository.findBillsByCity(city);
		if(bills.isEmpty()) {
			return null;
		}else {
			return bills;
		}
	}
	
	@PostMapping("/admin/login")
	public Admin validateAdmin(@RequestBody Admin a) {
		Admin admin = adminRepository.validateAdmin(a.getUserName(), a.getPassword());
		return admin;
	}
	
	@GetMapping("/Admin/getBills")
	public List<Bill> getBills() {
		if((billRepository.findAllBill()).isEmpty()) {
			return null;
		}else {
			return billRepository.findAllBill();
		}
	}

}
