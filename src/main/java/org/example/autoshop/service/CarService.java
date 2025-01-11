package org.example.autoshop.service;

import org.example.autoshop.model.Car;
import org.example.autoshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Optional<Car> findById(int id) {
        return carRepository.findById(id);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }
}
