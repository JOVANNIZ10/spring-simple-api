package com.example.model;

import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Book {
    
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "ride_id", nullable = false)
    private Ride ride;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean status = false;

    @Column(nullable = false, name = "time_reserved")
    private LocalTime time;

    @Column(nullable = false)
    private int seatsReserved;
    
}
