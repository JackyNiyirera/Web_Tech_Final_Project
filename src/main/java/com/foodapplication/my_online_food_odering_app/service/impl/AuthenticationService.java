package com.foodapplication.my_online_food_odering_app.service.impl;


import com.foodapplication.my_online_food_odering_app.models.SignUp;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

    @Autowired
    private SignUpService singUpService;

    public boolean authenticateUser(String username, String password) {
        SignUp signUp = SignUpService.getsignUpByEmail(Email);
        if (signUp != null && signUp.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public SignUp getUserByUsername(String Email) {
        return userService.getUserByEmail(Email);
    }
}
