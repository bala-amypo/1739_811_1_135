package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class BroadcastLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_update_id")
    private EventUpdate eventUpdate;

    @ManyToOne
    @JoinColumn(name = "subscriber_id")
    private User user;

    private String deliveryStatus;

    // ✅ Default constructor
    public BroadcastLog() {}

    // ✅ Parameterized constructor
    public BroadcastLog(Long id, EventUpdate eventUpdate,
                        User user, String deliveryStatus) {
        this.id = id;
        this.eventUpdate = eventUpdate;
        this.user = user;
        this.deliveryStatus = deliveryStatus;
    }

    // ✅ REQUIRED setters (tests call these)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public EventUpdate getEventUpdate() { return eventUpdate; }
    public void setEventUpdate(EventUpdate eventUpdate) {
        this.eventUpdate = eventUpdate;
    }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getDeliveryStatus() { return deliveryStatus; }
    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
