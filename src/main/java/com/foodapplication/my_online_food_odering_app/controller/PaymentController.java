package com.foodapplication.my_online_food_odering_app.controller;


import ch.qos.logback.core.model.Model;
import com.foodapplication.my_online_food_odering_app.models.Payment;
import com.foodapplication.my_online_food_odering_app.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("Payment")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/")
    public String paymentList(Model model) {
        List<Payment> payments = paymentRepository.findAll();
        model.addAttribute("payments", payments);
        return "payment/list";
    }

    @GetMapping("/create")
    public String createPaymentForm(Model model) {
        model.addAttribute("payment", new Payment());
        return "payment/create";
    }

    @PostMapping("/create")
    public String createPayment(@ModelAttribute("payment") Payment payment) {
        paymentRepository.save(payment);
        return "redirect:/payment/";
    }

    @GetMapping("/edit/{id}")
    public String editPaymentForm(@PathVariable("id") Long id, Model model) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid payment Id: " + id));
        model.addAttribute("payment", payment);
        return "payment/edit";
    }

    @PostMapping("/edit/{id}")
    public String editPayment(@PathVariable("id") Long id, @ModelAttribute("payment") Payment updatedPayment) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid payment Id: " + id));
        payment.setAmount(updatedPayment.getAmount());
        payment.setOrder(updatedPayment.getOrder());
        payment.setUser(updatedPayment.getUser());

        // Update any other fields as needed
        paymentRepository.save(payment);
        return "redirect:/payment/";
    }

    @GetMapping("/delete/{id}")
    public String deletePayment(@PathVariable("id") Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid payment Id: " + id));
        paymentRepository.delete(payment);
        return "redirect:/payment/";
    }
}
