package com.example.demo.dto;

import java.time.LocalDateTime;

public class EventUpdateResponseDto {

    private Long id;
    private String message;
    private LocalDateTime timestamp;

    public EventUpdateResponseDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
