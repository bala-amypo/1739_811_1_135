package com.example.demo.dto;

import lombok.Data;

@Data
public class EventUpdateRequest {
    private Long eventId;
    private String updateMessage;
}
