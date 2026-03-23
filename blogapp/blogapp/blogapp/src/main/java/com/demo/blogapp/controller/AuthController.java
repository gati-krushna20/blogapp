package com.demo.blogapp.controller;

import com.demo.blogapp.model.User;
import com.demo.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService service;

    
    @GetMapping({"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String register(@ModelAttribute User user) {
        service.register(user);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        User user = service.login(username, password);

        if(user != null){
            return "redirect:/blogs";
        }

        model.addAttribute("error", "Invalid username or password");
        return "login";
    }
}