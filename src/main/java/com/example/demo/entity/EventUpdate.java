package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EventUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private String updateMessage;
    private LocalDateTime timestamp;

    // ✅ Default constructor
    public EventUpdate() {}

    // ✅ Parameterized constructor
    public EventUpdate(Long id, Event event,
                       String updateMessage, LocalDateTime timestamp) {
        this.id = id;
        this.event = event;
        this.updateMessage = updateMessage;
        this.timestamp = timestamp;
    }

    // ✅ REQUIRED methods
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }

    public String getUpdateMessage() { return updateMessage; }
    public void setUpdateMessage(String updateMessage) {
        this.updateMessage = updateMessage;
    }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
