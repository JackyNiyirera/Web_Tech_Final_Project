package com.foodapplication.my_online_food_odering_app.repository;

import com.foodapplication.my_online_food_odering_app.models.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SignupRepository extends JpaRepository<SignUp, Long> {

    Optional<SignUp> findById(long url);
}
