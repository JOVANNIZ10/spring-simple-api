package com.example.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Book;

public interface BookRepository extends JpaRepository <Book, UUID>  {

     List<Book> findByUserId(UUID userId);
} 

