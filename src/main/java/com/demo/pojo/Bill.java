package com.demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Consumer.consumerId")
	private int consumerId;
	@Column(nullable = false)
	private int unitsConsumed;
	@Column(nullable = false)
	private int year;
	@Column(nullable = false)
	private String month;
	private int totalAmount;
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}
	public int getUnitsConsumed() {
		return unitsConsumed;
	}
	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Bill(int billId, int consumerId, int unitsConsumed, int year, String month, int totalAmount) {
		super();
		this.billId = billId;
		this.consumerId = consumerId;
		this.unitsConsumed = unitsConsumed;
		this.year = year;
		this.month = month;
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", consumerId=" + consumerId + ", unitsConsumed=" + unitsConsumed + ", year="
				+ year + ", month=" + month + ", totalAmount=" + totalAmount + "]";
	}
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
