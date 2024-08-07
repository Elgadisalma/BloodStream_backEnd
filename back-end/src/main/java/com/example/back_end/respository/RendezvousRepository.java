package com.example.back_end.respository;

import com.example.back_end.entity.Rendezvous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RendezvousRepository extends JpaRepository<Rendezvous, Long> {
    List<Rendezvous> findByUserId(Long userId);
}
