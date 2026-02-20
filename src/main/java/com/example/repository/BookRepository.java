package com.example.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Book;

public interface BookRepository extends JpaRepository <Book, UUID>  {

    Optional <Book> findAllUserBooks (UUID userId); 
}
