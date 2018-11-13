package com.devglan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired 
	private JmsTemplate jmsTemplate;
	
	@Autowired
	Gson gson;
	
	  @RequestMapping("/send")
	  public void sendOrderStatus(@RequestBody String orderinfo) {
	    System.out.println("Sending a Order Status.");
	    // Post message to the message queue named "OrderTransactionQueue"
	    
	    Order order = gson.fromJson(orderinfo, Order.class);
	    if(order != null) {
	    	  float amount = order.getOrderAmount();
	  	    String status = null;
	  	    if(amount > 10000) {
	  	    	status = "Order Rejected";
	  	    } else {
	  	    	status = "Order is Accepted";
	  	    }
	  	    order.setStatus(status);
	  	    String orderUpdated = gson.toJson(order);
	  	    
	  	    //JmsTemplate jmsTemplate = new JmsTemplate();
	  	    jmsTemplate.convertAndSend("OrderQueue", orderUpdated);
	    }
	  }
	  
	  public void sendOrderUpdate(Order order) {
		    System.out.println("Sending a Order Status.");
		    // Post message to the message queue named "OrderTransactionQueue"
		    
		    //Order order = gson.fromJson(orderinfo, Order.class);
		    if(order != null) {
		    	  float amount = order.getOrderAmount();
		  	    String status = null;
		  	    if(amount > 1000) {
		  	    	status = "Order Rejected";
		  	    } else {
		  	    	status = "Order is Accepted";
		  	    }
		  	    order.setStatus(status);
		  	    if(gson == null) {
		  	    	gson = new Gson();
		  	    }
		  	    String orderUpdated = gson.toJson(order);
		  	    
		  	    //JmsTemplate jmsTemplate = new JmsTemplate();
		  	    jmsTemplate.convertAndSend("OrderQueue", orderUpdated);
		    }
		  }
}
