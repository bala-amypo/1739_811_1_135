package com.example.demo.entity;

import java.time.Instant;

public class Subscription {
    private Long id;
    private User user;
    private Event event;
    private Instant subscribedAt;

    public void onCreate() {
        subscribedAt = Instant.now();
    }

    public Long getId(){ return id;}
    public void setId(Long id){ this.id=id;}
    public User getUser(){ return user;}
    public void setUser(User u){ this.user=u;}
    public Event getEvent(){ return event;}
    public void setEvent(Event e){ this.event=e;}
    public Instant getSubscribedAt(){ return subscribedAt;}
}
