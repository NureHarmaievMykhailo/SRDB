package org.example.autoshop.controller;

import org.example.autoshop.model.Order;
import org.example.autoshop.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable int id) {
        Optional<Order> optOrder = orderService.findById(id);
        if (optOrder.isPresent()) {
            return ResponseEntity.ok(optOrder.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.findAll());
    }
}