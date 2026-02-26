package com.example.service;

import java.time.LocalTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.dto.BookResponse;
import com.example.dto.CreateBookRequest;
import com.example.model.Book;
import com.example.model.Ride;
import com.example.model.User;
import com.example.repository.BookRepository;
import com.example.repository.RideRepository;
import com.example.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final RideRepository rideRepository;

    @Transactional
    public BookResponse createBook(UUID userId, UUID rideId,CreateBookRequest req) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found")); 

        Ride ride = rideRepository.findById(rideId).orElseThrow(()-> new RuntimeException("Ride not found"));

        Book book = Book.builder().user(user).ride(ride).time(LocalTime.now()).seatsReserved(req.seatsReserved()).build();
        return null;
    }
}
