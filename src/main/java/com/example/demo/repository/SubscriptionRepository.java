package com.example.demo.repository;

import com.example.demo.entity.*;
import java.util.*;

public interface SubscriptionRepository {
    boolean existsByUserIdAndEventId(Long u, Long e);
    Subscription save(Subscription s);
    Optional<Subscription> findByUserIdAndEventId(Long u, Long e);
    void delete(Subscription s);
    List<Subscription> findByUserId(Long u);
    List<Subscription> findByEventId(Long e);
}
