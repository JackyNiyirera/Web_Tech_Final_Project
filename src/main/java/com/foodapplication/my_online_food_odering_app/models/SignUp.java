package com.foodapplication.my_online_food_odering_app.models;


import jakarta.persistence.*;

@Entity
@Table(name = "signup")
public class SignUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String email;
    private String password;

    public SignUp(long id) {
        this.id = id;
    }

    public SignUp(long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public SignUp() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
