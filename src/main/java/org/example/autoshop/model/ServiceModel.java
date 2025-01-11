package org.example.autoshop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Services")
public class ServiceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "SERVICE_ID")
    private Integer serviceId;

    @Column(name = "SERVICE_NAME")
    private String serviceName;

    @Column(name = "BASE_COST")
    private double baseCost;

    @Column(name = "DURATION_ESTIMATE")
    private int durationEstimate;

    @Column(name = "Description")
    private String description;

    // Getters and setters

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public int getDurationEstimate() {
        return durationEstimate;
    }

    public void setDurationEstimate(int durationEstimate) {
        this.durationEstimate = durationEstimate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


