package com.example.back_end.respository;

import com.example.back_end.entity.Don;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonRepository extends JpaRepository<Don, Long> {
    List<Don> findByUserId(Long userId);
}
