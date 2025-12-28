package com.example.demo.service.impl;

import com.example.demo.entity.BroadcastLog;
import com.example.demo.entity.EventUpdate;
import com.example.demo.entity.Subscription;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BroadcastLogRepository;
import com.example.demo.repository.EventUpdateRepository;
import com.example.demo.repository.SubscriptionRepository;
import com.example.demo.service.BroadcastService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BroadcastServiceImpl implements BroadcastService {

    private final BroadcastLogRepository broadcastLogRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final EventUpdateRepository eventUpdateRepository;

    public BroadcastServiceImpl(BroadcastLogRepository broadcastLogRepository,
                                SubscriptionRepository subscriptionRepository,
                                EventUpdateRepository eventUpdateRepository) {
        this.broadcastLogRepository = broadcastLogRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.eventUpdateRepository = eventUpdateRepository;
    }

    @Override
    public void broadcastUpdate(Long updateId) {
        EventUpdate update = eventUpdateRepository.findById(updateId)
                .orElseThrow(() -> new ResourceNotFoundException("Update not found"));

        List<Subscription> subs =
                subscriptionRepository.findByEventId(update.getEvent().getId());

        for (Subscription s : subs) {
            BroadcastLog log = new BroadcastLog();
            log.setEventUpdate(update);
            log.setSubscriber(s.getUser());
            log.setDeliveryStatus("SENT");
            broadcastLogRepository.save(log);
        }
    }

    @Override
    public List<BroadcastLog> getLogsForUpdate(Long updateId) {
        return broadcastLogRepository.findByEventUpdateId(updateId);
    }

    @Override
    public void recordDelivery(Long updateId, Long subscriberId, boolean successful) {
        BroadcastLog log = new BroadcastLog();
        log.setDeliveryStatus(successful ? "SENT" : "FAILED");
        broadcastLogRepository.save(log);
    }

    @Override
    public List<BroadcastLog> getAllLogs() {
        return broadcastLogRepository.findAll();
    }
}
