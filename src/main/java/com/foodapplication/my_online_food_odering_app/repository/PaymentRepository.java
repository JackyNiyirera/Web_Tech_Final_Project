package com.foodapplication.my_online_food_odering_app.repository;

import com.foodapplication.my_online_food_odering_app.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findById(long url);
}
