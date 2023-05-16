package com.foodapplication.my_online_food_odering_app.service.impl;

import com.foodapplication.my_online_food_odering_app.models.Payment;
import com.foodapplication.my_online_food_odering_app.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {
    @Autowired
    private PaymentRepository PaymentRepository;

    public default List<Payment> getAllPayments() {
        return PaymentRepository.findAll();
    }

    public default Payment getPaymentById(Long id) {
        return PaymentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid payment Id: " + id));
    }

    public default void savePayment(Payment payment) {
        PaymentRepository.save(payment);
    }

    public default void deletePayment(Long id) {
        Payment payment = getPaymentById(id);
        PaymentRepository.delete(payment);
    }
}
