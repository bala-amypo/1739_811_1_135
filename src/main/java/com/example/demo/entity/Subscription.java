package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String channel; // EMAIL / SMS / PUSH

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
