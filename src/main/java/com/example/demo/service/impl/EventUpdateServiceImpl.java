package com.example.demo.service.impl;

import com.example.demo.entity.EventUpdate;
import com.example.demo.repository.EventUpdateRepository;
import com.example.demo.service.EventUpdateService;

import java.util.List;

public class EventUpdateServiceImpl implements EventUpdateService {

    private final EventUpdateRepository repo;

    public EventUpdateServiceImpl(EventUpdateRepository r){ this.repo=r;}

    public List<EventUpdate> getUpdatesForEvent(Long id){
        return repo.findByEventIdOrderByTimestampAsc(id);
    }
}
