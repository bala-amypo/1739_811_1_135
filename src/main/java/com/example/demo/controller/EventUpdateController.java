package com.example.demo.controller;

import com.example.demo.entity.EventUpdate;
import com.example.demo.service.EventUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event-updates")
public class EventUpdateController {

    private final EventUpdateService service;

    public EventUpdateController(EventUpdateService service) {
        this.service = service;
    }

    // Publish a new update
    @PostMapping
    public ResponseEntity<EventUpdate> publishUpdate(@RequestBody EventUpdate update) {
        EventUpdate saved = service.createUpdate(update); // call the correct service method
        return ResponseEntity.ok(saved);
    }

    // Get update by ID
    @GetMapping("/{id}")
    public ResponseEntity<EventUpdate> getUpdateById(@PathVariable Long id) {
        EventUpdate update = service.getUpdateById(id); // call the service
        return ResponseEntity.ok(update);
    }

    // Get all updates
    @GetMapping
    public ResponseEntity<List<EventUpdate>> getAllUpdates() {
        List<EventUpdate> updates = service.getAllUpdates();
        return ResponseEntity.ok(updates);
    }

    // Get all updates for a specific event
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<EventUpdate>> getUpdatesForEvent(@PathVariable Long eventId) {
        List<EventUpdate> updates = service.getUpdatesForEvent(eventId);
        return ResponseEntity.ok(updates);
    }
}
