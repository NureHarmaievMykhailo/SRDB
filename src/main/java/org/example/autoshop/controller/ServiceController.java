package org.example.autoshop.controller;

import org.example.autoshop.dto.ServiceDetailDTO;
import org.example.autoshop.model.Service;
import org.example.autoshop.model.Order;
import org.example.autoshop.repository.ServiceRepository;
import org.example.autoshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/{id}/details")
    public ResponseEntity<ServiceDetailDTO> getServiceDetails(@PathVariable Integer id) {
        // Отримуємо послугу по ID
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Service not found"));

        // Отримуємо замовлення для цієї послуги
        List<Order> orders = orderRepository.findByServiceId(id);

        // Створюємо DTO для відправки
        ServiceDetailDTO serviceDetailDTO = new ServiceDetailDTO();
        serviceDetailDTO.setServiceId(service.getServiceId());
        serviceDetailDTO.setServiceName(service.getServiceName());
        serviceDetailDTO.setDescription(service.getDescription());
        serviceDetailDTO.setBaseCost(service.getBaseCost());
        serviceDetailDTO.setOrders(orders);

        return ResponseEntity.ok(serviceDetailDTO);
    }
}
