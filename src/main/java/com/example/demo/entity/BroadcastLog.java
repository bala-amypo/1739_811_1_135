package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "broadcast_logs")
public class BroadcastLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deliveryStatus; // SUCCESS / FAILED

    @ManyToOne
    @JoinColumn(name = "event_update_id")
    private EventUpdate eventUpdate;
}
