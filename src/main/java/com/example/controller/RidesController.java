package com.example.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CreateRideRequest;
import com.example.dto.RideResponse;
import com.example.service.RideService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/rides")
@RequiredArgsConstructor
public class RidesController {
    private final RideService rideService;
    public ResponseEntity<RideResponse> create (@Valid @RequestBody CreateRideRequest req){
        var created = rideService.createRide(req);
        return ResponseEntity.status(201).body(created);
    }
    
}
