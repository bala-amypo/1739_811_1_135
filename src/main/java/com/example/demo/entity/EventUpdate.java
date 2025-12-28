package com.example.demo.entity;

import java.time.Instant;

public class EventUpdate {
    private Long id;
    private Event event;
    private Instant timestamp;
    private SeverityLevel severityLevel;

    public void onCreate() {
        timestamp = Instant.now();
        if(severityLevel == null) severityLevel = SeverityLevel.LOW;
    }

    // getters & setters
    public Long getId(){ return id;}
    public void setId(Long id){ this.id=id;}
    public Event getEvent(){ return event;}
    public void setEvent(Event e){ this.event=e;}
    public Instant getTimestamp(){ return timestamp;}
    public SeverityLevel getSeverityLevel(){ return severityLevel;}
    public void setSeverityLevel(SeverityLevel s){ this.severityLevel=s;}
}
