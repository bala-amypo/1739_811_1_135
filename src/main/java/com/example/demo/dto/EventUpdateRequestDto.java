package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class EventUpdateRequestDto {

    @NotBlank
    private String message;

    private String severityLevel;

    public EventUpdateRequestDto() {
    }

    public EventUpdateRequestDto(String message, String severityLevel) {
        this.message = message;
        this.severityLevel = severityLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }
}
