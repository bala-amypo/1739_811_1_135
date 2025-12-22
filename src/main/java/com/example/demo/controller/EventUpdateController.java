package com.example.demo.controller;

import com.example.demo.entity.EventUpdate;
import com.example.demo.repository.EventUpdateRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventUpdateController {

    private final EventUpdateRepository eventUpdateRepository;

    public EventUpdateController(EventUpdateRepository eventUpdateRepository) {
        this.eventUpdateRepository = eventUpdateRepository;
    }

    @PostMapping
    public EventUpdate create(@RequestBody EventUpdate eventUpdate) {
        return eventUpdateRepository.save(eventUpdate);
    }

    @GetMapping
    public List<EventUpdate> getAll() {
        return eventUpdateRepository.findAll();
    }

    @GetMapping("/{id}")
    public EventUpdate getById(@PathVariable Long id) {
        return eventUpdateRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public EventUpdate update(@PathVariable Long id, @RequestBody EventUpdate eventUpdate) {
        eventUpdate.setId(id);
        return eventUpdateRepository.save(eventUpdate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eventUpdateRepository.deleteById(id);
    }
}
