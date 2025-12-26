package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    @GetMapping("/update")
    public String updateEvent() {
        return "Event updated!";
    }
}
