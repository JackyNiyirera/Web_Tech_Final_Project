package com.foodapplication.my_online_food_odering_app.controller;


import ch.qos.logback.core.model.Model;
import com.foodapplication.my_online_food_odering_app.models.SignUp;
import com.foodapplication.my_online_food_odering_app.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("SignUp")
public class SignUpController {
    @Autowired
    private SignupRepository signupRepository;

    @GetMapping("/")
    public String signupList(Model model) {
        List<SignUp> signups = signupRepository.findAll();
        model.addAttribute("signups", signups);
        return "signup/list";
    }

    @GetMapping("/create")
    public String createSignUpForm(Model model) {
        model.addAttribute("signup", new SignUp());
        return "signup/create";
    }
    @PostMapping("/create")
    public String createSignup(@ModelAttribute("signup") SignUp signup) {
        signupRepository.save(signup);
        return "redirect:/signup/";
    }
    @GetMapping("/edit/{id}")
    public String editSignupForm(@PathVariable("id") Long id, Model model) {
        SignUp signup = signupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid signup Id: " + id));
        model.addAttribute("signup", signup);
        return "signup/edit";
    }
    @PostMapping("/edit/{id}")
    public String editSignup(@PathVariable("id") Long id, @ModelAttribute("signup") SignUp updatedSignup) {
        SignUp signup = signupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid signup Id: " + id));
        signup.setEmail(updatedSignup.getEmail());
        signup.setPassword(updatedSignup.getPassword());
        signupRepository.save(signup);
        return "redirect:/signup/";
    }
    @GetMapping("/delete/{id}")
    public String deleteSignup(@PathVariable("id") Long id) {
        SignUp signup = signupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid signup Id: " + id));
        signupRepository.delete(signup);
        return "redirect:/signUp/";
    }
}
