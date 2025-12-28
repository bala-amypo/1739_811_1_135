package com.example.demo.controller;

import com.example.demo.entity.Subscription;
import com.example.demo.service.SubscriptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Subscription")
@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private final SubscriptionService service;

    public SubscriptionController(SubscriptionService service) {
        this.service = service;
    }

    @Operation(summary = "Subscribe")
    @PostMapping("/{eventId}")
    public ResponseEntity<Subscription> subscribe(
            @PathVariable Long eventId,
            @RequestParam Long userId) {
        return ResponseEntity.status(201)
                .body(service.subscribe(userId, eventId));
    }

    @Operation(summary = "Unsubscribe")
    @DeleteMapping("/{eventId}")
    public ResponseEntity<Void> unsubscribe(
            @PathVariable Long eventId,
            @RequestParam Long userId) {
        service.unsubscribe(userId, eventId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "User subscriptions")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Subscription>> userSubs(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getUserSubscriptions(userId));
    }

    @Operation(summary = "Check subscription")
    @GetMapping("/check/{userId}/{eventId}")
    public ResponseEntity<Boolean> check(
            @PathVariable Long userId,
            @PathVariable Long eventId) {
        return ResponseEntity.ok(service.isSubscribed(userId, eventId));
    }

    @Operation(summary = "All subscriptions")
    @GetMapping
    public ResponseEntity<List<Subscription>> all() {
        return ResponseEntity.ok(service.getAllSubscriptions());
    }
}
