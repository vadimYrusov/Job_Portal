package com.example.Job_Portal.controller;

import com.example.Job_Portal.entity.Role;
import com.example.Job_Portal.entity.User;
import com.example.Job_Portal.repository.RoleRepo;
import com.example.Job_Portal.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepo userRepo;

    private final RoleRepo roleRepo;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("keyword", "");
        return "login";
    }

    @GetMapping("/users")
    public String users(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("keyword", "");
        return "registration";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") User user, HttpServletRequest request) throws ServletException {
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        List<Role> roles = new ArrayList<>();
        if (user.getRegisterRole().equals("jobSeeker")) {
            roles.add(roleRepo.getRoleById(2L));
        } else if (user.getRegisterRole().equals("employer")) {
            roles.add(roleRepo.getRoleById(3L));
        }
        user.setRoles(roles);
        userRepo.save(user);
        request.login(user.getEmail(), password);
        return "redirect:/jobs";
    }
}
