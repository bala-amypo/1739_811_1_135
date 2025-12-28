package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "event_updates")
public class EventUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String updateContent;

    @Enumerated(EnumType.STRING)
    private UpdateType updateType;

    private Instant timestamp;

    @Enumerated(EnumType.STRING)
    private SeverityLevel severityLevel;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @OneToMany(mappedBy = "eventUpdate")
    private List<BroadcastLog> logs;

    public EventUpdate() {}

    public EventUpdate(Long id, String updateContent, UpdateType updateType, Event event) {
        this.id = id;
        this.updateContent = updateContent;
        this.updateType = updateType;
        this.event = event;
    }

    @PrePersist
    public void onCreate() {
        this.timestamp = Instant.now();
        if (this.severityLevel == null) {
            this.severityLevel = SeverityLevel.LOW;
        }
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUpdateContent() { return updateContent; }
    public void setUpdateContent(String updateContent) { this.updateContent = updateContent; }

    public UpdateType getUpdateType() { return updateType; }
    public void setUpdateType(UpdateType updateType) { this.updateType = updateType; }

    public Instant getTimestamp() { return timestamp; }

    public SeverityLevel getSeverityLevel() { return severityLevel; }
    public void setSeverityLevel(SeverityLevel severityLevel) { this.severityLevel = severityLevel; }

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }
}
