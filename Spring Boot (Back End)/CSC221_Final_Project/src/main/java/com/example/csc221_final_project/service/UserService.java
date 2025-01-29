package com.example.csc221_final_project.service;

import com.example.csc221_final_project.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public Boolean login(String userid, String password) {
        if ((userid.equals("masef") && password.equals("13579")) || (userid.equals("mching") || password.equals("02468"))) { //) {

            return true;
        }

        return false;
    }
}
