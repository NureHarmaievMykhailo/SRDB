package org.example.autoshop.controller;

import org.example.autoshop.model.Car;
import org.example.autoshop.repository.CarRepository;
import org.example.autoshop.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarRepository carRepository) {
        this.carService = new CarService(carRepository);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable int id) {
        Optional<Car> car = carService.findById(id);
        if (car.isPresent()) {
            return ResponseEntity.ok(car.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}