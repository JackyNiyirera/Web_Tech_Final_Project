package com.foodapplication.my_online_food_odering_app.repository;

import com.foodapplication.my_online_food_odering_app.models.Delivery;
import com.foodapplication.my_online_food_odering_app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Optional<User> findById(long url);
}
