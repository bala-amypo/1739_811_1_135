package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;
    private String category;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private User publisher;

    private boolean isActive;

    // ✅ Default constructor
    public Event() {}

    // ✅ Parameterized constructor
    public Event(Long id, String title, String description,
                 String location, String category,
                 User publisher, boolean isActive) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.category = category;
        this.publisher = publisher;
        this.isActive = isActive;
    }

    // ✅ REQUIRED getters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public User getPublisher() { return publisher; }
    public void setPublisher(User publisher) { this.publisher = publisher; }

    public boolean getIsActive() { return isActive; }

    // ⚠️ MUST be setIsActive (tests expect this name)
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
