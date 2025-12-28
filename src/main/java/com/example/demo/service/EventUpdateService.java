package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.*;

public interface EventUpdateService {
    List<EventUpdate> getUpdatesForEvent(Long id);
}
