package com.example.demo.service;

import com.example.demo.entity.EventUpdate;
import java.util.List;

public interface EventUpdateService {

    EventUpdate createUpdate(EventUpdate update);

    List<EventUpdate> getUpdatesForEvent(Long eventId);

    EventUpdate getById(Long id);

    // 🔧 Required by controllers
    List<EventUpdate> getAllUpdates();

    EventUpdate getUpdateById(Long id);
}
