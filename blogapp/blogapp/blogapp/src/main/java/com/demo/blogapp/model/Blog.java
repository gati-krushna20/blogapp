package com.demo.blogapp.model;

import jakarta.persistence.*;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Blog(){}

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public User getUser() { return user; }

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setUser(User user) { this.user = user; }
}