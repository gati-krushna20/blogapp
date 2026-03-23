package com.demo.blogapp.service;

import com.demo.blogapp.model.Blog;
import com.demo.blogapp.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepository repo;

    public Blog save(Blog blog) {
        return repo.save(blog);
    }

    public List<Blog> getAll() {
        return repo.findAll();
    }
}