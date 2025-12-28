package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.security.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Auth")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @Operation(summary = "Register user")
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody User user) {
        User saved = userService.register(user);
        String token = jwtUtil.generateToken(
                saved.getId(), saved.getEmail(), saved.getRole());

        return ResponseEntity.status(201)
                .body(new AuthResponse(token, saved.getId(),
                        saved.getEmail(), saved.getRole()));
    }

    @Operation(summary = "Login user")
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        User user = userService.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtUtil.generateToken(
                user.getId(), user.getEmail(), user.getRole());

        return ResponseEntity.ok(
                new AuthResponse(token, user.getId(),
                        user.getEmail(), user.getRole()));
    }
}
