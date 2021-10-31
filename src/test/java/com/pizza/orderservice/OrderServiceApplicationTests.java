package com.pizza.orderservice;

import com.pizza.orderservice.model.OrderRequest;
import com.pizza.orderservice.repo.OrderRepo;
import com.pizza.orderservice.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceApplicationTests {
	@Autowired
	OrderService orderService;
	@Autowired
	OrderRepo repo;

	@Test
	void orderService_InvalidQuantity_Negative() {
		OrderRequest order = new OrderRequest("PizzaA",-10,new BigDecimal(10));
		Throwable exception = assertThrows(Exception.class, () -> {
			orderService.processOrder(order);
		});
		assertEquals("Quantity must be greater than 0",exception.getMessage());
	}
	@Test
	void orderService_InvalidQuantity_Zero() {
		OrderRequest order = new OrderRequest("PizzaA",0,new BigDecimal(10));
		Throwable exception = assertThrows(Exception.class, () -> {
			orderService.processOrder(order);
		});
		assertEquals("Quantity must be greater than 0",exception.getMessage());
	}
	@Test
	void orderService_InvalidPrice() {
		OrderRequest order = new OrderRequest("PizzaA",10,new BigDecimal(-10));
		Throwable exception = assertThrows(Exception.class, () -> {
			orderService.processOrder(order);
		});
		assertEquals("Price cannot be negative",exception.getMessage());
	}

	@Test
	void orderService_InvalidName_Null() {
		OrderRequest order = new OrderRequest(null,10,new BigDecimal(10));
		Throwable exception = assertThrows(Exception.class, () -> {
			orderService.processOrder(order);
		});
		assertEquals("Must provide name for pizza",exception.getMessage());
	}
	@Test
	void orderService_InvalidName_Empty() {
		OrderRequest order = new OrderRequest(null,10,new BigDecimal(10));
		Throwable exception = assertThrows(Exception.class, () -> {
			orderService.processOrder(order);
		});
		assertEquals("Must provide name for pizza",exception.getMessage());
	}

	@Test
	void orderService_validOrder() throws Exception {
		OrderRequest order = new OrderRequest("PizzaA",10,new BigDecimal(100));
		Long beforeCount = repo.count();
		order = orderService.processOrder(order);
		assertNotNull(order.getId());
		assertEquals(beforeCount+1,repo.count());
		assertEquals("PizzaA",order.getName());
		assertEquals(10,order.getQuantity());
		assertEquals(new BigDecimal(100),order.getPrice());
	}




}
