package com.foodapplication.my_online_food_odering_app.controller;


import ch.qos.logback.core.model.Model;
import com.foodapplication.my_online_food_odering_app.models.Delivery;
import com.foodapplication.my_online_food_odering_app.service.impl.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("Delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping
    public String listDeliveries(Model model) {
        List<Delivery> deliveries = deliveryService.getAllDeliveries();
        model.addAttribute("deliveries", deliveries);
        return "delivery/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("delivery", new Delivery());
        return "delivery/create";
    }

    @PostMapping("/create")
    public String createDelivery(@ModelAttribute("delivery") Delivery delivery) {
        deliveryService.saveDelivery(delivery);
        return "redirect:/deliveries";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Delivery delivery = deliveryService.getDeliveryById(id);
        model.addAttribute("delivery", delivery);
        return "delivery/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateDelivery(@PathVariable("id") Long id, @ModelAttribute("delivery") Delivery delivery) {
        delivery.setId(id);
        deliveryService.saveDelivery(delivery);
        return "redirect:/deliveries";
    }

    @GetMapping("/delete/{id}")
    public String deleteDelivery(@PathVariable("id") Long id) {
        deliveryService.deleteDelivery(id);
        return "redirect:/deliveries";
    }
}
