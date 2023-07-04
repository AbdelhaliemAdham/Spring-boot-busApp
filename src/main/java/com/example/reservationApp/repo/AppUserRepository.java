package com.example.reservationApp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservationApp.entities.AppUsers;

public interface AppUserRepository  extends JpaRepository<AppUsers,Long> {
    
    Optional<AppUsers> findByUserName(String userName);
}
