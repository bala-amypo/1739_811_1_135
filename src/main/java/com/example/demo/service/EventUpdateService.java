package com.example.demo.service;

import com.example.demo.entity.EventUpdate;
import java.util.List;

public interface EventUpdateService {

    EventUpdate createEventUpdate(EventUpdate eventUpdate);

    List<EventUpdate> getAllEventUpdates();

    EventUpdate getEventUpdateById(Long id);
}
