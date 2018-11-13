package com.devglan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="order_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orderId")
	private long orderId;
	
	@Column(name="customerId")
	private String customerId;
	
	@Column(name="orderAmount")
	private long orderAmount;
	
	@Column(name="status")
	private String status;
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public long getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(long orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
