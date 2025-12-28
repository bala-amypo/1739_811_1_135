package com.example.demo.dto;

public class EventUpdateRequest {

    private Long eventId;
    private String updateContent;
    private String updateType;

    public EventUpdateRequest() {
    }

    public EventUpdateRequest(Long eventId, String updateContent, String updateType) {
        this.eventId = eventId;
        this.updateContent = updateContent;
        this.updateType = updateType;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }
}
    