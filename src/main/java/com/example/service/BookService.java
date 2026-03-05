package com.example.service;

import java.time.LocalTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.dto.BookResponse;
import com.example.dto.CreateBookRequest;
import com.example.exception.RideNotFoundException;
import com.example.exception.UserNotFoundException;
import com.example.mapper.BookMapper;
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

    private final BookMapper bookMapper;
    
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final RideRepository rideRepository;

    @Transactional
    public BookResponse createBook(UUID userId, UUID rideId, CreateBookRequest req) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId)); 

        Ride ride = rideRepository.findById(rideId).orElseThrow(()-> new RideNotFoundException(userId));

        user.bookExists(rideId, ride.getOrigin(),ride.getDestination() ,ride.getTime());

        Book book = Book.builder()
                .user(user)
                .ride(ride)
                .seatsReserved(req.seatsReserved())
                .status(true)
                .time(LocalTime.now())
                .build();
        Book savedBook = bookRepository.save(book);
        return bookMapper.toBookResponse(savedBook);
    }
}
