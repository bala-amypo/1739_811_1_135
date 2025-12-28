package com.example.demo.repository;

import com.example.demo.entity.BroadcastLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BroadcastLogRepository extends JpaRepository<BroadcastLog, Long> {

    List<BroadcastLog> findByEventUpdateId(Long eventUpdateId);

    List<BroadcastLog> findBySubscriberId(Long subscriberId);

    Optional<BroadcastLog> findById(Long id);

    List<BroadcastLog> findAll();
}
