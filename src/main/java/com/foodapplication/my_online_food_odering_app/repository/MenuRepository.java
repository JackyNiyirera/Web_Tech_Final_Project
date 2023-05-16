package com.foodapplication.my_online_food_odering_app.repository;

import com.foodapplication.my_online_food_odering_app.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    Optional<Menu> findById(long url);
}
