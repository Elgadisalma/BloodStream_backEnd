package com.example.back_end.respository;

import com.example.back_end.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}
