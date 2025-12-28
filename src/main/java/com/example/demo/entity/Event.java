package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String location;

    private String category;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private User publisher;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime lastUpdatedAt;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<EventUpdate> updates;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Subscription> subscriptions;

    public Event() {
    }

    public Event(Long id, String title, String description, String location, String category,
                 User publisher, Boolean isActive,
                 LocalDateTime createdAt, LocalDateTime lastUpdatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.category = category;
        this.publisher = publisher;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.lastUpdatedAt = LocalDateTime.now();
        if (this.isActive == null) {
            this.isActive = true;
        }
    }

    @PreUpdate
    public void onUpdate() {
        this.lastUpdatedAt = LocalDateTime.now();
    }

    // Getters and Setters
}
