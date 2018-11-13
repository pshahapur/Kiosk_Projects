package com.devglan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import java.util.Arrays;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class ListenerCustomer {
	
	//@Autowired
	//CustomerController controller;
	
	@Autowired 
	private JmsTemplate jmsTemplate;
	
	@Autowired
	RestTemplate restTemplate;

	@JmsListener(destination = "CustomerQueue")
	@SendTo("OrderQueue")
	public String receiveMessage(final Message jsonMessage) throws JMSException {
		String messageData = null;
		System.out.println("Received message " + jsonMessage);
		String response = null;
		/*if(jsonMessage instanceof TextMessage) {
			TextMessage textMessage = (TextMessage)jsonMessage;
			messageData = textMessage.getText();
            Map<String, String> map = new Gson().fromJson(messageData, Map.class);
            response  = "Hello " + map.get("name");
		}*/
		//if(jsonMessage instanceof Order) {
			TextMessage textMessage = (TextMessage)jsonMessage;
			String orderMessage = textMessage.getText();
			Gson gson = new Gson();
			Order order = gson.fromJson(orderMessage, Order.class);
			//float amount = order.getOrderAmount();
			//CustomerController controller = new CustomerController();
			//controller.sendOrderUpdate(order);
			 HttpHeaders headers = new HttpHeaders();
		     headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		     HttpEntity<Order> entity = new HttpEntity<Order>(order,headers);
		     System.out.println("reply message to customer ");
		      return restTemplate.exchange(
		         "http://localhost:8090/customer/send", HttpMethod.POST, entity, String.class).getBody();
		//}
		
		//return response;
	}

}
