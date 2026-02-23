package com.example.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Ride;

public interface RideRepository extends JpaRepository <Ride, UUID> {
    Optional <Ride> findAllUserRides (UUID userId); 
}
