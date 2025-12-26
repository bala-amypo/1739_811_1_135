package com.example.demo.service.impl;

import com.example.demo.entity.EventUpdate;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EventUpdateRepository;
import com.example.demo.service.EventUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventUpdateServiceImpl implements EventUpdateService {

    @Autowired
    private EventUpdateRepository eventUpdateRepository;

    @Override
    public EventUpdate createEventUpdate(EventUpdate eventUpdate) {
        return eventUpdateRepository.save(eventUpdate);
    }

    @Override
    public List<EventUpdate> getAllEventUpdates() {
        return eventUpdateRepository.findAll();
    }

    @Override
    public EventUpdate getEventUpdateById(Long id) {
        return eventUpdateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event update not found"));
    }
}
