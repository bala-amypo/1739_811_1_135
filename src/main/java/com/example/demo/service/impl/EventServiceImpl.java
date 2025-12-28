package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import com.example.demo.service.EventService;

import java.util.List;

public class EventServiceImpl implements EventService {

    private final EventRepository eventRepo;
    private final UserRepository userRepo;

    public EventServiceImpl(EventRepository e, UserRepository u){
        this.eventRepo=e; this.userRepo=u;
    }

    public Event createEvent(Event e){
        User publisher = userRepo.findById(e.getPublisher().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if(publisher.getRole()!=Role.PUBLISHER && publisher.getRole()!=Role.ADMIN)
            throw new BadRequestException("Only PUBLISHER or ADMIN can create");
        return eventRepo.save(e);
    }

    public Event updateEvent(Long id, Event updated){
        Event ex = eventRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        ex.setTitle(updated.getTitle());
        ex.setDescription(updated.getDescription());
        ex.setLocation(updated.getLocation());
        ex.setCategory(updated.getCategory());
        return eventRepo.save(ex);
    }

    public void deactivateEvent(Long id){
        Event e = eventRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        e.setActive(false);
        eventRepo.save(e);
    }

    public List<Event> getActiveEvents(){ return eventRepo.findByIsActiveTrue(); }

    public Event getById(Long id){
        return eventRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }
}
