package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.pojo.Bill;
import com.demo.repository.BillRepository;

@SpringBootApplication
public class SpringElectricityApplication implements CommandLineRunner {
	@Autowired
	BillRepository billRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringElectricityApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		billRepository.save(new Bill(4,123,2022,"jan",200));
		for(Bill emp:billRepository.findAllByYear(2022) ) {
			System.out.println(emp);
		}
		
	}

}
