package com.devglan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devglan.model.Order;
import com.devglan.repository.OrderRepository;
import com.google.gson.Gson;


@RestController
@RequestMapping("/transaction")
public class OrderTransactionController {
	
	@Autowired 
	private JmsTemplate jmsTemplate;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	Gson gson;
	
	  @PostMapping("/send")
	  public void send(@RequestBody String orderInfo) {
	    System.out.println("Sending a transaction.");
	    Order order = gson.fromJson(orderInfo, Order.class);
	    System.out.println("customer id : "+order.getCustomerId() + "status : " +order.getStatus());
	    orderRepository.save(order);
	    // Post message to the message queue named "OrderTransactionQueue"
	    jmsTemplate.convertAndSend("CustomerQueue", orderInfo);
	  }
}
