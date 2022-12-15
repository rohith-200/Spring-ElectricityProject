package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.pojo.Bill;
import com.demo.pojo.Consumer;
import com.demo.repository.BillRepository;
import com.demo.repository.ConsumerRepository;

@SpringBootApplication
public class SpringElectricityApplication implements CommandLineRunner {
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	ConsumerRepository consumerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringElectricityApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Consumer c1 = new Consumer("Sita ramam", "sita", "anna nagar", "chennai",
				"domestic", "sita123");
		consumerRepository.save(c1);
		
		billRepository.save(new Bill(c1,123,2022,"jan",200));
//		billRepository.save(new Bill(2,234,2022,"jun",2001));
//		billRepository.save(new Bill(9,12314,2022,"mar",200));
		for(Bill emp:billRepository.findAllByYear(2022) ) {
			System.out.println(emp);
		}
		
	}

}
