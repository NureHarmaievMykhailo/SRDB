package org.example.autoshop.controller;

import org.example.autoshop.model.Mechanic;
import org.example.autoshop.service.MechanicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mechanics")
public class MechanicController {
    private final MechanicService mechanicService;

    public MechanicController(MechanicService mechanicService) {
        this.mechanicService = mechanicService;
    }

    @GetMapping
    public List<Mechanic> getAllMechanics() {
        return mechanicService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mechanic> getMechanicById(@PathVariable int id) {
        Optional<Mechanic> mechanic = mechanicService.getById(id);
        if (mechanic.isPresent()) {
            return ResponseEntity.ok(mechanic.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
