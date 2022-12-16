package com.demo.pojo;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Consumer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int consumerId;
	
	private String consumerName;
	@Column(unique = true)
	private String userName;
	private String area;
	private String city;
	private String connectionType;
	@OneToMany(mappedBy="consumerId")
	private List<Bill> bills;
	public int getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Bill> getBills() {
		return bills;
	}
	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getConnectionType() {
		return connectionType;
	}
	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}
	public Consumer(String consumerName, String userName, String area, String city,
			String connectionType) {
		super();
		//this.consumerId = consumerId;
		this.consumerName = consumerName;
		this.userName = userName;
		this.area = area;
		this.city = city;
		this.connectionType = connectionType;
		
	}
	
	@Override
	public String toString() {
		return "Consumer [consumerId=" + consumerId + ", consumerName=" + consumerName + ", userName=" + userName
				+ ", area=" + area + ", city=" + city + ", connectionType=" + connectionType + ", bills=" + bills + "]";
	}
	public Consumer() {
		//super();
		// TODO Auto-generated constructor stub
	}
	
	
}
