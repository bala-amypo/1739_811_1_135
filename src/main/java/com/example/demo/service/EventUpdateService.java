package com.example.demo.service;

import com.example.demo.entity.EventUpdate;

import java.util.List;

public interface EventUpdateService {

    EventUpdate createUpdate(EventUpdate update);

    EventUpdate getUpdateById(Long id); // Required by EventUpdateController

    List<EventUpdate> getUpdatesForEvent(Long eventId); // Required by EventUpdateController

    List<EventUpdate> getAllUpdates(); // Required by EventUpdateController
}
