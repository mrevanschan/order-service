package com.pizza.orderservice.repo;

import com.pizza.orderservice.model.OrderRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends CrudRepository<OrderRequest, Long> {


}
