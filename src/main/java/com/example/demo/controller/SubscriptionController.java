package com.example.demo.controller;

import com.example.demo.entity.Subscription;
import com.example.demo.repository.SubscriptionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionController(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @PostMapping
    public Subscription create(@RequestBody Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @GetMapping
    public List<Subscription> getAll() {
        return subscriptionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Subscription getById(@PathVariable Long id) {
        return subscriptionRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Subscription update(@PathVariable Long id, @RequestBody Subscription subscription) {
        subscription.setId(id);
        return subscriptionRepository.save(subscription);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        subscriptionRepository.deleteById(id);
    }
}
