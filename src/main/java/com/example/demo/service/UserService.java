package com.example.demo.service;

import com.example.demo.entity.*;

public interface UserService {
    User register(User u);
    User findByEmail(String email);
}
