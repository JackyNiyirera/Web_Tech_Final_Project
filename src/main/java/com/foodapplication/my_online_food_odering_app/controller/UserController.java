package com.foodapplication.my_online_food_odering_app.controller;


import ch.qos.logback.core.model.Model;
import com.foodapplication.my_online_food_odering_app.models.User;
import com.foodapplication.my_online_food_odering_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("User")
public class UserController {


        @Autowired
        private UserRepository userRepository;

        @GetMapping("/")
        public String userList(Model model) {
            List<User> users = userRepository.findAll();
            model.addAttribute("users", users);
            return "user/list";
        }

        @GetMapping("/create")
        public String createUserForm(Model model) {
            model.addAttribute("user", new User());
            return "user/create";
        }

        @PostMapping("/create")
        public String createUser(@ModelAttribute("user") User user) {
            userRepository.save(user);
            return "redirect:/user/";
        }

        @GetMapping("/edit/{id}")
        public String editUserForm(@PathVariable("id") Long id, Model model) {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid user Id: " + id));
            model.addAttribute("user", user);
            return "user/edit";
        }

        @PostMapping("/edit/{id}")
        public String editUser(@PathVariable("id") Long id, @ModelAttribute("user") User updatedUser) {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid user Id: " + id));
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setEmail(updatedUser.getEmail());
            user.setPhoneNumber(updatedUser.getPhoneNumber());
            userRepository.save(user);
            return "redirect:/user/";
        }

        @GetMapping("/delete/{id}")
        public String deleteUser(@PathVariable("id") Long id) {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid user Id: " + id));
            userRepository.delete
                    (user);
            return "redirect:/user/";
        }
}
