package com.foodapplication.my_online_food_odering_app.models;


import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;

    private double price;

    public Menu(Long id) {
        this.id = id;
    }

    public Menu(Long id, String itemName, double price) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
    }

    public Menu() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
