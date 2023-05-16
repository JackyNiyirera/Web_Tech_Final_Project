package com.foodapplication.my_online_food_odering_app.controller;


import ch.qos.logback.core.model.Model;
import com.foodapplication.my_online_food_odering_app.models.SignUp;
import com.foodapplication.my_online_food_odering_app.models.User;
import com.foodapplication.my_online_food_odering_app.service.impl.SignUpService;
import com.foodapplication.my_online_food_odering_app.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    @Autowired
    private SignUpService signUpService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("Email") String Email,
                               @RequestParam("password") String password,
                               Model model) {
        SignUp signUp = signUpService.getSignUpById(Email);
        if (SignUp != null && SignUp.getPassword().equals(password)) {
            // Authentication successful, redirect to home page or dashboard
            return "redirect:/home";
        } else {
            // Authentication failed, display error message
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
