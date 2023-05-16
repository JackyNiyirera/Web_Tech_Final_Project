package com.foodapplication.my_online_food_odering_app.repository;

import com.foodapplication.my_online_food_odering_app.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findById(long url);
}
