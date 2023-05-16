package com.foodapplication.my_online_food_odering_app.models;


import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id")
    private Order order;

    private double amount;

    private String paymentMethod;

    public Payment(Long id) {
        this.id = id;
    }

    public Payment(Long id, User user, Order order, double amount, String paymentMethod) {
        this.id = id;
        this.user = user;
        this.order = order;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public Payment() {

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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
