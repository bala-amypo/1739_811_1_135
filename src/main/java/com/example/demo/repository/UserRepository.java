package com.example.demo.repository;

import com.example.demo.entity.*;
import java.util.*;

public interface UserRepository {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    User save(User u);
}
