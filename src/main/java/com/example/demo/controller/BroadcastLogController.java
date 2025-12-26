package com.example.demo.controller;

import com.example.demo.entity.BroadcastLog;
import com.example.demo.service.BroadcastLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/broadcast-logs")
public class BroadcastLogController {

    @Autowired
    private BroadcastLogService broadcastLogService;

    @PostMapping
    public BroadcastLog createBroadcastLog(@RequestBody BroadcastLog broadcastLog) {
        return broadcastLogService.createBroadcastLog(broadcastLog);
    }

    @GetMapping
    public List<BroadcastLog> getAllBroadcastLogs() {
        return broadcastLogService.getAllBroadcastLogs();
    }

    @GetMapping("/{id}")
    public BroadcastLog getBroadcastLogById(@PathVariable Long id) {
        return broadcastLogService.getBroadcastLogById(id);
    }
}
