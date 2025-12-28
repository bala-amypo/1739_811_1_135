package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class EventRequestDto {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String location;

    private String category;

    public EventRequestDto() {
    }

    public EventRequestDto(String title, String description, String location, String category) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
