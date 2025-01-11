package org.example.autoshop.repository;

import org.example.autoshop.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {}
