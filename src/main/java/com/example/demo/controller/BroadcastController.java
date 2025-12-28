package com.example.demo.controller;

import com.example.demo.entity.BroadcastLog;
import com.example.demo.service.BroadcastService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Broadcast")
@RestController
@RequestMapping("/api/broadcasts")
public class BroadcastController {

    private final BroadcastService service;

    public BroadcastController(BroadcastService service) {
        this.service = service;
    }

    @Operation(summary = "Trigger broadcast")
    @PostMapping("/trigger/{updateId}")
    public ResponseEntity<Void> trigger(@PathVariable Long updateId) {
        service.broadcastUpdate(updateId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Logs for update")
    @GetMapping("/logs/{updateId}")
    public ResponseEntity<List<BroadcastLog>> logs(@PathVariable Long updateId) {
        return ResponseEntity.ok(service.getLogsForUpdate(updateId));
    }

    @Operation(summary = "All logs")
    @GetMapping
    public ResponseEntity<List<BroadcastLog>> all() {
        return ResponseEntity.ok(service.getAllLogs());
    }
}
