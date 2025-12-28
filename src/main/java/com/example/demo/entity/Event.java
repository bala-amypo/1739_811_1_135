package com.example.demo.entity;

import java.time.Instant;

public class Event {
    private Long id;
    private String title;
    private String description;
    private String location;
    private String category;
    private boolean active;
    private User publisher;
    private Instant createdAt;
    private Instant lastUpdatedAt;

    public void onCreate() {
        this.active = true;
        createdAt = Instant.now();
        lastUpdatedAt = createdAt;
    }

    public void onUpdate() {
        lastUpdatedAt = Instant.now();
    }

    // getters & setters
    public Long getId(){ return id;}
    public void setId(Long id){ this.id=id;}
    public String getTitle(){ return title;}
    public void setTitle(String t){ this.title=t;}
    public String getDescription(){ return description;}
    public void setDescription(String d){ this.description=d;}
    public String getLocation(){ return location;}
    public void setLocation(String l){ this.location=l;}
    public boolean isActive(){ return active;}
    public void setActive(boolean a){ this.active=a;}
    public User getPublisher(){ return publisher;}
    public void setPublisher(User u){ this.publisher=u;}
    public Instant getCreatedAt(){ return createdAt;}
    public Instant getLastUpdatedAt(){ return lastUpdatedAt;}
    public String getCategory(){ return category;}
    public void setCategory(String c){ this.category=c;}
}
