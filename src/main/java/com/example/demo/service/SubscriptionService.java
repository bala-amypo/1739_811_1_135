package com.example.demo.service;

import com.example.demo.entity.Subscription;
import java.util.List;

public interface SubscriptionService {
    Subscription saveSubscription(Subscription subscription);
    List<Subscription> getSubscriptionsByUserId(Long userId);
}
