package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    // ✅ Default constructor
    public Subscription() {}

    // ✅ Parameterized constructor
    public Subscription(Long id, User user, Event event) {
        this.id = id;
        this.user = user;
        this.event = event;
    }

    // ✅ REQUIRED getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }
}
