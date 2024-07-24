package com.example.back_end.respository;

import com.example.back_end.entity.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CentreRepository extends JpaRepository<Centre, Long> {
    Optional<Centre> findByName(String name);
}