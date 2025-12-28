package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "subscriptions",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "event_id"})
    }
)
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(nullable = false)
    private LocalDateTime subscribedAt;

    public Subscription() {
    }

    public Subscription(Long id, User user, Event event, LocalDateTime subscribedAt) {
        this.id = id;
        this.user = user;
        this.event = event;
        this.subscribedAt = subscribedAt;
    }

    @PrePersist
    public void prePersist() {
        this.subscribedAt = LocalDateTime.now();
    }

    // Getters and Setters
}
