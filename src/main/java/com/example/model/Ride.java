package com.example.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import com.example.exception.NotEnoughSeatsException;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rides")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Ride {
    
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(mappedBy = "ride", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Book> books;

    @Column(nullable = false)
    private String origin;

    @Column(nullable=false)
    private String destination; 

    @Column(nullable = false)
    private LocalDateTime time;

    @Column(nullable = false)
    private int availableSeats;

    public void bookSeats(int seats) {
        if (availableSeats < seats) {
            throw new NotEnoughSeatsException(this.id);
        }
        availableSeats -= seats;
    }

}
