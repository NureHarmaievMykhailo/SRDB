package org.example.autoshop.repository;
import org.example.autoshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByServiceId(int serviceId);
}