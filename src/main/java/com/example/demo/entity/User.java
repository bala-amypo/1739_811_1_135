package com.example.demo.entity;

import java.time.Instant;

public class User {
    private Long id;
    private String email;
    private String password;
    private Role role;
    private Instant createdAt;

    public void onCreate() {
        if (role == null) role = Role.SUBSCRIBER;
        createdAt = Instant.now();
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email){ this.email=email;}
    public String getPassword(){ return password;}
    public void setPassword(String p){ this.password=p;}
    public Role getRole(){ return role;}
    public void setRole(Role r){ this.role=r;}
    public Instant getCreatedAt(){ return createdAt;}
    public void setCreatedAt(Instant t){ this.createdAt=t;}
}
