package com.example.Job_Portal.controller;

import com.example.Job_Portal.entity.User;
import com.example.Job_Portal.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepo userRepo;

    @GetMapping("/users")
    public String users(Model model) {
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "registration";
    }
}
