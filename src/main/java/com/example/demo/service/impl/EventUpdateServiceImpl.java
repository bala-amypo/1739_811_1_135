package com.example.demo.service.impl;

import com.example.demo.entity.EventUpdate;
import com.example.demo.repository.EventUpdateRepository;
import com.example.demo.service.EventUpdateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventUpdateServiceImpl implements EventUpdateService {

    private final EventUpdateRepository repository;

    public EventUpdateServiceImpl(EventUpdateRepository repository) {
        this.repository = repository;
    }

    @Override
    public EventUpdate publishUpdate(EventUpdate update) {
        return repository.save(update);
    }

    @Override
    public EventUpdate getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Update not found"));
    }

    @Override
    public List<EventUpdate> getAllUpdates() {
        return repository.findAll();
    }
}
