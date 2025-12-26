package com.example.demo.service;

import com.example.demo.entity.Subscription;
import java.util.List;

public interface SubscriptionService {

    Subscription createSubscription(Subscription subscription);

    List<Subscription> getAllSubscriptions();

    Subscription getSubscriptionById(Long id);
}
