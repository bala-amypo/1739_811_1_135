package com.example.demo.service;

import com.example.demo.entity.EventUpdate;
import java.util.List;

public interface EventUpdateService {

    EventUpdate publishUpdate(EventUpdate update);

    EventUpdate getById(Long id);

    List<EventUpdate> getUpdatesForEvent(Long eventId);

    // REQUIRED BY CONTROLLER
    List<EventUpdate> getAllUpdates();

    EventUpdate getUpdateById(Long id);
}
