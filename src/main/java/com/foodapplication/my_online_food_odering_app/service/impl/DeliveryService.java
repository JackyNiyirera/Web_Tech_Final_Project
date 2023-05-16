package com.foodapplication.my_online_food_odering_app.service.impl;


import com.foodapplication.my_online_food_odering_app.models.Delivery;
import com.foodapplication.my_online_food_odering_app.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeliveryService {
    @Autowired
    private DeliveryRepository DeliveryRepository;

    public List<Delivery> getAllDeliveries() {
        return DeliveryRepository.findAll();
    }

    public Delivery getDeliveryById(Long id) {
        return DeliveryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid delivery Id: " + id));
    }

    public void saveDelivery(Delivery delivery) {
        DeliveryRepository.save(delivery);
    }

    public void deleteDelivery(Long id) {
        Delivery delivery = getDeliveryById(id);
        DeliveryRepository.delete(delivery);
    }
}
