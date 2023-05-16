package com.foodapplication.my_online_food_odering_app.models;


import jakarta.persistence.*;

@Entity
@Table(name = "order")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    private int quantity;

    private String deliveryAddress;

    public Order(Long id) {
        this.id = id;
    }

    public Order(Long id, Menu menu, User user, int quantity, String deliveryAddress) {
        this.id = id;
        this.menu = menu;
        this.user = user;
        this.quantity = quantity;
        this.deliveryAddress = deliveryAddress;
    }

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
