package com.example.demo.repository;

import com.example.demo.entity.*;
import java.util.*;

public interface EventRepository {
    Event save(Event e);
    Optional<Event> findById(Long id);
    void delete(Event e);
    List<Event> findByIsActiveTrue();
    List<Event> findByIsActiveTrueAndCategory(String c);
    List<Event> findByIsActiveTrueAndLocationContainingIgnoreCase(String loc);
}
