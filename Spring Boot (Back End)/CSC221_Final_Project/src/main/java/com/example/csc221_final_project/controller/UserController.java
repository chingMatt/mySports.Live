package com.example.csc221_final_project.controller;

import com.example.csc221_final_project.model.User;
import com.example.csc221_final_project.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Boolean login (@RequestParam("userid") String userid, @RequestParam("password") String password) {

        return userService.login(userid, password);
    }

    /*@PostMapping("/logout")
    public Boolean logout (@RequestBody User user) {

        return userService.logout(user);
    }*/

}
