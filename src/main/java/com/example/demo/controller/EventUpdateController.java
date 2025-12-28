package com.example.demo.controller;

import com.example.demo.entity.EventUpdate;
import com.example.demo.service.EventUpdateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "EventUpdate")
@RestController
@RequestMapping("/api/updates")
public class EventUpdateController {

    private final EventUpdateService service;

    public EventUpdateController(EventUpdateService service) {
        this.service = service;
    }

    @Operation(summary = "Publish update")
    @PostMapping
    public ResponseEntity<EventUpdate> publish(@RequestBody EventUpdate update) {
        return ResponseEntity.status(201).body(service.publishUpdate(update));
    }

    @Operation(summary = "Get updates for event")
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<EventUpdate>> getByEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(service.getUpdatesForEvent(eventId));
    }

    @Operation(summary = "Get update by id")
    @GetMapping("/{id}")
    public ResponseEntity<EventUpdate> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUpdateById(id).orElseThrow());
    }

    @Operation(summary = "Get all updates")
    @GetMapping
    public ResponseEntity<List<EventUpdate>> getAll() {
        return ResponseEntity.ok(service.getAllUpdates());
    }
}
