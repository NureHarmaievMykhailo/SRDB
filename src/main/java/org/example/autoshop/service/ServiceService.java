package org.example.autoshop.service;

import org.example.autoshop.model.ServiceModel;
import org.example.autoshop.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {
    private ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Optional<ServiceModel> findById(int id) {
        return serviceRepository.findById(id);
    }

    public List<ServiceModel> findAll() {
        return serviceRepository.findAll();
    }
}
