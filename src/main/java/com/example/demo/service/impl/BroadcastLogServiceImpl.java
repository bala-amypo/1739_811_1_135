package com.example.demo.service.impl;

import com.example.demo.entity.BroadcastLog;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BroadcastLogRepository;
import com.example.demo.service.BroadcastLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BroadcastLogServiceImpl implements BroadcastLogService {

    @Autowired
    private BroadcastLogRepository broadcastLogRepository;

    @Override
    public BroadcastLog createBroadcastLog(BroadcastLog broadcastLog) {
        return broadcastLogRepository.save(broadcastLog);
    }

    @Override
    public List<BroadcastLog> getAllBroadcastLogs() {
        return broadcastLogRepository.findAll();
    }

    @Override
    public BroadcastLog getBroadcastLogById(Long id) {
        return broadcastLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Broadcast log not found"));
    }
}
