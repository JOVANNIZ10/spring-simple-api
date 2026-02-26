package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Book> books;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    public boolean bookExists(String from, String to, LocalDateTime time) {
        for(Book book: books){
            if(book.getRide().getOrigin().equals(from) && book.getRide().getDestination().equals(to) && book.getRide().getTime().equals(time)){
                return true;

            }

        }
        return false;
    }
}
