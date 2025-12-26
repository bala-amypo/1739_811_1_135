package com.example.demo.service;

import com.example.demo.entity.BroadcastLog;
import java.util.List;

public interface BroadcastLogService {

    BroadcastLog createBroadcastLog(BroadcastLog broadcastLog);

    List<BroadcastLog> getAllBroadcastLogs();

    BroadcastLog getBroadcastLogById(Long id);
}
