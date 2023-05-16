package com.foodapplication.my_online_food_odering_app.service.impl;


import com.foodapplication.my_online_food_odering_app.models.SignUp;
import com.foodapplication.my_online_food_odering_app.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SignUpService {
    @Autowired
    private SignupRepository signUpRepository;

    public List<SignUp> getAllSignUps() {
        return signUpRepository.findAll();
    }

    public SignUp getSignUpById(Long id) {
        return signUpRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid sign up Id: " + id));
    }

    public void saveSignUp(SignUp signUp) {
        signUpRepository.save(signUp);
    }

    public void deleteSignUp(Long id) {
        SignUp signUp = getSignUpById(id);
        signUpRepository.delete(signUp);
    }
}
