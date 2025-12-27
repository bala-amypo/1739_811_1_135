package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class BroadcastService {

    public String broadcastMessage(String message) {
        if (message == null || message.isBlank()) {
            return "No message provided";
        }
        return "Broadcasted: " + message;
    }
}
