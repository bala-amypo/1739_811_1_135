package com.example.demo.entity;

public class BroadcastLog {
    private Long id;
    private EventUpdate eventUpdate;
    private User subscriber;
    private DeliveryStatus deliveryStatus = DeliveryStatus.SENT;

    public Long getId(){ return id;}
    public void setId(Long id){ this.id=id;}
    public EventUpdate getEventUpdate(){ return eventUpdate;}
    public void setEventUpdate(EventUpdate e){ this.eventUpdate=e;}
    public User getSubscriber(){ return subscriber;}
    public void setSubscriber(User u){ this.subscriber=u;}
    public DeliveryStatus getDeliveryStatus(){ return deliveryStatus;}
    public void setDeliveryStatus(DeliveryStatus d){ this.deliveryStatus=d;}
}
