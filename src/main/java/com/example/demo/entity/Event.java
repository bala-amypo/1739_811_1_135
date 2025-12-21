package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String location;

    private String category;

    private boolean isActive = true;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private User publisher;

    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
}
