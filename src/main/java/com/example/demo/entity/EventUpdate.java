package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "event_updates")
public class EventUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(nullable = false)
    private String updateContent;

    @Column(nullable = false)
    private String updateType;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private String severityLevel;

    @OneToMany(mappedBy = "eventUpdate", cascade = CascadeType.ALL)
    private List<BroadcastLog> broadcastLogs;

    public EventUpdate() {
    }

    public EventUpdate(Long id, Event event, String updateContent,
                       String updateType, LocalDateTime timestamp, String severityLevel) {
        this.id = id;
        this.event = event;
        this.updateContent = updateContent;
        this.updateType = updateType;
        this.timestamp = timestamp;
        this.severityLevel = severityLevel;
    }

    @PrePersist
    public void prePersist() {
        this.timestamp = LocalDateTime.now();
        if (this.severityLevel == null) {
            this.severityLevel = "LOW";
        }
    }

    // Getters and Setters
}
