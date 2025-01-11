package org.example.autoshop.repository;

import org.example.autoshop.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceModel, Integer> {

}