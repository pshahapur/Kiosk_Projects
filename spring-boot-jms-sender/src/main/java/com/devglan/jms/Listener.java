package com.devglan.jms;

import com.devglan.model.Order;
import com.devglan.repository.OrderRepository;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.Map;

@Component
public class Listener {
	
	@Autowired
	Gson gson;
	
	@Autowired
	OrderRepository orderRepository;

	@JmsListener(destination = "OrderQueue")
	@SendTo("CustomerQueue")
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
		TextMessage textMessage = (TextMessage)jsonMessage;
		String message = textMessage.getText();
		System.out.println("Order status is : " +message);
		Order order = gson.fromJson(message, Order.class);
		
		//orderRepository.
		
		orderRepository.save(order);
		return response;
	}

}
