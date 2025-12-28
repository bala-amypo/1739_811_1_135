package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.*;

public interface BroadcastService {
    void broadcastUpdate(Long updateId);
    List<BroadcastLog> getLogsForUpdate(Long id);
    void recordDelivery(Long updateId, Long userId, boolean success);
}
