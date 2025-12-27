package com.example.demo.controller;

import com.example.demo.entity.Subscription;
import com.example.demo.service.SubscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public Subscription create(@RequestBody Subscription subscription) {
        return subscriptionService.saveSubscription(subscription);
    }

    @GetMapping("/user/{userId}")
    public List<Subscription> getByUser(@PathVariable Long userId) {
        return subscriptionService.getSubscriptionsByUserId(userId);
    }
}
