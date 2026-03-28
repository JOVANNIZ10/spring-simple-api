package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import com.example.exception.BookAlreadyExistsException;
import com.example.exception.RideAlreadyExistsException;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Book> books;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Ride> rides;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email; 

    public void bookExists(UUID rideId, String from, String to, LocalDateTime time) {
        boolean exists=false;
        for(Book book: books){
            if(book.getRide().getOrigin().equals(from) && book.getRide().getDestination().equals(to) && book.getRide().getRideDate().equals(time)){
                exists=true;
                break;
            }
        }
        if(exists){
            throw new BookAlreadyExistsException(rideId, this.id);
        }
    }
    public void rideExists(String from, String to, LocalDateTime time) {
        boolean exists=false;
        for(Ride ride: rides){
            if(ride.getOrigin().equals(from) && ride.getDestination().equals(to) && ride.getRideDate().equals(time)){
                exists=true;
                break;
            }
        }
        if(exists){
            throw new RideAlreadyExistsException();
        }

    }
}
