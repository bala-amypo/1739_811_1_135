package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(
    name = "subscriptions",
    uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "event_id"})
)
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant subscribedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Subscription() {}

    public Subscription(Long id, User user, Event event) {
        this.id = id;
        this.user = user;
        this.event = event;
    }

    @PrePersist
    public void onCreate() {
        this.subscribedAt = Instant.now();
    }

    // Getters & Setters
    public Long getId() { return id; }

    public Instant getSubscribedAt() { return subscribedAt; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }
}
