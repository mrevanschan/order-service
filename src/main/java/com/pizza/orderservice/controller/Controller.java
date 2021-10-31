package com.pizza.orderservice.controller;

import com.pizza.orderservice.model.OrderRequest;
import com.pizza.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j

public class Controller {
    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<?> receiveOrder(@RequestBody OrderRequest incomingOrder) {
        log.debug("Incoming "+ incomingOrder);
        try {
            OrderRequest order = orderService.processOrder(incomingOrder);
            log.info("Processed "+order);
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            log.error("Rejected "+incomingOrder);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
