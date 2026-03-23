package com.demo.blogapp.controller;

import com.demo.blogapp.model.Blog;
import com.demo.blogapp.model.User;
import com.demo.blogapp.service.BlogService;
import com.demo.blogapp.service.UserService; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {

    @Autowired
    private BlogService service;

    
    @Autowired
    private UserService userService;

    @GetMapping("/add")
    public String addPage() {
        return "addblog";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Blog blog,
                       @RequestParam int userId) {

        User user = userService.getById(userId); 

        if(user == null){
            return "redirect:/add";
        }

        blog.setUser(user);
        service.save(blog);

        return "redirect:/blogs";
    }

    @GetMapping("/blogs")
    public String allBlogs(Model model) {
        model.addAttribute("blogs", service.getAll());
        return "dashboard";
    }
}