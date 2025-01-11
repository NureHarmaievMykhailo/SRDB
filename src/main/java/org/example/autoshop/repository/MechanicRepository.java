package org.example.autoshop.repository;

import org.example.autoshop.model.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MechanicRepository extends JpaRepository<Mechanic, Integer> {
}
