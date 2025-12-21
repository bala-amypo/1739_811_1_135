package com.example.demo.service;

import com.example.demo.entity.BroadcastLog;
import com.example.demo.entity.EventUpdate;
import com.example.demo.entity.Subscription;
import com.example.demo.repository.BroadcastLogRepository;
import org.springframework.stereotype.Service;

@Service
public class BroadcastService {

    private final BroadcastLogRepository broadcastLogRepository;

    public BroadcastService(BroadcastLogRepository broadcastLogRepository) {
        this.broadcastLogRepository = broadcastLogRepository;
    }

    public BroadcastLog save(BroadcastLog log) {
        return broadcastLogRepository.save(log);
    }
}
