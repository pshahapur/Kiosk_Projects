package com.devglan.repository;

import org.springframework.data.repository.CrudRepository;
import com.devglan.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long>
{
	

}
