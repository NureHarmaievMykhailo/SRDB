package org.example.autoshop.controller;

import jakarta.persistence.EntityNotFoundException;
import org.example.autoshop.dto.ServiceDetailDTO;
import org.example.autoshop.model.ServiceModel;
import org.example.autoshop.model.Order;
import org.example.autoshop.service.OrderService;
import org.example.autoshop.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services")
public class ServiceController {

    private final ServiceService serviceService;
    private final OrderService orderService;

    @Autowired
    public ServiceController(ServiceService serviceService, OrderService orderService) {
        this.serviceService = serviceService;
        this.orderService = orderService;
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<ServiceDetailDTO> getServiceDetails(@PathVariable Integer id) {
        // Отримуємо послугу по ID
        Optional<ServiceModel> optService = serviceService.findById(id);
        if (optService.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ServiceModel service = optService.get();
        // Отримуємо замовлення для цієї послуги
        List<Order> orders = orderService.findByService(service);

        // Створюємо DTO для відправки
        ServiceDetailDTO serviceDetailDTO = new ServiceDetailDTO();
        serviceDetailDTO.setServiceId(service.getServiceId());
        serviceDetailDTO.setServiceName(service.getServiceName());
        serviceDetailDTO.setDescription(service.getDescription());
        serviceDetailDTO.setBaseCost(service.getBaseCost());
        serviceDetailDTO.setOrders(orders);

        return ResponseEntity.ok(serviceDetailDTO);
    }

    @GetMapping("/details")
    public ResponseEntity<List<ServiceModel>> getServiceDetails() {
        List<ServiceModel> services = serviceService.findAll();
        return ResponseEntity.ok(services);
    }
}
