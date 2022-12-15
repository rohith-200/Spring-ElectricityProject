package com.demo.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Consumer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int consumerId;
	
	private String consumerName;
	@Column(unique = true)
	private String consumerAlias;
	private String area;
	private String city;
	private String connectionType;
	private String password;
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
	public String getConsumerAlias() {
		return consumerAlias;
	}
	public void setConsumerAlias(String consumerAlias) {
		this.consumerAlias = consumerAlias;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Consumer(String consumerName, String consumerAlias, String area, String city,
			String connectionType, String password) {
		super();
		//this.consumerId = consumerId;
		this.consumerName = consumerName;
		this.consumerAlias = consumerAlias;
		this.area = area;
		this.city = city;
		this.connectionType = connectionType;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Consumer [consumerId=" + consumerId + ", consumerName=" + consumerName + ", consumerAlias="
				+ consumerAlias + ", area=" + area + ", city=" + city + ", connectionType=" + connectionType
				+ ", password=" + password + "]";
	}
	public Consumer() {
		//super();
		// TODO Auto-generated constructor stub
	}
	
	
}
