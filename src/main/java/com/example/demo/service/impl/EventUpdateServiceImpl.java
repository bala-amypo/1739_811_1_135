package com.example.demo.service.impl;

import com.example.demo.entity.EventUpdate;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.EventUpdateRepository;
import com.example.demo.service.EventUpdateService;

import java.util.List;

public class EventUpdateServiceImpl implements EventUpdateService {

    private final EventUpdateRepository eventUpdateRepository;
    private final EventRepository eventRepository;

    public EventUpdateServiceImpl(EventUpdateRepository eventUpdateRepository,
                                  EventRepository eventRepository) {
        this.eventUpdateRepository = eventUpdateRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public EventUpdate publishUpdate(EventUpdate update) {
        return eventUpdateRepository.save(update);
    }

    @Override
    public List<EventUpdate> getUpdatesForEvent(Long eventId) {
        return eventUpdateRepository
                .findByEventIdOrderByTimestampAsc(eventId);
    }

    @Override
    public EventUpdate getById(Long id) {
        return eventUpdateRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "EventUpdate not found"));
    }
}
