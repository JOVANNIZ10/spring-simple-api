package com.example.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CreateRideRequest;
import com.example.dto.RideResponse;
import com.example.exception.PastRideDateException;
import com.example.exception.RideNotFoundException;
import com.example.exception.UserNotFoundException;
import com.example.mapper.RideMapper;
import com.example.model.Ride;
import com.example.model.User;
import com.example.repository.RideRepository;
import com.example.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RideService {
    
    private final RideRepository rideRepository;
    private final UserRepository userRepository;
    private final RideMapper rideMapper;

    @Transactional
    public void bookSeats(UUID rideId, int seats) {
        Ride ride = rideRepository.findById(rideId)
            .orElseThrow(() -> new RideNotFoundException(rideId));
        
        ride.bookSeats(seats); 
        rideRepository.save(ride);
    }

    @Transactional
    public RideResponse createRide(UUID userId ,CreateRideRequest req) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

        isDateInThePast(req.rideDate());

        user.rideExists(req.origin(), req.destination(), req.rideDate());

        Ride ride = Ride.builder()
                .origin(req.origin())
                .destination(req.destination())
                .rideDate(req.rideDate())
                .availableSeats(req.availableSeats())
                .user(user)
                .build();

        rideRepository.save(ride);
        return  rideMapper.toRideResponse(ride);   

    }
    
    private void isDateInThePast(LocalDateTime dateTime) {
        if (dateTime.isBefore(LocalDateTime.now())) {
            throw new PastRideDateException();
        }
    }

}
