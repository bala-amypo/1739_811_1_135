package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.*;

public interface EventService {
    Event createEvent(Event e);
    Event updateEvent(Long id, Event e);
    void deactivateEvent(Long id);
    List<Event> getActiveEvents();
    Event getById(Long id);
}
