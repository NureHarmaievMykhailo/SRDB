package org.example.autoshop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "CAR_ID")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "MECHANIC_ID")
    private Mechanic mechanic;

    @ManyToOne
    @JoinColumn(name = "SERVICE_ID")
    private ServiceModel service;

    private double cost;
    private String orderDate;
    private String completionDate;

    public ServiceModel getService() {
        return service;
    }

    public void setService(ServiceModel service) {
        this.service = service;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }
}
