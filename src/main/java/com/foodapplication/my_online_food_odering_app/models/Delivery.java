package com.foodapplication.my_online_food_odering_app.models;


import jakarta.persistence.*;

@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id")
    private Order order;

    private String deliveryAddress;

    public Delivery(Long id) {
        this.id = id;
    }

    public Delivery(Long id, User user, Order order, String deliveryAddress) {
        this.id = id;
        this.user = user;
        this.order = order;
        this.deliveryAddress = deliveryAddress;
    }

    public Delivery() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
