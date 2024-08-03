package dev.aman.taskmanagementsystem.Controllers;

import dev.aman.taskmanagementsystem.Exceptions.UserAlreadyExistException;
import dev.aman.taskmanagementsystem.Models.User;
import dev.aman.taskmanagementsystem.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) throws UserAlreadyExistException {
        return userService.registerUser(user.getUserName(), user.getPassword());
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        return "JWT Token";
    }
}
