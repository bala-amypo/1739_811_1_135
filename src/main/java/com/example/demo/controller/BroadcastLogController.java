package com.example.demo.controller;

import com.example.demo.entity.BroadcastLog;
import com.example.demo.repository.BroadcastLogRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/broadcast-logs")
public class BroadcastLogController {

    private final BroadcastLogRepository broadcastLogRepository;

    public BroadcastLogController(BroadcastLogRepository broadcastLogRepository) {
        this.broadcastLogRepository = broadcastLogRepository;
    }

    @PostMapping
    public BroadcastLog create(@RequestBody BroadcastLog log) {
        return broadcastLogRepository.save(log);
    }

    @GetMapping
    public List<BroadcastLog> getAll() {
        return broadcastLogRepository.findAll();
    }

    @GetMapping("/{id}")
    public BroadcastLog getById(@PathVariable Long id) {
        return broadcastLogRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public BroadcastLog update(@PathVariable Long id, @RequestBody BroadcastLog log) {
        log.setId(id);
        return broadcastLogRepository.save(log);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        broadcastLogRepository.deleteById(id);
    }
}
