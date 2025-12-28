package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "broadcast_logs")
public class BroadcastLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_update_id", nullable = false)
    private EventUpdate eventUpdate;

    @ManyToOne
    @JoinColumn(name = "subscriber_id", nullable = false)
    private User subscriber;

    @Column(nullable = false)
    private String deliveryStatus;

    @Column(nullable = false)
    private LocalDateTime sentAt;

    public BroadcastLog() {
    }

    public BroadcastLog(Long id, EventUpdate eventUpdate, User subscriber,
                        String deliveryStatus, LocalDateTime sentAt) {
        this.id = id;
        this.eventUpdate = eventUpdate;
        this.subscriber = subscriber;
        this.deliveryStatus = deliveryStatus;
        this.sentAt = sentAt;
    }

    @PrePersist
    public void prePersist() {
        this.sentAt = LocalDateTime.now();
        if (this.deliveryStatus == null) {
            this.deliveryStatus = "SENT";
        }
    }

    // Getters and Setters
}
