package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.BookResponse;
import com.example.repository.BookRepository;
import com.example.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BooksController {
    private final BookService bookservice;
    private final BookRepository bookRepository;
    @PostMapping
    public ResponseEntity<BookResponse> create

}
