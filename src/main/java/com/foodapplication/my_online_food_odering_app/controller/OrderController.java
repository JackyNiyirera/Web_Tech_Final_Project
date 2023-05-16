package com.foodapplication.my_online_food_odering_app.controller;

import ch.qos.logback.core.model.Model;
import com.foodapplication.my_online_food_odering_app.repository.OrderRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("Order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/")
    public String orderList(Model model) {
        List<Order> orders = OrderRepository.findAll();
        model.addAttribute("orders", orders);
        return "order/list";
    }

    @GetMapping("/create")
    public String createOrderForm(Model model) {
        model.addAttribute("order", new Order() );
        return "order/create";
    }

    @PostMapping("/create")
    public String createOrder(@ModelAttribute("order") Order order) {
        OrderRepository.save(order);
        return "redirect:/order/";
    }

    @GetMapping("/edit/{id}")
    public String editOrderForm(@PathVariable("id") Long id, Model model) {
        Order order = OrderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid order Id: " + id));
        model.addAttribute("order", order);
        return "order/edit";
    }

    @PostMapping("/edit/{id}")
    public String editOrder(@PathVariable("id") Long id, @ModelAttribute("order") Order updatedOrder) {
        Order order = OrderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid order Id: " + id));
        order.setquantity(updatedOrder.getquantity());
        order.setdeliveryAddress(updatedOrder.getdeliveryAddress());
        // Update any other fields as needed
        orderRepository.save(order);
        return "redirect:/order/";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        Order order = OrderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid order Id: " + id));
        orderRepository.delete(order);
        return "redirect:/order/";

    }
}
