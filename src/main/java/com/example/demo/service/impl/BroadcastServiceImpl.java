package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.BroadcastService;

import java.util.List;

public class BroadcastServiceImpl implements BroadcastService {

    private final EventUpdateRepository updateRepo;
    private final SubscriptionRepository subRepo;
    private final BroadcastLogRepository logRepo;

    public BroadcastServiceImpl(EventUpdateRepository u, SubscriptionRepository s, BroadcastLogRepository b){
        updateRepo=u; subRepo=s; logRepo=b;
    }

    public void broadcastUpdate(Long updateId){
        EventUpdate u = updateRepo.findById(updateId).orElseThrow();
        List<Subscription> subs = subRepo.findByEventId(u.getEvent().getId());
        for(Subscription s:subs){
            BroadcastLog log=new BroadcastLog();
            log.setEventUpdate(u);
            log.setSubscriber(s.getUser());
            logRepo.save(log);
        }
    }

    public List<BroadcastLog> getLogsForUpdate(Long id){
        return logRepo.findByEventUpdateId(id);
    }

    public void recordDelivery(Long updateId, Long userId, boolean success){
        List<BroadcastLog> logs = logRepo.findByEventUpdateId(updateId);
        for(BroadcastLog l:logs){
            if(l.getSubscriber().getId().equals(userId)){
                l.setDeliveryStatus(success?DeliveryStatus.SENT:DeliveryStatus.FAILED);
                logRepo.save(l);
            }
        }
    }
}
