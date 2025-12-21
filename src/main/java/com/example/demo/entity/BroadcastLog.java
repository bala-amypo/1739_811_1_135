package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
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
    private User subscriber;

    private String deliveryStatus;

    private Timestamp sentAt = new Timestamp(System.currentTimeMillis());
}
