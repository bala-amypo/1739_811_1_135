package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import com.example.demo.service.SubscriptionService;

import java.util.List;

public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository repo;
    private final UserRepository userRepo;
    private final EventRepository eventRepo;

    public SubscriptionServiceImpl(SubscriptionRepository r, UserRepository u, EventRepository e){
        repo=r; userRepo=u; eventRepo=e;
    }

    public Subscription subscribe(Long uid, Long eid){
        if(repo.existsByUserIdAndEventId(uid,eid))
            throw new BadRequestException("Already subscribed");
        User u=userRepo.findById(uid).orElseThrow();
        Event e=eventRepo.findById(eid).orElseThrow();
        Subscription s=new Subscription();
        s.setUser(u); s.setEvent(e);
        return repo.save(s);
    }

    public boolean isSubscribed(Long u, Long e){
        return repo.existsByUserIdAndEventId(u,e);
    }

    public void unsubscribe(Long u, Long e){
        Subscription s=repo.findByUserIdAndEventId(u,e)
                .orElseThrow(() -> new BadRequestException("Subscription not found"));
        repo.delete(s);
    }

    public List<Subscription> getUserSubscriptions(Long u){
        return repo.findByUserId(u);
    }
}
