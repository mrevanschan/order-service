package com.pizza.orderservice.service;

import com.pizza.orderservice.model.OrderRequest;
import com.pizza.orderservice.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
@Transactional
public class OrderService {
    @Autowired
    OrderRepo repo;

    public OrderRequest processOrder(OrderRequest order) throws Exception{
        if(order.getQuantity()<=0)
            throw new Exception("Quantity must be greater than 0");
        if(order.getPrice().compareTo(BigDecimal.ZERO) < 0)
            throw new Exception("Price cannot be negative");
        if(order.getName()== null || order.getName().trim().isEmpty())
            throw new Exception("Must provide name for pizza");
        return repo.save(order);
    }
}
