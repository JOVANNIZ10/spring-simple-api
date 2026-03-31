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
    public BookResponse createBook(CreateBookRequest req) {
        User user = userRepository.findById(req.userId()).orElseThrow(() -> new UserNotFoundException(req.userId())); 

        Ride ride = rideRepository.findById(req.rideID()).orElseThrow(()-> new RideNotFoundException(req.rideID()));

        user.bookExists(req.rideID(), ride.getOrigin(),ride.getDestination() ,ride.getRideDate());

        ride.bookSeats(req.seatsReserved());

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
