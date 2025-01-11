package org.example.autoshop.service;

import org.example.autoshop.model.Mechanic;
import org.example.autoshop.repository.MechanicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MechanicService {
    private final MechanicRepository mechanicRepository;

    public MechanicService(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }

    public Optional<Mechanic> getById(int id) {
        return mechanicRepository.findById(id);
    }

    public List<Mechanic> getAll() {
        return mechanicRepository.findAll();
    }
}
