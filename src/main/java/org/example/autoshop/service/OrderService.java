package org.example.autoshop.service;

import org.example.autoshop.model.ServiceModel;
import org.example.autoshop.repository.OrderRepository;
import org.example.autoshop.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> findById(int id) {
        return orderRepository.findById(id);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
    public List<Order> findByService(ServiceModel service) {
        return orderRepository.findByService(service);
    }
}
