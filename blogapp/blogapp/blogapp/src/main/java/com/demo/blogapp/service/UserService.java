package com.demo.blogapp.service;

import com.demo.blogapp.model.User;
import com.demo.blogapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User register(User user) {
        return repo.save(user);
    }

    public User login(String username, String password) {
        return repo.findByUsername(username)
                .filter(u -> u.getPassword().equals(password))
                .orElse(null);
    }

    
    public User getById(int id) {
        return repo.findById(id).orElse(null);
    }
}