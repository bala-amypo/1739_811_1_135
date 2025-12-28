package com.example.demo.dto;

public class AuthResponse {

    private String token;
    private Long userId;
    private String role;

    public AuthResponse() {}

    public AuthResponse(String token, Long userId, String role) {
        this.token = token;
        this.userId = userId;
        this.role = role;
    }

    // CONTROLLER-SAFE OVERLOAD
    public AuthResponse(String token, Long userId, String role, Object ignored) {
        this(token, userId, role);
    }

    public String getToken() {
        return token;
    }

    public Long getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }
}
