package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	public void addUnitsConsumed(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("consumerId") int consumerId, @RequestParam("year") int year, @RequestParam("month") String month, @RequestParam("unitsConsumed") int unitsConsumed) {
		Consumer c  = consumerRepository.findById(consumerId).orElse(null);
		Bill bill = new Bill();
		bill.setConsumerId(c);
		bill.setMonth(month);
		bill.setYear(year);
		if(c.getConnectionType().equals("domestic")){
			bill.setTotalAmount(bill.getUnitsConsumed()*2);
		}else
			bill.setTotalAmount(bill.getUnitsConsumed()*4);
	
		billRepository.save(bill);
	}
	
	@GetMapping("/Admin/getBillsByYear")
	public List<Bill> getBillsByYear(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("year") int year) throws BillNotFoundException{
		Admin admin = adminRepository.validateAdmin(userName, password);
		if(admin==null) throw new BillNotFoundException("Invalid admin credentials");
		List<Bill> bills = billRepository.findAllByYear(year);
		if(bills.isEmpty()) {
			throw new BillNotFoundException("year = "+ year);
		}else {
			return bills;
		}
	}
	
	@GetMapping("/Admin/getBillsByMonth")
	public List<Bill> getBillsByYear(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("month") String month, @RequestParam("year") int year ) throws BillNotFoundException {
		Admin admin = adminRepository.validateAdmin(userName, password);
		if(admin==null) throw new BillNotFoundException("Invalid admin credentials");
		List<Bill> bills = billRepository.findAllByMonth(month, year);
		if(bills.isEmpty()) {
			return null;
		}else {
			return bills;
		}
		
	}
	
	@GetMapping("/admin/getBillsByArea")
	public List<Bill> getBillsByArea(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("area") String area) throws BillNotFoundException {
		Admin admin = adminRepository.validateAdmin(userName, password);
		if(admin==null) throw new BillNotFoundException("Invalid admin credentials");
		List<Bill> bills = billRepository.findBillsByArea(area);
		if(bills.isEmpty()) {
			return null;
		}else {
			return bills;
		}
		
	}
	
	@GetMapping("/admin/getBillsByCity")
	public List<Bill> getBillsByCity(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("city") String city) throws BillNotFoundException {
		Admin admin = adminRepository.validateAdmin(userName, password);
		if(admin==null) throw new BillNotFoundException("Invalid admin credentials");
		List<Bill> bills = billRepository.findBillsByCity(city);
		if(bills.isEmpty()) {
			return null;
		}else {
			return bills;
		}
		
	}
	
	
	@GetMapping("/Admin/getBills")
	public List<Bill> getBills(@RequestParam("userName") String userName, @RequestParam("password") String password) throws BillNotFoundException {
		Admin admin = adminRepository.validateAdmin(userName, password);
		if(admin==null) throw new BillNotFoundException("Invalid admin credentials");
		if((billRepository.findAllBill()).isEmpty()) {
			return null;
		}else {
			return billRepository.findAllBill();
		}
	}

}